package com.tguzik.cwierkacz.utils.cor;

public abstract class AbstractChainElement< M, N > implements ChainOfResponsibility<M, N>
{
    private final AbstractChainElement<M, N> nextInChain;
    private final String name;

    public AbstractChainElement( final AbstractChainElement<M, N> nextInChain, final String name ) {
        this.nextInChain = nextInChain;
        this.name = name;
    }

    @Override
    public final void process( M state, N value ) throws Exception {
        processInner(state, value);
        if ( nextInChain != null ) {
            nextInChain.process(state, value);
        }
    }

    protected String getName( ) {
        return name;
    }

    protected abstract void processInner( M state, N value ) throws Exception;
}
