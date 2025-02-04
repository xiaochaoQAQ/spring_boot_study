package org.example.controller;

import org.example.model.Goods;
import org.example.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    IShoppingCartService shoppingCarService;

    @PostMapping("/addShoppingCart")
    public String addShoppingCar(@RequestBody Goods goods) {
        String message = "";
        boolean isSuccess = shoppingCarService.save(goods);
        if (isSuccess){
            message = "mybatis-plus添加成功";
        }else {
            message = "mybatis-plus添加失败";
        }
        return message;
    }

    @GetMapping("/showShoppingCart")
    public void showShoppingCart() {
    }

    @DeleteMapping("/deleteShoppingCart/{name}")
    public void deleteShoppingCart(@PathVariable String name) {
    }
}
