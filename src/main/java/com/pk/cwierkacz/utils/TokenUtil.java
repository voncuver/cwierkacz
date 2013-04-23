package com.pk.cwierkacz.utils;

import java.util.Random;

public class TokenUtil
{
    private static Random rand = new Random();

    public static Long getToken( ) {
        return (long) ( rand.nextDouble() * 10000000000L );
    }
}
