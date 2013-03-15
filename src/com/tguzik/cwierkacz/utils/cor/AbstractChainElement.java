package com.tguzik.cwierkacz.utils.cor;

public abstract class AbstractChainElement< T > implements ChainOfResponsibility<T>
{
    private final AbstractChainElement<T> nextInChain;
    private final String name;

    public AbstractChainElement( final AbstractChainElement<T> nextInChain, final String name ) {
        this.nextInChain = nextInChain;
        this.name = name;
    }

    @Override
    final public void process( T value ) throws Exception {
        processInner(value);
        if ( nextInChain != null ) {
            nextInChain.process(value);
        }
    }

    protected String getName( ) {
        return name;
    }

    abstract protected void processInner( T value ) throws Exception;
}
