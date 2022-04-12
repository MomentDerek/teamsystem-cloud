package com.teamsystem.api.user.controller;

import com.teamsystem.api.user.service.UserInfoService;
import com.teamsystem.common.web.response.R;
import com.teamsystem.common.web.response.RUtils;
import com.teamsystem.data.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author Moment
 */
@RestController
@RequestMapping("/user/info/")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping("/{workId}")
    public R<UserInfoDto> getUserInfo(@PathVariable("workId") String workId) {
        return RUtils.create(userInfoService.getUserInfoByWorkId(workId));
    }

}
