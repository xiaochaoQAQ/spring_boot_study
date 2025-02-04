package org.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.RespBean;
import org.example.model.Info;
import org.example.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2024-06-02
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private IInfoService infoService;


    @GetMapping("/getInfo")
    public Page<Info> getInfo(@RequestParam(defaultValue = "1") Integer currentPage,
                              @RequestParam(defaultValue = "10") Integer size,
                              @RequestParam(required = false) String name
    ) {
        QueryWrapper<Info> wrapper = new QueryWrapper<>();
        if (name != null && !"".equals(name)){
            wrapper.like("name",name);
        }
        Page<Info> page = new Page<>();
        page.setSize(size);
        page.setCurrent(currentPage);
        return infoService.page(page,wrapper);
    }





    @PostMapping("/addInfo")
    public RespBean addInfo(@RequestBody Info info) {
        try{
            infoService.save(info);
            return RespBean.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加成功");
        }

    }

    @PutMapping("/updateInfo")
    public RespBean updateInfo(@RequestBody Info info) {
        if (infoService.updateById(info)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteInfo/{id}")
    public RespBean deleteInfo(@PathVariable Integer id) {
        if (infoService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

