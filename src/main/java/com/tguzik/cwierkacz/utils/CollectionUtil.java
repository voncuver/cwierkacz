package com.tguzik.cwierkacz.utils;

import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class CollectionUtil
{
    public static < K, V > Map<K, V> safe( Map<K, V> value ) {
        return value == null ? ImmutableMap.<K, V> of() : value;
    }

    public static < T > Iterable<T> safe( Iterable<T> value ) {
        return value == null ? ImmutableList.<T> of() : value;
    }

    public static < K, V > ImmutableMap<K, V> copyToImmutableMap( Map<K, V> value ) {
        return value == null ? ImmutableMap.<K, V> of() : ImmutableMap.copyOf(value);
    }

    public static < T > ImmutableList<T> copyToImmutableList( Iterable<T> value ) {
        return value == null ? ImmutableList.<T> of() : ImmutableList.copyOf(value);
    }
}
