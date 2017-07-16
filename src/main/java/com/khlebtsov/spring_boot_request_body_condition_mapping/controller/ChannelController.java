package com.khlebtsov.spring_boot_request_body_condition_mapping.controller;

import com.khlebtsov.spring_boot_request_body_condition_mapping.annotation.ChannelMapping;
import com.khlebtsov.spring_boot_request_body_condition_mapping.dto.ChannelRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by khlebtsov on 7/16/2017.
 */
@RestController
@RequestMapping("/")
public class ChannelController {

    @ChannelMapping(value = "subscription")
    @RequestMapping(value = "/channel", method = RequestMethod.POST)
    public String showChannel(@RequestBody ChannelRequest channelRequest) {
        return channelRequest.getChannel();
    }


    @RequestMapping(value = "/channel", method = RequestMethod.POST)
    public String showOtherChannel(@RequestBody ChannelRequest channelRequest) {
        return channelRequest.getChannel();
    }
}
