package com.mantao.springrest.interceptor;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Manito on 2019/3/20.
 */
@Aspect
@Slf4j
@Component
public class AspectControllerInterceptor {

    @Around("execution(* com.mantao.springrest.controller..*(..))")
    public Object logRequestInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        long in = System.currentTimeMillis();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String controllerClass = joinPoint.getTarget().getClass().getName();
        String controllerMethod = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        String param = getMethodArgs(arguments);
        String requestId = null;
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }
        log.info("Request Start. requestId: {}, url: {}, uri: {}, request method: {}, controller class: {}, controller method: {}, request params: {}", requestId, url, uri, method, controllerClass, controllerMethod, param);


        // print response param
        long ms = System.currentTimeMillis() -in;
        log.info("Request End. requestId: {}, controller class: {}, controller method: {}, response params: {}, spend_ms:{}", requestId, controllerClass, controllerMethod, JSON.toJSON(arguments), ms);

        return joinPoint.proceed();

    }

    private String getMethodArgs(Object[] args){
        StringBuilder sb = new StringBuilder();
        JSON json;
        for (int i = 0; i < args.length; i++) {
            json = new JSONObject();
            sb.append("arg[").append(i).append("]: ").append(json.toJSONString(args[i])).append(",");
        }
        if (args.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
