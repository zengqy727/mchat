package com.aqing.mchat.common.chat.service;

import com.aqing.mchat.common.chat.domain.dto.MsgReadInfoDTO;
import com.aqing.mchat.common.chat.domain.entity.Message;
import com.aqing.mchat.common.chat.domain.vo.request.*;
import com.aqing.mchat.common.chat.domain.vo.request.member.MemberReq;
import com.aqing.mchat.common.chat.domain.vo.response.ChatMemberListResp;
import com.aqing.mchat.common.chat.domain.vo.response.ChatMemberStatisticResp;
import com.aqing.mchat.common.chat.domain.vo.response.ChatMessageReadResp;
import com.aqing.mchat.common.chat.domain.vo.response.ChatMessageResp;
import com.aqing.mchat.common.common.domain.vo.response.CursorPageBaseResp;
import com.aqing.mchat.common.user.domain.vo.response.ws.ChatMemberResp;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * Description: 消息处理类
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-03-26
 */
public interface ChatService {

    /**
     * 发送消息
     *
     * @param request
     */
    Long sendMsg(ChatMessageReq request, Long uid);

    /**
     * 根据消息获取消息前端展示的物料
     *
     * @param message
     * @param receiveUid 接受消息的uid，可null
     * @return
     */
    ChatMessageResp getMsgResp(Message message, Long receiveUid);

    /**
     * 根据消息获取消息前端展示的物料
     *
     * @param msgId
     * @param receiveUid 接受消息的uid，可null
     * @return
     */
    ChatMessageResp getMsgResp(Long msgId, Long receiveUid);

    /**
     * 获取群成员列表
     *
     * @param memberUidList
     * @param request
     * @return
     */
    CursorPageBaseResp<ChatMemberResp> getMemberPage(List<Long> memberUidList, MemberReq request);

    /**
     * 获取消息列表
     *
     * @param request
     * @return
     */
    CursorPageBaseResp<ChatMessageResp> getMsgPage(ChatMessagePageReq request, @Nullable Long receiveUid);

    ChatMemberStatisticResp getMemberStatistic();

    void setMsgMark(Long uid, ChatMessageMarkReq request);

    void recallMsg(Long uid, ChatMessageBaseReq request);

    List<ChatMemberListResp> getMemberList(ChatMessageMemberReq chatMessageMemberReq);

    Collection<MsgReadInfoDTO> getMsgReadInfo(Long uid, ChatMessageReadInfoReq request);

    CursorPageBaseResp<ChatMessageReadResp> getReadPage(Long uid, ChatMessageReadReq request);

    void msgRead(Long uid, ChatMessageMemberReq request);
}
