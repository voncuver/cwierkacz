package com.pk.cwierkacz.ws;

import org.junit.Test;

import pl.edu.pk.ias.socialserviceintegration.InvalidLoginOrPasswordFault;
import pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration;
import pl.edu.pk.ias.types.LoginRequest;
import pl.edu.pk.ias.types.LoginResponse;

import com.pk.cwierkacz.ws.client.SocialServiceIntegrationImplService;

public class ServiceTest
{
    @Test
    public void simpleTest( ) throws InvalidLoginOrPasswordFault {
        SocialServiceIntegrationImplService implService = new SocialServiceIntegrationImplService("https://37.28.156.233:8181/FilckrIAS/services/integration/socialserviceintegration");

        SocialServiceIntegration ssiPort = implService.getSocialServiceIntegrationImplPort();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("Test");
        loginRequest.setPassword("Test");

        LoginResponse loginResponse = ssiPort.login(loginRequest);
        System.out.println(loginResponse.getToken());
    }

}
