package com.pk.cwierkacz.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pk.cwierkacz.exception.ProcessingException;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.transformer.JsonTransformer;

public class ErrorServlet extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = -227196281703855928L;

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws javax.servlet.ServletException,
                                                                             IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        Response responseResult = ResponseImpl.create(Status.ERROR, "Wystąpił wewnętrzy bład aplikacji.", 0);

        String responseJson;
        try {
            responseJson = JsonTransformer.responseToJson(responseResult);
        }
        catch ( ProcessingException e ) {
            responseJson = "Fail to creat JSON";
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer out = response.getWriter();
        out.write(responseJson);
    }
}
