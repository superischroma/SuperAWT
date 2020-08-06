package me.superischroma.superawt;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AWTProperties
{
    int backgroundRed() default 0;
    int backgroundGreen() default 0;
    int backgroundBlue() default 0;
    int framesPerSecond() default 60;
}