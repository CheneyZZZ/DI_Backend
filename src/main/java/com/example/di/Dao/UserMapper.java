package com.example.di.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface UserMapper {
    public int getFemaleNum();

    public int getMaleNum();

    public List<String> getRegins();
}
