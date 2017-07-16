package com.khlebtsov.spring_boot_request_body_condition_mapping.annotation;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * Created by khlebtsov on 7/16/2017.
 */
public class ChannelRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        ChannelMapping typeAnnotation = AnnotationUtils.findAnnotation(handlerType, ChannelMapping.class);
        if (typeAnnotation != null) {
            return new ChannelRequestCondition(typeAnnotation.value());
        } else {
            return super.getCustomTypeCondition(handlerType);
        }
    }


    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        ChannelMapping typeAnnotation = AnnotationUtils.findAnnotation(method, ChannelMapping.class);
        if (typeAnnotation != null) {
            return new ChannelRequestCondition(typeAnnotation.value());
        } else {
            return super.getCustomMethodCondition(method);
        }
    }

}
