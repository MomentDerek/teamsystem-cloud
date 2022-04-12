package com.teamsystem.api.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.teamsystem.api.system.service.SysSecurityService;
import com.teamsystem.data.dto.SysRoleDto;
import com.teamsystem.data.dto.SysUserSecurityDto;
import com.teamsystem.api.system.service.SysUserService;
import com.teamsystem.common.core.utils.CachedBeanCopier;
import com.teamsystem.data.entity.SysRole;
import com.teamsystem.data.entity.SysUser;
import com.teamsystem.data.entity.SysUserRole;
import com.teamsystem.data.mapper.SysRoleMapper;
import com.teamsystem.data.mapper.SysUserMapper;
import com.teamsystem.data.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户相关服务类实现
 *
 * @author Moment
 */
@Service
public class SysSecurityServiceImpl implements SysSecurityService {

    private final SysUserMapper userMapper;
    private final SysUserRoleMapper userRoleMapper;
    private final SysRoleMapper roleMapper;

    public SysSecurityServiceImpl(SysUserMapper userMapper, SysUserRoleMapper userRoleMapper, SysRoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public SysUserSecurityDto getUserSecurityByWorkId(String workId) {
        SysUser sysUser = userMapper.selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getWorkId, workId));
        SysUserSecurityDto sysUserSecurityDto = new SysUserSecurityDto();
        CachedBeanCopier.copy(sysUser,sysUserSecurityDto);
        List<SysRoleDto> sysRoleDtoList = roleMapper.selectBatchIds(userRoleMapper.selectList(Wrappers.lambdaQuery(SysUserRole.class)
                                .eq(SysUserRole::getUserId, sysUser.getId()))
                        .stream()
                        .map(SysUserRole::getRoleId)
                        .collect(Collectors.toList())
                ).stream()
                .map(role -> {
                    SysRoleDto sysRoleDto = new SysRoleDto();
                    CachedBeanCopier.copy(role,sysRoleDto);
                    return sysRoleDto;
                }).collect(Collectors.toList());
        sysUserSecurityDto.setRoleDtoList(sysRoleDtoList);
        return sysUserSecurityDto;
    }
}
