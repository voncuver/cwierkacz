package com.tguzik.cwierkacz.utils.cor;

public interface ChainOfResponsibility< M, N >
{
    void process( M state, N value ) throws Exception;
}
