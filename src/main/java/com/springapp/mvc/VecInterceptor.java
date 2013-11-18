package com.springapp.mvc;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Enumeration;

public class VecInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = Logger.getLogger(VecInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle: startTime" + System.currentTimeMillis());

        stringSanitizer();
        headerSanitizer(request);
        bodySanitizer(request);

        return true;
    }

//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle: endTime" + System.currentTimeMillis());
//
//    }

    private void stringSanitizer() {
        //filter xss
        String xss = "hi <script src=\"#default\"><script>";
        log.info("before : " + xss);

        xss = UserInputSanitizer.sanitize(xss);
        log.info("after : " + xss);
    }

    private void headerSanitizer(HttpServletRequest request) {
        String header = null;
        Enumeration<?> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();

            //sanitizer
            log.info("- [header before] " + headerName + ": " + request.getHeader(headerName));
            log.info("- [header after] " + headerName + ": "
                    + UserInputSanitizer.sanitize(request.getHeader(headerName)));
        }
    }

    private void bodySanitizer(HttpServletRequest request) {

        String body = "";
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                body = body + line;
                jb.append(line);
            }

            //sanitizer
            log.info("- [body before] " + body);
            log.info("- [body after] " + UserInputSanitizer.sanitize(body));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
