package com.tguzik.cwierkacz.common.initialization.task;

import java.lang.reflect.Field;
import java.util.concurrent.Future;

import com.google.common.base.Objects;
import com.tguzik.cwierkacz.common.Initializable;
import com.tguzik.cwierkacz.common.initialization.InitializationState;

public class InitializeComponents implements InitializationTask<Void>
{
    private final Future<InitializationState> futureState;

    public InitializeComponents( Future<InitializationState> futureState ) {
        this.futureState = futureState;
    }

    @Override
    public Void call( ) throws Exception {
        InitializationState state = futureState.get();

        for ( Field field : InitializationState.class.getFields() ) {
            if ( Objects.equal(Future.class, field.getType()) ) {
                Future<?> future = (Future<?>) field.get(state);
                initializeFuture(future);
            }
        }

        return null;
    }

    private void initializeFuture( Future<?> future ) throws Exception {
        if ( future == null ) {
            return;
        }

        Object obj = future.get();

        if ( obj instanceof Iterable ) {
            initializeIterable((Iterable<?>) obj);
        }
        else {
            initializeObject(obj);
        }
    }

    private void initializeIterable( Iterable<?> iterable ) throws Exception {
        for ( Object obj : iterable ) {
            initializeObject(obj);
        }
    }

    private void initializeObject( Object obj ) throws Exception {
        if ( obj instanceof Initializable ) {
            ( (Initializable) obj ).initialize();
        }
    }

    @Override
    public String getName( ) {
        return "Components";
    }

}
