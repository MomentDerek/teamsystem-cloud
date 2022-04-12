package com.teamsystem.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teamsystem.data.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper
 *
 * @author Moment
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
}