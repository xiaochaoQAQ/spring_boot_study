package org.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.RespBean;
import org.example.model.Order;
import org.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2024-06-22
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/getOrder")
    public Page<Order> getOrder(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "10") Integer size,
                                @RequestParam(required = false) String name) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        if (name != null && !"".equals(name)){
            wrapper.like("user_name",name);
        }
        Page<Order> page = new Page<>();
        page.setSize(size);
        page.setCurrent(currentPage);
        return orderService.page(page,wrapper);
    }


    @PostMapping("/addOrder")
    public RespBean addOrder(@RequestBody Order order) {
        try{
            orderService.save(order);
            return RespBean.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加成功");
        }

    }


    @PutMapping("/updateOrder")
    public RespBean updateInfo(@RequestBody Order order) {
        if (orderService.updateById(order)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteOrder/{id}")
    public RespBean deleteInfo(@PathVariable Integer id) {
        if (orderService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}

