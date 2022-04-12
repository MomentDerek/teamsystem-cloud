package com.teamsystem.api.system.controller;

import com.teamsystem.api.system.service.SysSecurityService;
import com.teamsystem.common.web.response.Codes;
import com.teamsystem.common.web.response.R;
import com.teamsystem.common.web.response.RUtils;
import com.teamsystem.data.dto.SysUserSecurityDto;
import com.teamsystem.feign.system.SysFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author Moment
 */
@RestController
@RequestMapping()
public class SysFeignServiceImpl implements SysFeignService {

    private final SysSecurityService securityService;

    public SysFeignServiceImpl(SysSecurityService securityService) {
        this.securityService = securityService;
    }

    /**
     * 通过workId与teamId获取用户单一权限信息
     *
     * @param workId 工号/学号
     * @param teamId 团队ID
     * @return 用户单一权限信息
     */
    @Override
    public R<SysUserSecurityDto> getUserSecurityByWorkId(String workId) {
        return RUtils.create(securityService.getUserSecurityByWorkId(workId));
    }
}
