package org.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: tangchao
 * \* Date: 2024/4/14
 * \* Time: 15:15
 * \* Description:
 * \商品
 */
@TableName("t_shopping_car")
@Data
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer shoppingCarId;

    @TableField("goods_name")
    private String name;

    @TableField("goods_num")
    private int num;




}