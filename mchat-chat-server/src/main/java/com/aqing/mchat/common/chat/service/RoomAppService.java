package com.aqing.mchat.common.chat.service;

import com.aqing.mchat.common.chat.domain.vo.request.*;
import com.aqing.mchat.common.chat.domain.vo.request.member.MemberAddReq;
import com.aqing.mchat.common.chat.domain.vo.request.member.MemberDelReq;
import com.aqing.mchat.common.chat.domain.vo.request.member.MemberReq;
import com.aqing.mchat.common.chat.domain.vo.response.ChatMemberListResp;
import com.aqing.mchat.common.chat.domain.vo.response.ChatRoomResp;
import com.aqing.mchat.common.chat.domain.vo.response.MemberResp;
import com.aqing.mchat.common.common.domain.vo.request.CursorPageBaseReq;
import com.aqing.mchat.common.common.domain.vo.response.CursorPageBaseResp;
import com.aqing.mchat.common.user.domain.vo.response.ws.ChatMemberResp;

import java.util.List;

/**
 * Description:
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-07-22
 */
public interface RoomAppService {
    /**
     * 获取会话列表--支持未登录态
     */
    CursorPageBaseResp<ChatRoomResp> getContactPage(CursorPageBaseReq request, Long uid);

    /**
     * 获取群组信息
     */
    MemberResp getGroupDetail(Long uid, long roomId);

    CursorPageBaseResp<ChatMemberResp> getMemberPage(MemberReq request);

    List<ChatMemberListResp> getMemberList(ChatMessageMemberReq request);

    void delMember(Long uid, MemberDelReq request);

    void addMember(Long uid, MemberAddReq request);

    Long addGroup(Long uid, GroupAddReq request);

    ChatRoomResp getContactDetail(Long uid, Long roomId);

    ChatRoomResp getContactDetailByFriend(Long uid, Long friendUid);
}
