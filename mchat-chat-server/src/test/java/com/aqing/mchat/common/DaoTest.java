package com.aqing.mchat.common;
import java.util.Date;
import com.aqing.mchat.common.user.dao.UserDao;
import com.aqing.mchat.common.user.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @Author: zengqingyu
 * Date: 2024/6/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DaoTest {

    @Resource
    UserDao userDao;


    @Test
    public void userSave(){
        User user = new User();
        user.setName("张三");
        user.setSex(0);
        user.setOpenId("111");
        user.setActiveStatus(0);
        boolean save = userDao.save(user);
        if(save){
            System.out.println("111");
        }else {
            System.out.println("222");
        }
    }
}
