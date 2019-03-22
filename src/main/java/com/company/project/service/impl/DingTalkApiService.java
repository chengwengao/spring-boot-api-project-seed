package com.company.project.service.impl;

import com.alibaba.fastjson.JSONArray;

/**
 * @Auther: cwg
 * @Date: 2019/3/22 10:28
 * @Description:
 */
public interface DingTalkApiService {
    /**
     * Author: cwg
     * Date: 2019/3/22 9:43
     * Description: 回调信息获取用户id
     * {"TimeStamp":"1553164466722","CorpId":"ding662c405046e4d4b335c2f4657eb6378f","UserId":["1003681538845361","120232122"],"EventType":"user_modify_org"}
     */
    JSONArray getUserIdByPlainText(String plainText);
}
