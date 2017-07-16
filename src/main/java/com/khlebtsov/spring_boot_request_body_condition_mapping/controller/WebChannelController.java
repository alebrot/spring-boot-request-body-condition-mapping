package com.khlebtsov.spring_boot_request_body_condition_mapping.controller;

import com.khlebtsov.spring_boot_request_body_condition_mapping.annotation.ChannelMapping;
import com.khlebtsov.spring_boot_request_body_condition_mapping.dto.WebChannelRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by khlebtsov on 7/16/2017.
 */
@RestController
@ChannelMapping(value = "web")
@RequestMapping("/")
public class WebChannelController {
    @RequestMapping(value = "/channel", method = RequestMethod.POST)
    @ResponseBody
    public String showChannel(@RequestBody WebChannelRequest webChannelRequest) {
        return webChannelRequest.getChannel();
    }
}
