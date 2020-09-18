package com.yangl.shardingsphere.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangl.shardingsphere.domain.entity.User;
import com.yangl.shardingsphere.domain.service.UserService;
import com.yangl.shardingsphere.infra.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author li.yang01@hand-china.com 2020/9/9 12:27 下午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
