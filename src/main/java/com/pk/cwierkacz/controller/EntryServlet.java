package com.pk.cwierkacz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pk.cwierkacz.model.http.Request;
import com.pk.cwierkacz.model.http.Response;
import com.pk.cwierkacz.model.transformer.JsonTransformer;
import com.pk.cwierkacz.processor.MainProcessor;

public class EntryServlet extends HttpServlet
{
    MainProcessor mainProcessor;

    public EntryServlet() {
        mainProcessor = MainProcessor.getInstance();
    }

    private static final long serialVersionUID = 1310933093609408261L;

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        PrintWriter out = response.getWriter();
        Request requestJob = JsonTransformer.jsonToRequest(request.getParameter("json"));

        Response responseResult = mainProcessor.process(requestJob);

        String responseJson = JsonTransformer.responseToJson(responseResult);

        out.print(responseJson);
    }
}
