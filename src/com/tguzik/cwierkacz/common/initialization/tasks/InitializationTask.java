package com.tguzik.cwierkacz.common.initialization.tasks;

import java.util.concurrent.Callable;

public interface InitializationTask< T > extends Callable<T>
{
    String getName( );
}
