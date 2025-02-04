package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2024-06-22
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
