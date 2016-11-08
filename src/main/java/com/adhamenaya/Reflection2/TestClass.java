package com.adhamenaya.Reflection2;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

/**
 * Created by AENAYA on 08/11/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestClass {

    public String date();

    public String tester();

    public String[] tags();
}
