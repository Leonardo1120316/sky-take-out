package com.sky.utils;

import com.sky.result.Result;

public class IsSuccessOperation {
    public static Result isSuccess(Integer result, String message){
        if(result >0){
            return Result.success();
        }else{
            return Result.error(message);
        }
    }
}
