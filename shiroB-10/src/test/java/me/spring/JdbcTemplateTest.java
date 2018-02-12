package me.spring;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    private ApplicationContext context = null;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void jdbcTemplateTest() throws Exception {
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        logger.info(jdbcTemplate + "");
    }

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }
}
