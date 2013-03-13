package com.tguzik.cwierkacz.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target( {ElementType.TYPE, ElementType.FIELD} )
public @interface Threadsafe {

}
