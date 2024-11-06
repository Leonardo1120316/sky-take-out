package com.sky.utils;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * JwtUtil类
 * 设置token 超时时间，加密密匙，刷新时间
 * 配置了生成Jwt token的方法
 *
 * 配置了解析token 中的jwt claim，jwt header,jwt body的方法
 * 配置了生成密匙的方法
 * 配置了校验过期的方法
 *
 */

public class JwtUtil {
    //token有效期 1天
    private static final int TOKEN_TIME_OUT = 3_600;
    //加密key
    private static final String TOKEN_ENCRY_KEY = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";
    //最小刷新间隔（s）
    private static final int REFRESH_TIME = 300;

    //生产ID
    public static String getToken(Long id){
        Map<String, Object>claimMaps = new HashMap<>();
        claimMaps.put("id",id);
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()  //生成Jwt token
                .setId(UUID.randomUUID().toString()) //设置生成的jwt中的 uuid值 claims
                .setIssuedAt(new Date(currentTime))
                .setSubject("system")
                .setIssuer("auth")
                .setAudience("app")
                .compressWith(CompressionCodecs.GZIP)
                .signWith(SignatureAlgorithm.HS512, generalKey())
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 12 * 1000))
                .addClaims(claimMaps) //自定义 claims
                .compact();
    }

    /**
     * 获取token中的claims信息
     *
     * @param token
     * @return
     */
    private static Jws<Claims> getJws(String token){
        //该方法获取的是全部claims，包括头部和signature
        return Jwts.parser()  //返回jwtParser对象，该对象为一个工具类，包含解析jwt的方法如setSigningKey
                .setSigningKey(generalKey()) //设置解析用的加密key
                .parseClaimsJws(token); //解析带有签名的jwt
    }

    /**
     * 获取payload body 信息
     *
     * @param token
     * @return
     */
    public static Claims getClaimsBody(String token){
        try{
            //该方法获取的仅为body部分
            return getJws(token).getBody();
        }catch(ExpiredJwtException e){
            return null;
        }
    }

    /**
     * 获取header body 信息
     *
     * @param token
     * @return
     */
    public static JwsHeader  getHeaderBody(String token){
        return  getJws(token).getHeader();
    }

    /**
     * 是否过期
     *
     * @param claims
     * @return -1：有效，0：有效，1：过期，2：过期
     */
    public static int verifyToken(Claims claims){
        if(claims==null){
            return 1; //已经过期
        }
        try{
            claims.getExpiration()
                    .before(new Date());
            //需要刷新token
            if((claims.getExpiration().getTime()-System.currentTimeMillis())>REFRESH_TIME*1000){
                return -1; //有效且不需要刷新
            }else {
                return 0; //有效，但需要刷新
            }
        }catch (ExpiredJwtException ex){
            return 1; //已经过期，这个捕获为claims.getExpiration 获取数值后比较，before函数抛出的异常
        }catch(Exception e){
            return 2; //其他异常
        }
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(TOKEN_ENCRY_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args){
        System.out.println(JwtUtil.getToken(1102L));
        Jws<Claims> jws = JwtUtil.getJws("eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAADWLQQqEMAwA_5KzhURNt_qb1KZYQSi0wi6Lf9942NsMw3zh6AVW2DYmDGl2WabkZgreCaM6VXzhFBfJMcMARTqsxIG9Z888QLui3e3Tup5Pb81013KKmVzJTGo11nf9n8v4nMUaEY73DzTabjmDAAAA.4SuqQ42IGqCgBai6qd4RaVpVxTlZIWC826QA9kLvt9d-yVUw82gU47HDaSfOzgAcloZedYNNpUcd18Ne8vvjQA");
        Claims claims = jws.getBody();
        System.out.println(claims.get("id"));
    }
}
