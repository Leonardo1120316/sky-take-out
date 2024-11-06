package com.sky.utils;

import io.jsonwebtoken.Claims;

public class AppJwtUtil {
    public static String getToken(Long id){
        return JwtUtil.getToken(id);
    }

    public static Claims getClaimsBody(String token){
        return JwtUtil.getClaimsBody(token);
    }

    public static int verifyToken(Claims claims){
        return JwtUtil.verifyToken(claims);
    }
}
