package com.example.di.ServiceImpl;

import com.example.di.Dao.UserMapper;
import com.example.di.PO.UserGenderInfo;
import com.example.di.Service.UserService;
import com.example.di.VO.ResponseVO;
import org.jcodings.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO getGenderRatio(){
        try{
            double ratio=0.0;
            int maleNum=0;
            int femaleNum=0;
            List<UserGenderInfo> temp=userMapper.getGenderInfos();
            for(int i=0;i<temp.size();i++){
                if(temp.get(i).getShop_identity_card_type()== 1&& temp.get(i).getShop_identity_cart_no().length()==18){
                    if((temp.get(i).getShop_identity_cart_no().charAt(16)-'0')%2==1){
                        maleNum=maleNum+1;
                    }else{
                        femaleNum=femaleNum+1;
                    }
                }else{
                    if(temp.get(i).getShop_gender()==0){
                        maleNum=maleNum+1;
                    }else{
                        femaleNum=femaleNum+1;
                    }
                }
            }
            Map<String,Integer> count=new HashMap<>();
            count.put("male",maleNum);
            count.put("female",femaleNum);
            return ResponseVO.buildSuccess(count);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回男女比失败");
        }
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
                    reginNums.set(j,reginNums.get(j)+1);
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
