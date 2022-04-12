package com.teamsystem.data.mapper;

import com.teamsystem.data.entity.SysUserTeam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户-团队联系表 Mapper 接口
 *
 * @author Moment
 * @since 2022-04-09 01:32:10
 */
@Mapper
public interface SysUserTeamMapper extends BaseMapper<SysUserTeam> {

}
