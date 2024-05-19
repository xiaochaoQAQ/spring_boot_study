package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.Goods;

@Mapper
public interface ShoppingCarMapper extends BaseMapper<Goods> {

}
