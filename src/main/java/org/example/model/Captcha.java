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
 * @since 2024-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_captcha")
public class Captcha implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "captcha_id", type = IdType.AUTO)
      private Integer captchaId;

    private String sessionId;

    private String captcha;


}
