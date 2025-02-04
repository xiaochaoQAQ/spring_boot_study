package org.example.service.impl;

import org.example.model.Captcha;
import org.example.dao.CaptchaMapper;
import org.example.service.ICaptchaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2024-06-01
 */
@Service
public class CaptchaServiceImpl extends ServiceImpl<CaptchaMapper, Captcha> implements ICaptchaService {

}
