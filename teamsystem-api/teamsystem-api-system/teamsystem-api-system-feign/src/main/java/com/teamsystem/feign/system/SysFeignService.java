package com.teamsystem.feign.system;

import com.teamsystem.common.web.response.R;
import com.teamsystem.data.dto.SysUserSecurityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "systemService")
public interface SysFeignService {

    /**
     * 通过workId与teamId获取用户单一权限信息
     * @param workId 工号/学号
     * @param teamId 团队ID
     * @return 用户单一权限信息
     */
    @GetMapping("/security/user/{workId}")
    R<SysUserSecurityDto> getUserSecurityByWorkId(@PathVariable("workId") String workId);

}
