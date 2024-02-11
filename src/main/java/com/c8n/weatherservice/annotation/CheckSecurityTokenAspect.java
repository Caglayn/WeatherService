package com.c8n.weatherservice.annotation;

import com.c8n.weatherservice.model.entity.AuthUser;
import com.c8n.weatherservice.service.CacheService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.c8n.weatherservice.constant.WeatherServiceConstant.AUTH_HEADER;
import static com.c8n.weatherservice.constant.WeatherServiceConstant.AUTH_USER;

@Slf4j
@Aspect
@Component
@Order(1)
public class CheckSecurityTokenAspect {
    private final CacheService cacheService;

    public CheckSecurityTokenAspect(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Around("@annotation(CheckSecurityToken)")
    public Object checkSecurityToken(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof HttpServletRequest request) {
                String token = getAuthHeaderFromRequest(request);
                if (token != null) {
                    AuthUser authUser = cacheService.getUserByCacheKey(token);
                    if (authUser != null){
                        request.setAttribute(AUTH_USER, authUser);
                        return proceed(joinPoint);
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
                }
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

    private Object proceed(ProceedingJoinPoint joinPoint){
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    public String getAuthHeaderFromRequest(HttpServletRequest request){
        return request.getHeader(AUTH_HEADER);
    }
}
