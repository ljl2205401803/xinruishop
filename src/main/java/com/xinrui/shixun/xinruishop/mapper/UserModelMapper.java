package com.xinrui.shixun.xinruishop.mapper;

import com.xinrui.shixun.xinruishop.model.UserModel;

public interface UserModelMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}