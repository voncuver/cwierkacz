package com.pk.cwierkacz.ws;

import org.junit.Ignore;
import org.junit.Test;

import pl.edu.pk.ias.types.LoginRequest;
import pl.edu.pk.ias.types.LoginResponse;

import com.pk.cwierkacz.ws.client.IncorrectPasswordFault;
import com.pk.cwierkacz.ws.client.SocialServiceIntegration;
import com.pk.cwierkacz.ws.client.SocialServiceIntegrationImplService;
import com.pk.cwierkacz.ws.client.UserNotExistFault;

@Ignore
public class ServiceTest
{
    @Test
    public void simpleTest( ) throws IncorrectPasswordFault, UserNotExistFault {
        SocialServiceIntegrationImplService implService = new SocialServiceIntegrationImplService();

        SocialServiceIntegration ssiPort = implService.getSocialServiceIntegrationImplPort();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("Test");
        loginRequest.setPassword("Test");

        LoginResponse loginResponse = ssiPort.login(loginRequest);
        System.out.println(loginResponse.getToken());
    }

}
