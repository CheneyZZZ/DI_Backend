package com.example.di.Dao;

import com.example.di.PO.DailySale;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemMapperTest {
    @Autowired
    ItemMapper itemMapper;

    @Test
    public void GetDailySaleTest() {
        List<DailySale> dailySales=itemMapper.getDailySale();
        Assert.assertEquals(30,dailySales.size());
    }
}
