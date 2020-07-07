package com.onnoa.shop.demo.authority.system.controller;

import com.onnoa.shop.common.result.ResultBean;
import com.onnoa.shop.demo.authority.system.annotation.NoNeedTokenAuth;
import com.onnoa.shop.demo.authority.system.dto.AuthDto;
import com.onnoa.shop.demo.authority.system.dto.SysUserLoginDto;
import com.onnoa.shop.demo.authority.system.service.SysUserService;
import com.onnoa.shop.demo.authority.system.vo.VerifyCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping(value = "/login")
    @NoNeedTokenAuth
    public ResultBean login(@RequestBody @Valid SysUserLoginDto loginDto) {
        String accessToken = userService.login(loginDto);
        return ResultBean.success(accessToken);
    }


    @GetMapping(value = "/verify")
    @NoNeedTokenAuth
    public ResultBean getVerifyCode() {
        VerifyCodeVo resultVo = userService.getVerifyCode();
        return ResultBean.success(resultVo);
    }

    @PostMapping(value = "/auth")
    public ResultBean auth(@RequestBody @Valid AuthDto authDto) {
        Boolean hasAuth = userService.auth(authDto);
        return ResultBean.success(hasAuth);
    }
}
