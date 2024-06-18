package com.aqing.mchat.common.user.controller;


import com.aqing.mchat.common.common.domain.vo.response.ApiResult;
import com.aqing.mchat.common.common.utils.RequestHolder;
import com.aqing.mchat.common.user.domain.dto.SummeryInfoDTO;
import com.aqing.mchat.common.user.domain.vo.request.user.SummeryInfoReq;
import com.aqing.mchat.common.user.domain.vo.response.user.UserInfoResp;
import com.aqing.mchat.common.user.service.IRoleService;
import com.aqing.mchat.common.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author <a href="https://github.com/zongzibinbin">abin</a>
 * @since 2023-03-19
 */
@RestController
@RequestMapping("/capi/user")
@Api(tags = "用户管理相关接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    @ApiOperation("用户详情")
    public ApiResult<UserInfoResp> getUserInfo() {
        return ApiResult.success(userService.getUserInfo(RequestHolder.get().getUid()));
    }

    @PostMapping("/public/summary/userInfo/batch")
    @ApiOperation("用户聚合信息-返回的代表需要刷新的")
    public ApiResult<List<SummeryInfoDTO>> getSummeryUserInfo(@Valid @RequestBody SummeryInfoReq req) {
        return ApiResult.success(userService.getSummeryUserInfo(req));
    }


}

