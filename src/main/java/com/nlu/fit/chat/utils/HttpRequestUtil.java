package com.nlu.fit.chat.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpRequestUtil {
    private HttpRequestUtil() {
        // Private constructor to prevent instantiation
    }

    public static String getHttpRequestURL() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            return request.getRequestURL().toString();
        }
        return null;
    }
}