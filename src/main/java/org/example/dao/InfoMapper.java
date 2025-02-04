package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Info;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2024-06-02
 */
@Mapper
public interface InfoMapper extends BaseMapper<Info> {

}
