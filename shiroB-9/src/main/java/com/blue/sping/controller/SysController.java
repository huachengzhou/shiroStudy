package com.blue.sping.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/sys")
@Controller
public class SysController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String loginSys(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        logger.info("---------------------------->param:" + username + "," + password);

        if ((username!=null&username.length()>0)&(password!=null&password.length()>0)){//param 校验
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            /*rememberme*/
            token.setRememberMe(true);
            try {
                subject.login(token);
                logger.info("login success");
            }catch (AuthenticationException e){
                logger.error("login fail "+e.getMessage());
                return "redirect:/login.jsp";
            }
        }


        String path = "" + "list" + ".jsp";
        return path;
    }

    @RequestMapping(value = "/logout.action",method = RequestMethod.GET)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        logger.info("/sys/logout.action");
        return "redirect:/login.jsp";
    }
}
