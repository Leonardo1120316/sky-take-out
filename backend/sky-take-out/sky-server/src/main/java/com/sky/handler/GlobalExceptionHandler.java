package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 业务异常捕获
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}",ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理SQL异常
     * @param sqlException
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result exceptionHandler(SQLIntegrityConstraintViolationException sqlException){
        String message = sqlException.getMessage();
        if(message.contains("Duplicate entry")){
            String[] s = message.split(" ");
            String username = s[2];
            return Result.error(username+" "+ MessageConstant.ACOUNT_FOUND);
        }else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }

    /**
     * token过期异常
     * @param e
     * @return
     */
    @ExceptionHandler(ExpiredJwtException.class)
    public Result exceptionHandler(ExpiredJwtException e){
        e.printStackTrace();
        return Result.error("token过期");
    }
}
