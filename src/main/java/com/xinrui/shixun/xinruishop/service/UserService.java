package com.xinrui.shixun.xinruishop.service;

import com.xinrui.shixun.xinruishop.model.UserModel;

public interface UserService {
    UserModel queryByUserId(Integer userId);
    int insertUser(UserModel userModel)throws Exception;
}
