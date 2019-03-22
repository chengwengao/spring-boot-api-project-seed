package com.company.project.config;

/**
 * 项目中的常量定义类，订制团队开发相关参数
 */
public class Constant {
    /**
     * 应用的SuiteKey，登录开发者后台，点击应用管理，进入应用详情可见,corpId
     */
    public static final String SUITE_KEY="ding662c405046e4d4b335c2f4657eb6378f";
    /**
     * 应用的SuiteSecret，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String SUITE_SECRET="";

    /**
     * 回调URL加解密用。应用的数据加密密钥，登录开发者后台，点击应用管理，进入应用详情可见
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成，
     * ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
     */
    public static final String ENCODING_AES_KEY = "1234567890123456789012345678901234567890123";

    /**
     * 回调URL签名用。应用的签名Token, 登录开发者后台，点击应用管理，进入应用详情可见
     * 加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
     */
    public static final String TOKEN = "123456";
}
