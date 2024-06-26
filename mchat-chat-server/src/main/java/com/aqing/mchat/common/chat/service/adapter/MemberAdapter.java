package com.aqing.mchat.common.chat.service.adapter;

import com.aqing.mchat.common.chat.domain.entity.GroupMember;
import com.aqing.mchat.common.chat.domain.enums.GroupRoleEnum;
import com.aqing.mchat.common.chat.domain.vo.response.ChatMemberListResp;
import com.aqing.mchat.common.user.domain.entity.User;
import com.aqing.mchat.common.user.domain.enums.WSBaseResp;
import com.aqing.mchat.common.user.domain.enums.WSRespTypeEnum;
import com.aqing.mchat.common.user.domain.vo.response.ws.ChatMemberResp;
import com.aqing.mchat.common.user.domain.vo.response.ws.WSMemberChange;
import com.aqing.mchat.common.user.service.cache.UserCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.aqing.mchat.common.user.domain.vo.response.ws.WSMemberChange.CHANGE_TYPE_ADD;
import static com.aqing.mchat.common.user.domain.vo.response.ws.WSMemberChange.CHANGE_TYPE_REMOVE;

/**
 * Description: 成员适配器
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-03-26
 */
@Component
@Slf4j
public class MemberAdapter {
    @Autowired
    private UserCache userCache;

    public static List<ChatMemberResp> buildMember(List<User> list) {
        return list.stream().map(a -> {
            ChatMemberResp resp = new ChatMemberResp();
            resp.setActiveStatus(a.getActiveStatus());
            resp.setLastOptTime(a.getLastOptTime());
            resp.setUid(a.getId());
            return resp;
        }).collect(Collectors.toList());
    }



    public static List<ChatMemberListResp> buildMemberList(List<User> memberList) {
        return memberList.stream()
                .map(a -> {
                    ChatMemberListResp resp = new ChatMemberListResp();
                    BeanUtils.copyProperties(a, resp);
                    resp.setUid(a.getId());
                    return resp;
                }).collect(Collectors.toList());
    }

    public static List<ChatMemberListResp> buildMemberList(Map<Long, User> batch) {
        return buildMemberList(new ArrayList<>(batch.values()));
    }

    public static List<GroupMember> buildMemberAdd(Long groupId, List<Long> waitAddUidList) {
        return waitAddUidList.stream().map(a -> {
            GroupMember member = new GroupMember();
            member.setGroupId(groupId);
            member.setUid(a);
            member.setRole(GroupRoleEnum.MEMBER.getType());
            return member;
        }).collect(Collectors.toList());
    }

    public static WSBaseResp<WSMemberChange> buildMemberAddWS(Long roomId, User user) {
        WSBaseResp<WSMemberChange> wsBaseResp = new WSBaseResp<>();
        wsBaseResp.setType(WSRespTypeEnum.MEMBER_CHANGE.getType());
        WSMemberChange wsMemberChange = new WSMemberChange();
        wsMemberChange.setActiveStatus(user.getActiveStatus());
        wsMemberChange.setLastOptTime(user.getLastOptTime());
        wsMemberChange.setUid(user.getId());
        wsMemberChange.setRoomId(roomId);
        wsMemberChange.setChangeType(CHANGE_TYPE_ADD);
        wsBaseResp.setData(wsMemberChange);
        return wsBaseResp;
    }

    public static WSBaseResp<WSMemberChange> buildMemberRemoveWS(Long roomId, Long uid) {
        WSBaseResp<WSMemberChange> wsBaseResp = new WSBaseResp<>();
        wsBaseResp.setType(WSRespTypeEnum.MEMBER_CHANGE.getType());
        WSMemberChange wsMemberChange = new WSMemberChange();
        wsMemberChange.setUid(uid);
        wsMemberChange.setRoomId(roomId);
        wsMemberChange.setChangeType(CHANGE_TYPE_REMOVE);
        wsBaseResp.setData(wsMemberChange);
        return wsBaseResp;
    }
}
