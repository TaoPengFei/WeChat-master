package com.weixin.util;

public class WeChatApi {
	/**
	 * 微信号的APPID
	 */
	public static final String APPID = "wx7ae52acace660eb5";
	/**
	 * 微信号的SECRET密码  每次微信公众号重置后需要跟新
	 */
	public static final String SECRET = "76384fdf10fe3a2f2443b0366fd0d882";
	/**
	 * 微信公众号领取会员卡的url链接  本地的菜单配置的URL  换地需要改
	 */
	public static final String MENULINKURL = "http://shiyuncloud/WeChat/CardLogin.jsp";
	
	/**
	 * 金蔻百货Card_id
	 */
	public static final String CARDID = "pAf4H04LCSEqkbUHq64Z05MRgtvw";
	
	/**
	 * ACCESSTOKENURL用来获取access_token
	 */
	public static final String ACCESSTOKENURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";

	
	/**
	 * 获取jsapi_ticket 的url  conf计算签名时使用
	 */
	public static  final String JSAPIURL="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
    
    /**
     * 获取openid的url
     */
	public static final  String GETOPENIDURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    
    /**
	 * 获取api_ticket的url  添加会员卡时使用
	 */
	public  static final String APITICKETURL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
	
	
	
	
}
