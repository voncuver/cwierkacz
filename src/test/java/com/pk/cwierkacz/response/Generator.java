package com.pk.cwierkacz.response;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.schema.JsonSchema;
import org.junit.Test;

import com.pk.cwierkacz.http.response.FetchMessagesResponse;
import com.pk.cwierkacz.http.response.LoginResponse;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.dto.Message;

public class Generator
{

    @Test
    public void generateSimpleResponse( ) throws JsonMappingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonSchema jsonSchema = mapper.generateJsonSchema(Response.class);
        System.out.println("Response:");
        System.out.println("");
        System.out.println(jsonSchema.toString());
        System.out.println("");
        System.out.println("======================");
    }

    @Test
    public void generateLoginResponse( ) throws JsonMappingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonSchema jsonSchema = mapper.generateJsonSchema(LoginResponse.class);
        System.out.println("Login Response:");
        System.out.println("");
        System.out.println(jsonSchema.toString());
        System.out.println("");
        System.out.println("======================");
    }

    @Test
    public void generateFetchResponse( ) throws JsonMappingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonSchema jsonSchema = mapper.generateJsonSchema(FetchMessagesResponse.class);
        System.out.println("Fetch Response:");
        System.out.println("");
        System.out.println(jsonSchema.toString());
        System.out.println("");
        System.out.println("======================");
    }

    @Test
    public void generateMessageResponse( ) throws JsonMappingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonSchema jsonSchema = mapper.generateJsonSchema(Message.class);
        System.out.println("Message:");
        System.out.println("");
        System.out.println(jsonSchema.toString());
        System.out.println("");
        System.out.println("======================");
    }
}
