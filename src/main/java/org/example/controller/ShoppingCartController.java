package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.model.Goods;
import org.example.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/updateShoppingCart")
    public String updateShoppingCart(@RequestBody Goods goods) {
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("goods_num",goods.getNum());
        updateWrapper.eq("shopping_car_id",goods.getShoppingCarId());
        shoppingCarService.update(updateWrapper);
        boolean isSuccess = shoppingCarService.update(updateWrapper);
        String message = "";
        if (isSuccess){
            message = "mybatis-plus修改成功";
        }else {
            message = "mybatis-plus修改失败";
        }
        return message;
    }

    @DeleteMapping("/deleteGoods/{shoppingCarId}")
    public String deleteGoods(@PathVariable String shoppingCarId) {
        boolean isSuccess = shoppingCarService.removeById(shoppingCarId);
        String message = "";
        if (isSuccess){
            message = "mybatis-plus删除成功";
        }else {
            message = "mybatis-plus删除失败";
        }
        return message;
    }

    @PostMapping("/selectShoppingCarList")
    public List<Goods> selectShoppingCarList(@RequestBody Goods goods) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("goods_name",goods.getName());
        List<Goods> list = shoppingCarService.list(queryWrapper);
        for (Goods tempGoods : list) {
            System.out.println(tempGoods.getName());
        }
        return list;
    }

    @PostMapping("/selectShoppingListLambda")
    public List<Goods> selectShoppingListLambda(@RequestBody Goods goods) {
        LambdaQueryWrapper<Goods> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Goods::getName,goods.getName());
        List<Goods> list = shoppingCarService.list(lambdaQueryWrapper);
        for (Goods tempGoods : list) {
            System.out.println(tempGoods.getName());
        }
        return list;
    }
    @PostMapping("/selectShoppingListLambdaA")
    public List<Goods> selectShoppingListLambdaA(@RequestBody Goods goods) {
        List<Goods> list = shoppingCarService.list(Wrappers.<Goods>lambdaQuery().like(Goods::getName, goods.getName()));
        return list;
    }

    @GetMapping("/selectShoppingCarPage")
    public Page<Goods> selectShoppingCarPage(@RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize) {
        Page<Goods> page = new Page<>();
        page.setPages(pageNum);
        page.setSize(pageSize);
        page = shoppingCarService.page(page);
        return page;
    }

    @GetMapping("/getGoodsById/{shoppingCartId}")
    public Goods getGoodsById(@PathVariable String shoppingCartId) {
        return shoppingCarService.getById(shoppingCartId);
    }

}
