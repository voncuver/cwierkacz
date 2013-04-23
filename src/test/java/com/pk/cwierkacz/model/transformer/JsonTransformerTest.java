package com.pk.cwierkacz.model.transformer;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.pk.cwierkacz.exception.ProcessingException;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.response.LoginResponse;
import com.pk.cwierkacz.http.response.ResponseImpl;

public class JsonTransformerTest
{

    @Test
    public void LoginResponseTest( ) throws ProcessingException {

        Set<String> accounts = new HashSet<>();
        accounts.add("First");
        accounts.add("Second");

        LoginResponse response = ResponseImpl.create(Status.OK, "ok", 1234l).buildLoginResponse(accounts);

        String responseJson = JsonTransformer.responseToJson(response);

        assertEquals("{\"status\":\"OK\",\"message\":\"ok\",\"tokenId\":1234,\"accounts\":[\"First\",\"Second\"]}",
                     responseJson);
    }
}
