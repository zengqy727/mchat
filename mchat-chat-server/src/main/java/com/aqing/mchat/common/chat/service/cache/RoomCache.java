package com.aqing.mchat.common.chat.service.cache;

import com.aqing.mchat.common.chat.dao.RoomDao;
import com.aqing.mchat.common.chat.dao.RoomFriendDao;
import com.aqing.mchat.common.chat.domain.entity.Room;
import com.aqing.mchat.common.common.constant.RedisKey;
import com.aqing.mchat.common.common.service.cache.AbstractRedisStringCache;
import com.aqing.mchat.common.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 房间基本信息的缓存
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-06-10
 */
@Component
public class RoomCache extends AbstractRedisStringCache<Long, Room> {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomFriendDao roomFriendDao;

    @Override
    protected String getKey(Long roomId) {
        return RedisKey.getKey(RedisKey.ROOM_INFO_STRING, roomId);
    }

    @Override
    protected Long getExpireSeconds() {
        return 5 * 60L;
    }

    @Override
    protected Map<Long, Room> load(List<Long> roomIds) {
        List<Room> rooms = roomDao.listByIds(roomIds);
        return rooms.stream().collect(Collectors.toMap(Room::getId, Function.identity()));
    }
}
