package com.blue.sping.controller;

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
    public String loginSys(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) throws Exception {
        logger.info("---------------------------->param:" + username + "," + password);
        // shiro 判断然后自动跳转　不需要我们写view (加入Subject　校验以后)
        String path = "" + "list" + ".jsp";
        return path;
    }
}
