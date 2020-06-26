package com.example.di.Dao;


import com.example.di.PO.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantMapperTest {
    @Autowired
    RestaurantMapper restaurantRepository;
    @Test
    public void testGetAll(){
        List<Restaurant> restaurants=restaurantRepository.getAllResaurants();
        Assert.assertEquals(50,restaurants.size());
    }
}
