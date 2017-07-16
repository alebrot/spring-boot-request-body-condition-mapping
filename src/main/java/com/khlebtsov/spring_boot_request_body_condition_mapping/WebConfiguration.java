package com.khlebtsov.spring_boot_request_body_condition_mapping;

import com.khlebtsov.spring_boot_request_body_condition_mapping.annotation.ChannelRequestMappingHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by khlebtsov on 7/16/2017.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new ChannelRequestMappingHandlerMapping();
    }
}