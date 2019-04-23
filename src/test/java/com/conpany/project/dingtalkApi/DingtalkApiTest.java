package com.conpany.project.dingtalkApi;

import com.alibaba.fastjson.JSONArray;
import com.company.project.Application;
import com.company.project.service.impl.DingTalkApiService;
import com.company.project.util.HttpClientHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

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

    //新浪，短网址生成
    @Test
    public void test() throws Exception{
        String api = "http://api.weibo.com/2/short_url/shorten.json?source=2849184197&url_long=";
        String url_long = "https://asset.forwe.store/server/cms/qrCode/create?number=bac39434649f11e9b0e500163e088142&corpId=ding4f72484b3d5feaad35c2f4657eb6378f";
        for(int i=1;i<=1000000;i++) {
            HttpClientHandle.doGet(api + url_long);
            System.out.println("********第"+i+"次********");
            Thread.sleep(5l);
        }
    }

    //百度，短网址生成，有弊端，必须被百度收录才行
    @Test
    public void test1(){
        String url = "http://172.17.9.98/wap/#/assetInfo?id=a33d065a90204aec9158940e62f7e477&corpId=ding662c405046e4d4b335c2f4657eb6378f";
        String url1 = "https://dwz.cn/admin/v2/create";
        java.util.Map params = new HashMap();
        params.put("token", "b456682c7dbbe2c234b3d68d8787cc7c");
        String str = HttpClientHandle.doPost(url1, params);
        System.out.println(str);
    }
}
