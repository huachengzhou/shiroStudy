package com.blue.sping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Success {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/springmvc/test/success.action")
    public String success() {
        String path = "WEB-INF/" + "success" + ".jsp";
        logger.info("/springmvc/test/success.action");
        logger.info(path);
        return path;
    }
}
