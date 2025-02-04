package org.example.controller;

import org.example.model.User;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/search")
public class TestController {
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String person(@RequestParam String name) {
        return name;
    }

//    路径参数传参
    @RequestMapping(path = "/personGet/{name}",method = RequestMethod.GET)
    public String personGet(@PathVariable String name){
        return "get-path"+name;
    }

    @RequestMapping(value = "/personPost", method = RequestMethod.POST)
    public String personPost(@RequestBody User user) {
        return "post--" + user.getName() + "--" + user.getAge();
    }

    @RequestMapping(value = "/personPut", method = RequestMethod.PUT)
    public String personPut(@RequestBody User user) {
        return "put--" + user.getName() + "--" + user.getAge();
    }

    @RequestMapping(value = "/personDelete/{id}", method = RequestMethod.DELETE)
    public String personDelete(@PathVariable String id) {
        return "delete--" + id;
    }

    @RequestMapping("/book")
    public String book() {
        return "2";
    }
}