package com.sky.utils;

import com.alibaba.fastjson.JSON;
import com.sky.properties.WeChatProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeChatLoginUtil {
    public static final String URL = "https://api.weixin.qq.com/sns/jscode2session";
    public static final String AUTHORIZATION = "authorization_code";

    @Autowired
    WeChatProperties weChatProperties;

    public String getOpenId(String code){
        HashMap<String,String> query = new HashMap<>();
        query.put("appid",weChatProperties.getAppid());
        query.put("secret",weChatProperties.getSecret());
        query.put("js_code",code);
        query.put("grant_type",AUTHORIZATION);
        String body = HttpClientUtil.doGet(URL, query);
        //解析body
        Map result = JSON.parseObject(body, Map.class);
        String openid = (String) result.get("openid");
        return openid;
    }
}
