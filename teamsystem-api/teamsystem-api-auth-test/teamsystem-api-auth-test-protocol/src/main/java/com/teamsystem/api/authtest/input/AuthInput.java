package com.teamsystem.api.authtest.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamsystem.api.authtest.input.valid.passwordLengthValid;
import com.teamsystem.common.web.validate.CustomValid;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 身份验证入参对象
 *
 * @author Moment
 */
@Data
public class AuthInput {

    @JsonProperty("username")
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @CustomValid(message = "密码长度需要大于8",handler = passwordLengthValid.class)
    @NotBlank(message = "密码不能为空")
    private String password;

}
