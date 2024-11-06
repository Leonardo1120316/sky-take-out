package com.sky.interceptor;

import com.sky.context.BaseContext;
import com.sky.utils.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.*;

/**
 * @Author Leonardo
 * @Description:
 *
 */
@Component
@Slf4j
public class JwtTokenUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        log.info("user interception");
        if(handler instanceof HandlerMethod){
            return true;
        }
        /**
         * 从请求头中获取token，并解析
         * authentication 前台传输过来的参数名称，不能变更，要跟前台保持一致
         */
        String token = request.getHeader("authentication");
        if(token!=null){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        //校验token
        Claims claims = AppJwtUtil.getClaimsBody(token);
        int i = AppJwtUtil.verifyToken(claims);
        if(i==1 || i==2){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        Long userId = Long.valueOf(claims.get("id").toString());
        if(userId!= null){
            BaseContext.setCurrentId(userId);
            return true;
        }else{
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        BaseContext.removeCurrentId();
    }
}
