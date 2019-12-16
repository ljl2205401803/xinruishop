package com.xinrui.shixun.xinruishop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Component
@Aspect
public class WebLogRecord {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final static String logHeader = "web日志记录--";

    @Pointcut("execution(* com.xinrui.shixun.xinruishop.web.*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String methodName = pjp.getSignature().getName();
        Object[] paraArgs = pjp.getArgs();
        String queryString = Arrays.toString(paraArgs);
        log.info(logHeader + "请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);

        long start = System.currentTimeMillis();

        Object result = pjp.proceed();
        
		long end = System.currentTimeMillis();

        String errorMsg = String.format("请求地址：%s；响应时间：%d毫秒！！！", url, (end - start));
        log.info(logHeader + "请求结束:" + errorMsg);
        
        return result;
    }
}
