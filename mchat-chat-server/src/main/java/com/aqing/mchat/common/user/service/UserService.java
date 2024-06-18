package com.aqing.mchat.common.user.service;



import com.aqing.mchat.common.user.domain.dto.SummeryInfoDTO;
import com.aqing.mchat.common.user.domain.entity.User;
import com.aqing.mchat.common.user.domain.vo.request.user.ModifyNameReq;
import com.aqing.mchat.common.user.domain.vo.request.user.SummeryInfoReq;
import com.aqing.mchat.common.user.domain.vo.response.user.UserInfoResp;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author <a href="https://github.com/zongzibinbin">abin</a>
 * @since 2023-03-19
 */
public interface UserService {

    /**
     * 获取前端展示信息
     *
     * @param uid
     * @return
     */
    UserInfoResp getUserInfo(Long uid);

    /**
     * 修改用户名
     *
     * @param uid
     * @param req
     */
    void modifyName(Long uid, ModifyNameReq req);


    /**
     * 用户注册，需要获得id
     *
     * @param user
     */
    void register(User user);

    /**
     * 获取用户汇总信息
     *
     * @param req
     * @return
     */
    List<SummeryInfoDTO> getSummeryUserInfo(SummeryInfoReq req);
}
