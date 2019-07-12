package com.mingle.json.fast;



import com.alibaba.fastjson.JSON;
import com.mingle.json.Entity;
import com.mingle.json.User;

import java.util.Arrays;
import java.util.Map;


/**
 * Created by mingle.
 * Time 03/07/2018 10:56
 * Desc 文件描述
 */
public class FastJson {
    
    public static void main(String[] args) throws Exception {
        
        User user = new User();
        User.Name name = new User.Name();
        name.setFirst("chen");
        name.setLast("mingle");
        user.setName(name);
    
        System.out.println(user);
        System.out.println(Arrays.asList(user));
        
        User[] users = new User[]{user};
        System.out.println(users.toString());
        
        String code = JSON.toJSONString(user);
        System.out.println(code);
    
        Entity entity = new Entity();
        entity.setId(123L);
        entity.setName("mingle");
        System.out.println(entity);
    
        com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) JSON.parse("{\"all_list\":\"512281`512257`512237`512022`511960`512277`507382`489563\",\"app_type\":\"21\",\"channel_id\":\"158\",\"device\":\"869499036691479\"," +
                "\"entityProp\":\"{\\\"deviceType\\\":\\\"aaaa\\\",\\\"uid\\\":\\\"7410339\\\",\\\"unit\\\":\\\"bbbb\\\",\\\"code\\\":\\\"0\\\",\\\"systype\\\":\\\"fffff\\\"," +
                "\\\"apptype\\\":\\\"eeeee\\\",\\\"sysversion\\\":\\\"ccccc\\\",\\\"appversion\\\":\\\"ddddd\\\",\\\"device\\\":\\\"bd69feb54b2aa3ab58bdc620c4d0896218d78632\\\"," +
                "\\\"push_token\\\":\\\"<de6eb29e 53423d22 020edea9 730a3efe b8b26632 a3f48146 a6b758ef fd009dcc>\\\",\\\"transactionid\\\":\\\"47723510-F388-4678-AF2E-D2EA938B0502\\\"}\"," +
                "\"education\":\"\",\"exp_name\":\"ios_autoreco\",\"gender\":\"\",\"is_first_request\":\"1\",\"is_pay_user\":\"1\",\"location\":\"\",\"nationality\":\"\",\"occupation\":\"\"," +
                "\"recoid\":\"255d6510e9b84bda2fd\",\"return_num\":\"8\",\"sys_type\":\"ios\",\"top_list\":\"\",\"uid\":\"7410339\",\"uuid\":\"9c25f8d3-cd1f-4231-852d-ca510f09a8cc\",\"test\":\"true\"}");
        System.out.println(jsonObject.get("exp_name"));
        System.out.println(jsonObject.get("uuid"));
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    
}
