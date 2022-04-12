package com.teamsystem.api.system.service;

import com.teamsystem.data.dto.SysUserSecurityDto;

/**
 * 安全相关服务类接口
 * @author Moment
 */
public interface SysSecurityService {

    SysUserSecurityDto getUserSecurityByWorkId(String workIdd);

}
