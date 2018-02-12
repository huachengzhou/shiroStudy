package com.blue.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ShiroService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequiresRoles(value = {"admin"})//这里需要注意的是在目前ShiroService这种情况并未代理的,但是平常我们一般Service都是代理所以都是加到Controller上
    public void toShiroAnnotation() {
        Subject subject = SecurityUtils.getSubject();
        LocalDate local = LocalDate.now();
        logger.info("key:"+subject.getSession().getAttribute("zhou"));//证明shiro中的session和servlet中的是一致,key是com.blue.sping.controller.ShiroAnnotationController.testShiroAnnotation()中加入的
        logger.info("date:"+local.getYear()+"-"+local.getMonth()+"-"+local.getDayOfWeek());
    }
}
