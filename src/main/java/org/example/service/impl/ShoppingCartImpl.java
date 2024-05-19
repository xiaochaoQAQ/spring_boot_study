package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.ShoppingCarMapper;
import org.example.model.Goods;
import org.example.service.IShoppingCartService;
import org.springframework.stereotype.Service;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: tangchao
 * \* Date: 2024/4/14
 * \* Time: 16:14
 * \* Description:
 * \购物车
 */
@Service
public class ShoppingCartImpl extends ServiceImpl<ShoppingCarMapper,Goods> implements IShoppingCartService {


}