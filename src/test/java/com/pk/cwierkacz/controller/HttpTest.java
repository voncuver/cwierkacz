package com.pk.cwierkacz.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Ignore;

@Ignore
public class HttpTest
{
    public static void main( String[] args ) throws URISyntaxException, ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();

        //HttpPost request = new HttpPost("http://localhost:8080/cwierkacz-0.0.1-SNAPSHOT/welcom.do?Action=Logout&FunctionalUserName=test");
        HttpPost request = new HttpPost("http://localhost:8080/cwierkacz-0.0.1-SNAPSHOT/welcom.do?Action=Create&FunctionalUserName=test&Password=test");

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder res = new StringBuilder();
        String line = "";
        while ( ( line = rd.readLine() ) != null ) {
            res.append(line);
        }

        System.out.println(res.toString());
    }
}
