package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Captcha;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2024-06-01
 */
@Mapper
public interface CaptchaMapper extends BaseMapper<Captcha> {

}
