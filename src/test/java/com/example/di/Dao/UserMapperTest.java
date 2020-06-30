package com.example.di.Dao;


import com.example.di.PO.UserGenderInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void getRegionsTest(){
        List<String> regins=userMapper.getRegins();
        Assert.assertEquals(1441,regins.size());
        for(String regin:regins){
            System.out.println(regin);
        }
    }

    @Test
    public void getGenderInfoTest() {
        List<UserGenderInfo> userGenderInfos=userMapper.getGenderInfos();
        System.out.println(userGenderInfos.size());
        Assert.assertEquals(1441,userGenderInfos.size());
    }
}
