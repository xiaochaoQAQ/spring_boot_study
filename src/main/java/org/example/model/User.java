package org.example.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2024-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String gender;

    private LocalDate birthday;

    private String idCard;

    private String nativePlace;

    private Integer politic;

    private String email;

    private String phone;

    private String address;

    private Integer college;

    private String specialty;

    @TableField("username")
    private String username;
    @TableField("password")
    private String password;

    private String userPic;
    private Integer age;


}
