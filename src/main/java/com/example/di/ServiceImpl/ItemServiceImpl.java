package com.example.di.ServiceImpl;

import com.example.di.Dao.ItemMapper;
import com.example.di.PO.DailySale;
import com.example.di.PO.WeeklySale;
import com.example.di.Service.ItemService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ResponseVO getDailySales(){
        try {
            List<DailySale> dateTemp = itemMapper.getDailySale();
            return ResponseVO.buildSuccess(dateTemp);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回每日商品销量失败");
        }
    }

    @Override
    public ResponseVO getWeeklySales(){
        try{
            List<DailySale> dateTemp = itemMapper.getDailySale();
            List<WeeklySale> weeklySales=new ArrayList<>();
            int i=0;
            while(dateTemp.size()-i>6){
                WeeklySale itemWeeklySale=new WeeklySale();
                int num=0;
                itemWeeklySale.setBeginDate(dateTemp.get(i).getDate());
                itemWeeklySale.setEndDate(dateTemp.get(i+6).getDate());
                for(int j=0;j<7;j++){
                    num=num+dateTemp.get(i+j).getNum();
                }
                itemWeeklySale.setNum(num);
                i=i+7;
            }
            return ResponseVO.buildSuccess(weeklySales);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回每周商品销量失败");
        }
    }
}
