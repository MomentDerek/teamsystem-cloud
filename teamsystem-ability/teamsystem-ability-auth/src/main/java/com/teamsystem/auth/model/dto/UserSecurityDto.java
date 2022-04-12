package com.teamsystem.auth.model.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 包含密码等安全信息的用户Dto
 *
 * @author Moment
 */
@Data
public class UserSecurityDto implements UserDetails {

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

    @Override
    public String getUsername() {
        return workId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleDtoList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
