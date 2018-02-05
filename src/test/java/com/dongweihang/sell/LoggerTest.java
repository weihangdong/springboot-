package com.dongweihang.sell;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        String name = "dongweihang";
        String password = "123456";
        logger.info("info***************name = {},password = {}",name,password);
        logger.warn("warn***************name = {},password = {}",name,password);
        logger.error("error***************name = {},password = {}",name,password);
    }
}
