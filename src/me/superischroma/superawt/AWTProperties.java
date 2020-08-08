package me.superischroma.superawt;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AWTProperties
{
    String title() default "";
    boolean resizeable() default true;
    int width() default 200;
    int height() default 200;
    int fps() default 60;
    boolean clearOnUpdate() default true;
    boolean debug() default false;
    int objectClearLimit() default 500;
}