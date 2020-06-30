package com.example.di.Dao;

import com.example.di.PO.UserGenderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;

    public List<UserGenderInfo> getGenderInfos() {
        List<UserGenderInfo> userGenderInfos=new ArrayList<>();
        String sql="select dwd_user_info.shop_identity_card_type,dwd_user_info.shop_identity_card_no,dwd_user_info.shop_gender from dwd_user_info";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            userGenderInfos.add(new UserGenderInfo((Byte)item.get("dwd_user_info.shop_identity_card_type"),(String) item.get("dwd_user_info.shop_identity_card_no"),(Byte)item.get("dwd_user_info.shop_gender")));
        }
        return userGenderInfos;
    }

    public List<String> getRegins(){
        String sql="select dwd_user_info.takeout_address,dwd_user_info.shop_address from dwd_user_info where takeout_address is not null or shop_address is not null";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        List<String> regins=new ArrayList<>();
        for(Map<String,Object> item:res){
            String address=(String)item.get("dwd_user_info.shop_address");
            if(address==null){
                address=(String)item.get("dwd_user_info.takeout_address");
            }
            regins.add(addressResolution(address));

        }
        return regins;
    }

    public String addressResolution(String address){
        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m= Pattern.compile(regex).matcher(address);
        String province=null;
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("province", province==null?"":province.trim());
        }
        return row.get("province");
    }
}
