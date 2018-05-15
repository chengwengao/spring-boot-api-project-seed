package com.conpany.project.httpclient;

import com.company.project.util.HttpClientHandle;
import com.conpany.project.Tester;
import org.junit.Test;

/**
 * Created by chengwengao on 2018/5/15.
 */
public class HttpClientTest extends Tester {

    @Test
    public void test(){
        //get请求
        //请求头参数
        String url = "http://125.119.228.207:8082/api?action=obj.interface&method=cagSocialInfo&token=aWNmZ3Q6Y2xpZW50OkVDNkE5RTJGQTEyQjQ4MUJCRTUwRTcxMTJCRkI0NDMx&transdata=%7B%22token%22%3A%22aWNmZ3Q6Y2xpZW50OkVDNkE5RTJGQTEyQjQ4MUJCRTUwRTcxMTJCRkI0NDMx%22%2C%22fsocial_uuid%22%3A%22999%22%2C%22fsocial_name%22%3A%22浙大正呈新门海1%22%2C%22fprovince_code%22%3A%22330000%22%2C%22fcity_code%22%3A%22330700%22%2C%22fcounty_code%22%3A%22330782%22%2C%22faddress%22%3A%22西园二路3号%22%2C%22flink_man%22%3A%22张三%22%2C%22ftel_no%22%3A%2213456475654%22%2C%22fnum%22%3A%221%22%2C%22flongitude%22%3A%22120.3%22%2C%22flatitude%22%3A%2230.9%22%2C%22fpermaint%22%3A%22北苑街道%22%2C%22funit_type%22%3A%22%22%2C%22fis_active%22%3A%220%22%7D";
//        Map<String, String> headerMap = new HashMap<>();
//        headerMap.put("api-key", "hPq0FOr9diFI8qgVMiLKAUdQxC8=");
        System.out.println("=========返回结果："+new HttpClientHandle().doGet(url));
    }
}
