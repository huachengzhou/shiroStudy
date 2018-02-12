package com.blue.common;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        /*顺序不能有错*/
        map.put("/sys/login.action","anon");
        map.put("/sys/logout.action","anon");
        map.put("/admin.jsp","authc,roles[admin]");
        map.put("/user.jsp","authc,roles[user]");

        map.put("/list.jsp","user");//使用记住我功能 rememberme

        map.put("/**","authc");
        return map;
    }
}
