package com.conpany.project.dingtalkApi;

import com.alibaba.fastjson.JSONArray;
import com.company.project.Application;
import com.company.project.service.impl.DingTalkApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: cwg
 * @Date: 2019/3/22 10:13
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DingtalkApiTest {

    @Resource
    private DingTalkApiService dingTalkApiService;

    @Test
    public void getUserIdByPlainTextTest(){
//        String plainText = "{\"TimeStamp\":\"1553164466722\",\"CorpId\":\"ding662c405046e4d4b335c2f4657eb6378f\",\"UserId\":[\"1003681538845361\",\"120232122\"],\"EventType\":\"user_modify_org\"}";
        String plainText = "{\"TimeStamp\":\"1553164466722\",\"CorpId\":\"ding662c405046e4d4b335c2f4657eb6378f\",\"UserId\":[\"1003681538845361\"],\"EventType\":\"user_modify_org\"}";
//        String plainText = "{\"TimeStamp\":\"1553164466722\",\"CorpId\":\"ding662c405046e4d4b335c2f4657eb6378f\",\"UserId\":[],\"EventType\":\"user_modify_org\"}";
//        String plainText = "{\"TimeStamp\":\"1553164466722\",\"CorpId\":\"ding662c405046e4d4b335c2f4657eb6378f\",\"EventType\":\"user_modify_org\"}";
        JSONArray jsonArray = dingTalkApiService.getUserIdByPlainText(plainText);
//        Arrays.asList(jsonArray).forEach(System.out::println);
        if (jsonArray != null) {
            jsonArray.forEach(System.out::println);
            System.out.println(jsonArray.toJSONString());
        }
    }
}
