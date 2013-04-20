package com.pk.cwierkacz.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.exception.ProcessingException;
import com.pk.cwierkacz.http.RequestBuilder;
import com.pk.cwierkacz.http.request.Request;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.model.transformer.JsonTransformer;
import com.pk.cwierkacz.processor.MainProcessor;

public class EntryServlet extends HttpServlet
{

    private final Logger logger = LoggerFactory.getLogger(EntryServlet.class);

    MainProcessor mainProcessor;

    public EntryServlet() {
        mainProcessor = MainProcessor.getInstance();
    }

    private static final long serialVersionUID = 1310933093609408261L;

    @Override
    public void doPost( HttpServletRequest req, HttpServletResponse resp ) throws javax.servlet.ServletException,
                                                                          IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        Map<String, String[]> parameters = request.getParameterMap();

        logger.debug(parameters.toString());

        Request requestAction = RequestBuilder.buildRequest(parameters);
        Response responseResult = mainProcessor.process(requestAction);

        String responseJson;
        try {
            responseJson = JsonTransformer.responseToJson(responseResult);
        }
        catch ( ProcessingException e ) {
            responseJson = "Fail to creat JSON";
        }
        ServletOutputStream out = response.getOutputStream();
        out.print(responseJson);
    }
}
