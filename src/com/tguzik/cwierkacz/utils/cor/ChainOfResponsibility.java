package com.tguzik.cwierkacz.utils.cor;

public interface ChainOfResponsibility< T >
{
    public void process( T value ) throws Exception;
}
