package org.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.common.RespBean;
import org.example.model.User;
import org.example.service.ICaptchaService;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2024-05-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ICaptchaService captchaService;


    /**
     * 获取所有用户（分页）
     * @param currentPage
     * @param size
     * @param name
     * @return
     */
    @GetMapping("/getUser")
    public Page<User> getUser(@RequestParam(defaultValue = "1") Integer currentPage,
                              @RequestParam(defaultValue = "10") Integer size,
                              @RequestParam String name
                                   ) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (name != null && !"".equals(name)){
            wrapper.like("name",name);
        }
        Page<User> page = new Page<>();
        page.setSize(size);
        page.setCurrent(currentPage);
        return userService.page(page,wrapper);
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public RespBean addUser(@RequestBody User user) {
        try{
            userService.save(user);
            return RespBean.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加成功");
        }

    }

    @PutMapping("/updateUser")
    public RespBean updateUser(@RequestBody User user) {
        if (userService.updateById(user)) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteUser/{id}")
    public RespBean deleteUser(@PathVariable Integer id) {
        if (userService.removeById(id)) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


}

