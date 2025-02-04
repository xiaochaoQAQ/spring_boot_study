package org.example.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品
 */
@Data
@TableName("t_shopping_car")
public class Goods {
    //mybatis plus 中主键@TableId，IdType.ASSIGN_ID 默认则使用IdType.ASSIGN_ID策略（自3.3.0起）。该策略会使用雪花算法自动生成主键ID,主键类型为Long或String对应MySQL的表字段为BigInt或VARCHAR
    //mybatis plus 中主键@TableId，IdType.ASSIGN_UUID 自动生成排除中划线的UUID作为主键。主键类型为String，对应MySQL的表分段为VARCHAR（32）
    //mybatis plus 中主键@TableId，IdType.AUTO  对于MySQL设置主键自动递增，主键类型为Long或int，对应MySQL的表分段为BigInt或int
    //mybatis plus 中主键@TableId，IdType.INPUT 插入前自行设置主键值
    @TableId(type= IdType.AUTO,value = "shopping_car_id")
    private Integer shoppingCarId;
    //商品名
    @TableField("goods_name")
    private String goodsName;

    private int goodsNum;


//    @TableField(exist = false)
//    private  String factoryName;


}
