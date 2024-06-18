package com.aqing.mchat.common.chat.service.cache;

import com.aqing.mchat.common.chat.dao.MessageDao;
import com.aqing.mchat.common.chat.domain.entity.Message;
import com.aqing.mchat.common.user.dao.RoleDao;
import com.aqing.mchat.common.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Description: 消息相关缓存
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-03-27
 */
@Component
public class MsgCache {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MessageDao messageDao;

    @Cacheable(cacheNames = "msg", key = "'msg'+#msgId")
    public Message getMsg(Long msgId) {
        return messageDao.getById(msgId);
    }

    @CacheEvict(cacheNames = "msg", key = "'msg'+#msgId")
    public Message evictMsg(Long msgId) {
        return null;
    }
}
