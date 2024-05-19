package org.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.User;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: tangchao
 * \* Date: 2024/5/19
 * \* Time: 13:38
 * \* Description:
 * \
 */
@Mapper
public interface UserMapper {
    int insertUser(@Param("user") User user);
    int updateUser(@Param("user") User user);
    Page<User> userPage(@Param("page") Page<User> page);
}