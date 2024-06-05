package com.aqing.mchat.common.user.dao;

import com.aqing.mchat.common.user.domain.entity.User;
import com.aqing.mchat.common.user.mapper.UserMapper;
import com.aqing.mchat.common.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author aqing
 * @since 2024-06-05
 */
@Service
public class UserDao extends ServiceImpl<UserMapper, User> {

}
