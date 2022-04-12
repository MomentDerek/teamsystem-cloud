package com.teamsystem.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author Moment
 */
@Data
@NoArgsConstructor
public class UserInfoDto {

    /**
     * 工号/学号
     */
    private String workId;

    /**
     * 用户名
     */
    private String username;

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
}
