package com.aqing.mchat.common.user.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: 用户相关缓存
 * Author: <a href="https://github.com/zengqy727">aqing</a>
 * Date: 2023-03-27
 */
@Component
public class ItemCache {//todo 多级缓存

//    @Autowired
//    private ItemConfigDao itemConfigDao;
//
//    @Cacheable(cacheNames = "item", key = "'itemsByType:'+#type")
//    public List<ItemConfig> getByType(Integer type) {
//        return itemConfigDao.getByType(type);
//    }
//
//    @Cacheable(cacheNames = "item", key = "'item:'+#itemId")
//    public ItemConfig getById(Long itemId) {
//        return itemConfigDao.getById(itemId);
//    }
}
