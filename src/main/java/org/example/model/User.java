package org.example.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: tangchao
 * \* Date: 2024/4/14
 * \* Time: 13:47
 * \* Description:
 * \
 */
@Data
public class User {
    private int userId;
    private String userName;
    private String userRemark;
    private String userState;
}