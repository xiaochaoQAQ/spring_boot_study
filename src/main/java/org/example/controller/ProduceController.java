package org.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.RespBean;
import org.example.model.Produce;
import org.example.service.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2024-06-22
 */
@RestController
@RequestMapping("/produce")
public class ProduceController {
    @Autowired
    private IProduceService produceService;

    @GetMapping("/getProduce")
    public Page<Produce> getProduce(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    @RequestParam(required = false) String name) {
        QueryWrapper<Produce> wrapper = new QueryWrapper<>();
        if (name != null && !"".equals(name)) {
            wrapper.like("product", name);
        }
        Page<Produce> page = new Page<>();
        page.setSize(size);
        page.setCurrent(currentPage);
        return produceService.page(page, wrapper);
    }


    @PostMapping("/addProduce")
    public RespBean addProduce(@RequestBody Produce produce) {
        try {
            produceService.save(produce);
            return RespBean.success("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("添加成功");
        }

    }


    @PutMapping("/updateProduce")
    public RespBean updateInfo(@RequestBody Produce produce) {
        if (produceService.updateById(produce)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteProduce/{id}")
    public RespBean deleteInfo(@PathVariable Integer id) {
        if (produceService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


}

