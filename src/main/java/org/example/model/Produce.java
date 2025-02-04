package org.example.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2024-06-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("t_produce")
public class Produce implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 

     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 商品
     */
      private String product;

      /**
     * 库存数量
     */
      private String quantity;

      /**
     * 供应商名称
     */
      private String supplierName;

      /**
     * 供应商联系方式 
     */
      private String supplierContact;

      /**
     * 预警数量
     */
      private String alertQuantity;

      /**
     * 货架
     */
      private String shelf;


}
