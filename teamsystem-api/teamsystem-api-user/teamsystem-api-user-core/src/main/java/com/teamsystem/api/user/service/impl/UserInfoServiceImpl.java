package com.teamsystem.api.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.teamsystem.api.user.service.UserInfoService;
import com.teamsystem.common.core.utils.CachedBeanCopier;
import com.teamsystem.data.dto.UserInfoDto;
import com.teamsystem.data.entity.SysUser;
import com.teamsystem.data.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务实现类
 *
 * @author Moment
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserMapper userMapper;

    /**
     * 通过学号、工号查询用户信息
     *
     * @param workId 学号/工号
     * @return 用户信息dto
     */
    @Override
    public UserInfoDto getUserInfoByWorkId(String workId) {
        SysUser sysUser = userMapper.selectOne(
                Wrappers.<SysUser>lambdaQuery()
                        .eq(SysUser::getWorkId, workId));
        return (UserInfoDto) CachedBeanCopier.copy(sysUser, UserInfoDto.class);
    }
}
