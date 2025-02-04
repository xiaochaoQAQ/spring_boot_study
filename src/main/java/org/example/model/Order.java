package org.example.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2024-06-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 订单id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户名称
     */
      private String userName;

      /**
     * 手机号
     */
      private String phone;

      /**
     * 用户身份证号
     */
      @TableField("userId")
    private String userId;

      /**
     * 商品
     */
      private String goods;

      /**
     * 数量
     */
      private Integer quantity;

      /**
     * 单价
     */
      private BigDecimal price;

      /**
     * 总价
     */
      private BigDecimal priceSum;

      /**
     * 支付状态
     */
      private String status;

      /**
     * 收货地址
     */
      private String address;

      /**
     * 描述
     */
      private String remark;


}
