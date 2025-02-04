package org.example.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

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
 * @since 2024-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_info")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String price;

    private String factory;

    private String size;

    private String createTime;

    private String color;

    private String weight;


}
