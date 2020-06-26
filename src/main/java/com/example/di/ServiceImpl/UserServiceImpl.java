package com.example.di.ServiceImpl;

import com.example.di.Dao.UserMapper;
import com.example.di.Service.UserService;
import com.example.di.VO.ResponseVO;
import org.jcodings.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO getGenderRatio(){
//        try{
//            double ratio=0.0;
//            ratio=userMapper.getMaleNum()/userMapper.getFemaleNum();
//            return ResponseVO.buildSuccess(ratio);
//        }catch (Exception e){
//            return ResponseVO.buildFailure("返回男女比失败");
//        }
        return null;
    }

    @Override
    public ResponseVO getRegionList(){
        try{
            List<Integer>  reginNums=new ArrayList<>();
            List<String> regins=new ArrayList<>();
            List<String> reginsTemp=userMapper.getRegins();
            for(int i=0;i<reginsTemp.size();i++){
                if(regins.size()==0 || !regins.contains(reginsTemp.get(i))){
                    regins.add(reginsTemp.get(i));
                    reginNums.add(1);
                }else{
                    int j=regins.indexOf(reginsTemp.get(i));
                    reginNums.set(j,reginNums.get(i)+1);
                }
            }
            List<List> reginNumsCouple=new ArrayList<>();
            reginNumsCouple.add(regins);
            reginNumsCouple.add(reginNums);
            return ResponseVO.buildSuccess(reginNumsCouple);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回地区分布失败");
        }
    }
}
