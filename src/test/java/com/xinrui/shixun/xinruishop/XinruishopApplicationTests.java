package com.xinrui.shixun.xinruishop;

import com.xinrui.shixun.xinruishop.model.UserModel;
import com.xinrui.shixun.xinruishop.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class XinruishopApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(XinruishopApplicationTests.class);

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        UserModel userModel = userService.queryByUserId(12345);

        logger.debug("122222222222222222222222"+userModel.getLoginName());
    }

    @Test
    void insertUser(){
        UserModel userModel = new UserModel();
        userModel.setLoginName("ceshi");
        userModel.setLoginPasswd("2222");
        userModel.setUserType(1);
        userModel.setCreateTime(new Date());
        userModel.setUpdateTime(new Date());
        try {
            userService.insertUser(userModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
