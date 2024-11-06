package com.sky.interceptor;

import com.sky.context.BaseContext;
import com.sky.utils.AppJwtUtil;
import com.sky.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    /**
     * 校验jwt
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        log.info("admin interception");
        System.out.println("请求到达admin拦截");
        //判断当前拦截到的是否为Controller方法或者是其他资源如静态资源
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //获取登录数据员工id
        String token = request.getHeader("token");
        if(token==null){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        Claims claims = JwtUtil.getClaimsBody(token);
        int i = JwtUtil.verifyToken(claims);
        if(i==1||i==2){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        Long id = Long.valueOf(claims.get("id").toString());
        if(id!=null){
            //用ThreadLocal对id进行存储
            BaseContext.setCurrentId(id);
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
