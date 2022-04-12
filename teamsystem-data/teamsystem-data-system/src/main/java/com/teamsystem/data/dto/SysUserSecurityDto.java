package com.teamsystem.data.dto;

import lombok.Data;

import java.util.List;

/**
 * 包含密码等安全信息的用户Dto
 *
 * @author Moment
 */
@Data
public class SysUserSecurityDto {

    /**
     * 工号/学号
     */
    private String workId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 角色
     */
    private List<SysRoleDto> roleDtoList;

}
