package com.pk.cwierkacz.model.transformer;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.pk.cwierkacz.exception.ProcessingException;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.LoginResponse;
import com.pk.cwierkacz.http.response.ResponseImpl;

public class JsonTransformerTest
{

    @Test
    public void LoginResponseTest( ) throws ProcessingException {

        List<String> accounts = Arrays.asList("First", "Second");
        LoginResponse response = ResponseImpl.create(Status.OK, "ok", 1234l).buildLoginResponse(accounts);

        String responseJson = JsonTransformer.responseToJson(response);

        assertEquals("{\"status\":\"OK\",\"message\":\"ok\",\"tokenId\":1234,\"accounts\":[\"First\",\"Second\"]}",
                     responseJson);
    }
}
