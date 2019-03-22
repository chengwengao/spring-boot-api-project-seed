package com.company.project.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.project.config.Constant;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.service.impl.DingTalkApiService;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.dingtalk.oapi.lib.aes.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/05/07.
*/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger bizLogger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private DingTalkApiService dingTalkApiService;

    /**
     *  用户新增事件（第一次保存回调URL之前）
     */
    private static final String USER_ADD_ORG_URL = "user_add_org";
    /**
     * 用户修改事件
     */
    private static final String USER_MODIFY_ORG_URL = "user_modify_org";

    /**
     * 用户删除（离职）事件
     */
    private static final String USER_LEAVE_ORG_URL = "user_leave_org";
    /**
     * 相应钉钉回调时的值
     */
    private static final String CALLBACK_RESPONSE_SUCCESS = "success";

    @Resource
    private UserService userService;

    @RequestMapping(value = "/eventreceive", method = RequestMethod.POST)
    public Map callback(@RequestParam(value = "signature", required = false) String signature,
                                        @RequestParam(value = "timestamp", required = false) String timestamp,
                                        @RequestParam(value = "nonce", required = false) String nonce,
                                        @RequestBody(required = false) JSONObject json) {
        String params = " signature:"+signature + " timestamp:"+timestamp +" nonce:"+nonce+" json:"+json;
        try {
            bizLogger.info("begin /callback"+params);
            DingTalkEncryptor dingTalkEncryptor = new DingTalkEncryptor(Constant.TOKEN, Constant.ENCODING_AES_KEY,
                    Constant.SUITE_KEY);

            //从post请求的body中获取回调信息的加密数据进行解密处理
            String encryptMsg = json.getString("encrypt");
            String plainText = dingTalkEncryptor.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
            JSONObject obj = JSON.parseObject(plainText);

            //根据回调数据类型做不同的业务处理
            String eventType = obj.getString("EventType");
            if (USER_ADD_ORG_URL.equals(eventType)) {
                bizLogger.info("用户新增: " + plainText);
                bizLogger.info("userId: " + dingTalkApiService.getUserIdByPlainText(plainText));
            } else if (USER_MODIFY_ORG_URL.equals(eventType)) {
                bizLogger.info("用户修改: " + plainText);
                bizLogger.info("userId: " + dingTalkApiService.getUserIdByPlainText(plainText));
            } else if (USER_LEAVE_ORG_URL.equals(eventType)) {
                bizLogger.info("用户删除（离职）: " + plainText);
                bizLogger.info("userId: " + dingTalkApiService.getUserIdByPlainText(plainText));
            } else {
                // 其他类型事件处理
                bizLogger.info("其他类型事件处理："+plainText);
            }

            // 返回success的加密信息表示回调处理成功
            return dingTalkEncryptor.getEncryptedMap(CALLBACK_RESPONSE_SUCCESS, System.currentTimeMillis(), Utils.getRandomStr(8));
        } catch (Exception e) {
            //失败的情况，应用的开发者应该通过告警感知，并干预修复
            bizLogger.error("process callback failed！"+params,e);
            return null;
        }
    }

    @PostMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /*
    @PostMapping是@RequestMapping(method = RequestMethod.POST)的缩写
     */
    @RequestMapping(method = RequestMethod.POST, value = "list1")
    public Result list1(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getNameById")
    public Result getNameById(@RequestParam Integer id){
        User user = userService.findById(id);
        String name = null;
        if (null != user && StringUtils.isNotEmpty(user.getNickName())){
            name = user.getNickName();
        }
        return ResultGenerator.genSuccessResult(name);
    }

    /*
    @GetMapping是@RequestMapping(method = RequestMethod.GET)的缩写
     */
    @GetMapping(value = "getNameById1")
    public Result getNameById1(@RequestParam Integer id){
        User user = userService.findById(id);
        String name = null;
        if (null != user && StringUtils.isNotEmpty(user.getNickName())){
            name = user.getNickName();
        }
        return ResultGenerator.genSuccessResult(name);
    }

}