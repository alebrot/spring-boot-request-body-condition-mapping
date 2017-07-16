package com.khlebtsov.spring_boot_request_body_condition_mapping.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by khlebtsov on 7/16/2017.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChannelMapping {
    String[] value() default {};
}
