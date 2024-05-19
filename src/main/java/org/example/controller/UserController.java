package org.example.controller;

import org.example.model.User;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: tangchao
 * \* Date: 2024/3/31
 * \* Time: 15:58
 * \* Description:
 * \get：查询
 * put：查询和保存
 * delete：删除
 */
@RestController
@RequestMapping("/user")
public class UserController {
//    @GetMapping(value = "/person")
//    public String person(@RequestParam String name) {
//        return name;
//    }
//
////    路径参数传参
//    @GetMapping(path = "/personGet/{name}")
//    public String personGet(@PathVariable String name){
//        return "get-path"+name;
//    }
//
//    @PostMapping(value = "/personPost")
//    public String personPost(@RequestBody User user) {
//        return "post--" + user.getName() + "--" + user.getAge();
//    }
//
//    @PutMapping(value = "/personPut")
//    public String personPut(@RequestBody User user) {
//        return "put--" + user.getName() + "--" + user.getAge();
//    }
//
//    @DeleteMapping(value = "/personDelete/{id}")
//    public String personDelete(@PathVariable String id) {
//        return "delete--" + id;
//    }

    @Autowired
    private IUserService userService;

    @PostMapping("/insertUser")
    public int insertUser(@RequestBody User user) {
        int result = userService.insertUser(user);
        return result;
    }
    @PostMapping("/updateUser")
    public int updateUser(@RequestBody User user) {
        int result = userService.updateUser(user);
        return result;
    }
}