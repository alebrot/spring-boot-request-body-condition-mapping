package com.khlebtsov.spring_boot_request_body_condition_mapping.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khlebtsov.spring_boot_request_body_condition_mapping.dto.ChannelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by khlebtsov on 7/16/2017.
 */
public class ChannelRequestCondition implements RequestCondition<ChannelRequestCondition> {

    private static Logger logger = LoggerFactory.getLogger(ChannelRequestCondition.class);

    private final Set<String> channels;

    public ChannelRequestCondition(Collection<String> channels) {
        this.channels = Collections.unmodifiableSet(new HashSet<>(channels));
    }

    public ChannelRequestCondition(String... channels) {
        this(Arrays.asList(channels));
    }

    @Override
    public ChannelRequestCondition combine(ChannelRequestCondition other) {
        Set<String> allRoles = new LinkedHashSet<>(this.channels);
        allRoles.addAll(other.channels);
        return new ChannelRequestCondition(allRoles);
    }

    @Override
    public ChannelRequestCondition getMatchingCondition(HttpServletRequest request) {

        try {
            ServletInputStream inputStream = request.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            ChannelRequest controllerRequest = mapper.readValue(inputStream, ChannelRequest.class);

            String channel = controllerRequest.getChannel();
            if (this.channels.contains(channel)) {
                return this;
            }

        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }

        return null;
    }

    @Override
    public int compareTo(ChannelRequestCondition other, HttpServletRequest request) {
        if (other.channels.size() < this.channels.size()) {
            return -1;
        } else if (other.channels.size() > this.channels.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "ChannelRequestCondition{" +
                "channels=" + channels +
                '}';
    }
}
