package org.example.service;

import org.example.model.User;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: tangchao
 * \* Date: 2024/5/19
 * \* Time: 13:49
 * \* Description:
 * \
 */
public interface IUserService{
    int insertUser(User user);
    int updateUser(User user);
}