package com.teamsystem.api.user.service;

import com.teamsystem.data.dto.UserInfoDto;

/**
 * 用户信息服务接口
 */
public interface UserInfoService {

    /**
     * 通过学号、工号查询用户信息
     * @param workId 学号/工号
     * @return 用户信息dto
     */
    UserInfoDto getUserInfoByWorkId(String workId);

}
