package com.weixin.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenSingleton {
    //缓存accessToken 的Map  ,map中包含 一个accessToken 和 缓存的时间戳
        //当然也可以分开成两个属性咯
    

        private static Map<String, String> map = new HashMap<>();

        public TokenSingleton() {
        }

        private static TokenSingleton single = null;

        // 静态工厂方法
        public static TokenSingleton getInstance() {
            if (single == null) {
                single = new TokenSingleton();
            }
            return single;
        }

        public static Map<String, String> getMap() {
            String time = map.get("time");
           // System.out.println(time);
            String accessToken = map.get("access_token");
            //System.out.println(accessToken);
            Long nowDate = new Date().getTime();
            
            if (accessToken != null && time != null && nowDate - Long.parseLong(time) < 4000 * 1000) {
                System.out.println("accessToken存在，且没有超时 ， 返回单例");
            } else {
                System.out.println("accessToken 超时 ， 或者不存在 ， 重新获取");
               
                String access_token=WeCardUtil.Getaccess_token();
                        //"这里是直接调用微信的API去直接获取 accessToken 和Jsapi_ticket 获取";
                String jsapi_token = WeCardUtil.GetJsApiTicket(access_token);
                        //"获取jsapi_token";
                map.put("time", nowDate + "");
                map.put("access_token", access_token);
                map.put("jsapi_token", jsapi_token);
            }
            
            return map;
        }

        public void setMap(Map<String, String> map) {
            this.map = map;
        }

        public static TokenSingleton getSingle() {
            return single;
        }

        public static void setSingle(TokenSingleton single) {
            TokenSingleton.single = single;
        }
      
        public static void main(String[] args) {
        	TokenSingleton sin = TokenSingleton.getInstance();
		}
        
}