package com.xinrui.shixun.xinruishop.web;

import com.xinrui.shixun.xinruishop.model.UserModel;
import com.xinrui.shixun.xinruishop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@Api(value = "LoginController", tags = "LoginController")
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "userLogin",tags={"LoginController"},produces = "application/json")
    @RequestMapping(value = "userLogin",method = RequestMethod.GET)
    public String userLogin(){
        return "you login success";
    }

    @ApiOperation(value = "registerUser",tags={"LoginController"},produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserModel")
    @RequestMapping(value = "registerUser",method = RequestMethod.POST)
    @ResponseBody
    public String registerUser(@RequestBody UserModel user){
        System.out.println("UserModel====="+user.getLoginName());

        return "ok";
    }

}
