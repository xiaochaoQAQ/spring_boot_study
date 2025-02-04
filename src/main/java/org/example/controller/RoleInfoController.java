package org.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.RespBean;
import org.example.model.RoleInfo;
import org.example.service.IRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/role")
public class RoleInfoController {
    @Autowired
    private IRoleInfoService roleService;


    @GetMapping("/getRole")
    public Page<RoleInfo> getRole(@RequestParam(defaultValue = "1") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(required = false) String name
    ) {
        QueryWrapper<RoleInfo> wrapper = new QueryWrapper<>();
        if (name != null && !"".equals(name)){
            wrapper.like("name",name);
        }
        Page<RoleInfo> page = new Page<>();
        page.setSize(size);
        page.setCurrent(currentPage);
        return roleService.page(page,wrapper);
    }





    @PostMapping("/addRole")
    public RespBean addRole(@RequestBody RoleInfo roleInfo) {
        try{
            roleService.save(roleInfo);
            return RespBean.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加成功");
        }

    }

    @PutMapping("/updateRole")
    public RespBean updateRole(@RequestBody RoleInfo roleInfo) {
        if (roleService.updateById(roleInfo)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteRole/{id}")
    public RespBean deleteRole(@PathVariable Integer id) {
        if (roleService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

