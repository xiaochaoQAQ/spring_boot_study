package org.example.pojo;

import lombok.Data;
import org.example.model.User;

@Data
public class LoginResult {
    private String tokenHead="bearer";
    private String token ;
    private User user;
}
