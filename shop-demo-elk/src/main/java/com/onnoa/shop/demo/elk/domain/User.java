package com.onnoa.shop.demo.elk.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Description:
 * @Author: onnoA
 * @Date: 2020/5/26 15:37
 */
public class User implements Serializable {
    @NotBlank(message = "用户名不能为空。。")
    private String username;

    @NotBlank(message = "密码不能为空。。")
    @Length(min = 6, max = 32, message = "密码长度不能小于6位,最大长度不能大于32位。。")
    private String password;

    @NotBlank(message = "邮箱不能为空。。")
    @Email( message = "邮件格式校验失败。。")
    private String email;
}
