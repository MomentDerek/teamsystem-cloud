package com.teamsystem.api.authtest.input.valid;

import com.teamsystem.common.web.validate.CustomValid;
import com.teamsystem.common.web.validate.CustomValidHandlerTemplate;
import org.springframework.stereotype.Component;

/**
 * 密码长度校验
 *
 * @author Moment
 */
@Component
public class passwordLengthValid implements CustomValidHandlerTemplate<String> {
    @Override
    public boolean isValid(CustomValid customValid, String value) {
        if (value.length() < 8) {
            return false;
        }
        return true;
    }
}
