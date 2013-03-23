package com.tguzik.cwierkacz.utils.cor;

public interface ChainOfResponsibility< M, N >
{
    public void process( M state, N value ) throws Exception;
}
