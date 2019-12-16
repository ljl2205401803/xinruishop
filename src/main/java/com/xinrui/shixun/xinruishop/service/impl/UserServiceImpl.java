package com.xinrui.shixun.xinruishop.service.impl;

import com.xinrui.shixun.xinruishop.mapper.UserModelMapper;
import com.xinrui.shixun.xinruishop.model.UserModel;
import com.xinrui.shixun.xinruishop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel queryByUserId(Integer userId) {

        return userModelMapper.selectByPrimaryKey(userId);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int insertUser(UserModel userModel) throws Exception{

        int count = userModelMapper.insertSelective(userModel);
        int a = 3/0;
        int count2 = userModelMapper.insertSelective(userModel);

        return count2;
    }
}
