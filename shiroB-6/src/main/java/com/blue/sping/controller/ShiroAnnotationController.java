package com.blue.sping.controller;

import com.blue.common.ShiroService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/shiro")
@Controller
public class ShiroAnnotationController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShiroService shiroService;


    @RequiresRoles(value = {"admin"})
    @RequestMapping(value = "/testShiroAnnotation.action")
    public String testShiroAnnotation() {
        logger.info("/shiro/testShiroAnnotation");
        shiroService.toShiroAnnotation();
        return "redirect:/list.jsp";
    }
}
