package com.teamsystem.auth.model.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色Dto
 *
 * @author Moment
 */
@Data
public class SysRoleDto implements GrantedAuthority {

    /**
     * 团队ID
     */
    private Long teamId;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色代码（英文大写）
     */
    private String code;

    /**
     * 角色层级（越大级别越高）
     */
    private Integer sort;

    @Override
    public String getAuthority() {
        return teamId.toString()+":"+code;
    }
}
