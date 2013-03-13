package com.tguzik.cwierkacz.utils.cor;


public abstract class AbstractChainElement< T > implements ChainOfResponsibility<T>
{
    private final AbstractChainElement<T> nextInChain;

    public AbstractChainElement( final AbstractChainElement<T> nextInChain ) {
        this.nextInChain = nextInChain;
    }

    @Override
    final public void process( T value ) throws Exception {
        processInner(value);
        if ( nextInChain != null ) {
            nextInChain.process(value);
        }
    }

    abstract protected void processInner( T value ) throws Exception;

    abstract String getName( );
}
