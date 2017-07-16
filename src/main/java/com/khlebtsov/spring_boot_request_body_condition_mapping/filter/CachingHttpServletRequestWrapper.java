package com.khlebtsov.spring_boot_request_body_condition_mapping.filter;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by khlebtsov on 7/16/2017.
 */
public class CachingHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public CachingHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            body = StreamUtils.copyToByteArray(request.getInputStream());
        } catch (IOException ex) {
            body = new byte[0];
        }

    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener arg0) {
            }
        };

    }
}
