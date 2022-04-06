package com.teamsystem.api.authtest.service.mbp.impl;

import com.teamsystem.data.entity.SysUser;
import com.teamsystem.data.mapper.SysUserMapper;
import com.teamsystem.api.authtest.service.mbp.SysUserMBPService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户系统表 Mybatis Plus CRUD服务实现类
 *
 * @author Moment
 * @since 2022-04-03 04:03:46
 */
@Service
public class SysUserMBPServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserMBPService {

}
