package com.pk.cwierkacz.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.pk.cwierkacz.exception.ProcessingException;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.model.transformer.JsonTransformer;

public class EntryServlet extends HttpServlet
{
    private final SecurityController securityController;

    public EntryServlet() {
        securityController = new SecurityController();
    }

    private static final long serialVersionUID = 1310933093609408261L;

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws javax.servlet.ServletException,
                                                                             IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        Cookie[] cookies = request.getCookies();
        Map<String, String[]> parameters = new HashMap<String, String[]>();

        for ( String param : request.getParameterMap().keySet() ) {
            parameters.put(param.toLowerCase(), request.getParameterMap().get(param));
        }

        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                parameters.put(cookie.getName().toLowerCase(), new String[] {cookie.getValue()});
            }
        }

        ServletInputStream bodyStream = request.getInputStream();

        byte body[] = null;
        if ( bodyStream != null )
            body = IOUtils.toByteArray(bodyStream);

        Response responseResult = securityController.handle(parameters, body).getResponse();

        String responseJson;
        try {
            responseJson = JsonTransformer.responseToJson(responseResult);
        }
        catch ( ProcessingException e ) {
            responseJson = "Fail to creat JSON";
        }

        if ( parameters.containsKey("callback") ) {
            responseJson = parameters.get("callback")[ 0 ] + "(" + responseJson + ");";
        }

        Cookie cookie = new Cookie("token", new Long(responseResult.getTokenId()).toString());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer out = response.getWriter();
        out.write(responseJson);
    }
}
