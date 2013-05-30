package com.pk.cwierkacz.ws;

import org.junit.Test;

import pl.edu.pk.ias.socialserviceintegration.InvalidLoginOrPasswordFault;
import pl.edu.pk.ias.socialserviceintegration.SocialServiceIntegration_Service;
import pl.edu.pk.ias.types.LoginRequest;
import pl.edu.pk.ias.types.LoginResponse;

public class ServiceTest
{
    @Test
    public void simpleTest( ) throws InvalidLoginOrPasswordFault {
        SocialServiceIntegration_Service implService = new SocialServiceIntegration_Service();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("Test");
        loginRequest.setPassword("Test");

        LoginResponse loginResponse = implService.getSocialServiceIntegrationEndpoint().login(loginRequest);

        System.out.println(loginResponse.getToken());
    }

}
