package com.tguzik.cwierkacz.application.initialization;

import java.util.concurrent.Callable;

public interface InitializationTask< T > extends Callable<T>
{
    String getName( );
}
