package com.company.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.AbstractService;
import com.company.project.model.User;
import com.company.project.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: cwg
 * @Date: 2019/3/22 10:30
 * @Description:
 */
@Service
public class DingTalkApiServiceImpl extends AbstractService<User> implements DingTalkApiService {

    @Override
    public JSONArray getUserIdByPlainText(String plainText){
        if (StringUtils.isNotEmpty(plainText)) {
            JSONObject jsonObject = (JSONObject) JSONObject.parse(plainText);
            if(!jsonObject.containsKey("UserId")) {return null;}
            JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("UserId");
            return jsonArray;
        }
        return null;
    }
}
