package com.tguzik.cwierkacz.common.initialization.task;

import java.util.concurrent.Callable;

public interface InitializationTask< T > extends Callable<T>
{
    String getName( );
}
