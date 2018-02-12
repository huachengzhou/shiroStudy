package com.blue.common;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ShiroService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequiresRoles(value = {"admin"})//这里需要注意的是在目前ShiroService这种情况并未代理的,但是平常我们一般Service都是代理所以都是加到Controller上
    public void toShiroAnnotation() {
        LocalDate local = LocalDate.now();
        logger.info("date:"+local.getYear()+"-"+local.getMonth()+"-"+local.getDayOfYear());
    }
}
