package com.example.pixels_app.exception.annotations;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.pixels_app.exception.UnauthorizedException;
import com.example.pixels_app.services.AuthorizationService;

@Aspect
@Component
public class AuthorizeAdminAspect {

    @Around("@annotation(AuthorizeAdmin)")
    public Object authorizeAdmin(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        if (!AuthorizationService.authorize(request)) {
            throw new UnauthorizedException();
        }

        return joinPoint.proceed();
    }
}
