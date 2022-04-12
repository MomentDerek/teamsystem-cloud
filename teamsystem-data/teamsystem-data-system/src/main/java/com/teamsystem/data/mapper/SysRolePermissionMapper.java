package com.teamsystem.data.mapper;

import com.teamsystem.data.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色-权限规则联系表 Mapper 接口
 *
 * @author Moment
 * @since 2022-04-09 01:32:10
 */
@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

}
