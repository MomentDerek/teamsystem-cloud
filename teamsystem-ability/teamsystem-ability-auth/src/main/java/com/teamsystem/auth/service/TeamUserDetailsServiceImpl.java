package com.teamsystem.auth.service;


import com.teamsystem.auth.model.dto.UserSecurityDto;
import com.teamsystem.common.core.utils.CachedBeanCopier;
import com.teamsystem.feign.system.SysFeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Moment
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TeamUserDetailsServiceImpl implements UserDetailsService {

    private final SysFeignService sysFeignService;

    @Override
    public UserDetails loadUserByUsername(String workId) throws UsernameNotFoundException {
        UserSecurityDto securityDto = new UserSecurityDto();
        CachedBeanCopier.copy(sysFeignService.getUserSecurityByWorkId(workId).getData(),securityDto);
        return securityDto;
    }
}
