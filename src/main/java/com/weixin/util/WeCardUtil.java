package com.weixin.util;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;

import com.weixin.card.HttpTool;
import net.sf.json.JSONObject;

public class WeCardUtil {


	
    private  static final String ACCESSTOKENURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7ae52acace660eb5&secret=76384fdf10fe3a2f2443b0366fd0d882";
    private static final String APITICKETURL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
    //获取jsapi_ticket 的url  conf计算签名时使用
    private static final String JSAPIURL="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
    //本地的菜单配置的URL  换地需要改
    private static final String MENULINKURL = "http://shiyuncloud/WeChat/CardLogin.jsp";
    /**
     * 获取ACCESSTOKEN
     * @return
     */
    public static String  Getaccess_token() {
    	// String requestUrl = ACCESSTOKENURL.replace("APPID", APPID).replace("SECRET", SECRET).replace("CODE", CODE);
        String JsonACCESSTOKEN = HttpTool.httpsRequest(ACCESSTOKENURL, "GET", "");
       // System.out.println(JsonACCESSTOKEN);
        JSONObject jsonObject = JSONObject.fromObject(JsonACCESSTOKEN);
        String access_token=(String) jsonObject.get("access_token");
        return access_token;
    }
    /**
     * 获取api_ticket  添加会员卡时使用
     */
    public static String GetApiTicket(String ACCESS_TOKEN) {
        String APITicketURL = APITICKETURL+ACCESS_TOKEN+"&type=wx_card";
        String JsonApiTicket = HttpTool.httpsRequest(APITicketURL, "GET", "");
        JSONObject jsonObject =JSONObject.fromObject(JsonApiTicket);
        String apiticket = (String) jsonObject.get("ticket");
        return apiticket;
    }

    /**
     * 获取jsapi_ticket  conf注入时使用
     */
    public static String GetJsApiTicket(String ACCESS_TOKEN) {
        String JSAPITicurl =JSAPIURL+ ACCESS_TOKEN+"&type=jsapi";
        String JsonJsApiTicket = HttpTool.httpsRequest(JSAPITicurl, "GET", "");
       // System.out.println("jsapi_ticket接口返回="+JsonJsApiTicket);
        JSONObject jsonobject = JSONObject.fromObject(JsonJsApiTicket);
        String jsapiticket = (String) jsonobject.get("ticket");
       
        return jsapiticket;

    }

    /**
     * 计算签名conf注入时使用 signature
     */

    public static String Getsignature(String jsapi_ticket,String url) {
        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        //产生一个当前的毫秒，这个毫秒其实就是自1970年1月1日0时起的毫秒数
        String timestamp = System.currentTimeMillis()/1000+"";
        HashMap<String,String> map = new HashMap<String,String>();
       // System.out.println("参与签名时间戳为******"+timestamp);
       // System.out.println("参与签名随机字符串****"+nonceStr);
      //  System.out.println("参与签名的jsapi_ticket******"+jsapi_ticket);
       // System.out.println("参与签名的url******"+url);
        map.put("noncestr", nonceStr);
        map.put("jsapi_ticket", jsapi_ticket);
        map.put("timestamp", timestamp);
        map.put("url", url);
        for (Entry<String,String> entry: map.entrySet()) {
           // System.out.println("排序之前:"+entry.getKey()+" 值"+entry.getValue());
        }
       // System.out.println("======================================================");
        SortedMap<String,String> sort=new TreeMap<String,String>(map);
        Set<Entry<String,String>> entry1=sort.entrySet();
        Iterator<Entry<String,String>> it=entry1.iterator();
        String signA = ""; // 根据签名格式组装数据，详见微信支付api\
        int i = 0;
        while(it.hasNext()) {
            Entry<String,String> entry=it.next();
            if (i==0) {
                signA = entry.getKey()+ "="+entry.getValue();
            }else{
                signA += "&"+entry.getKey()+ "="+entry.getValue();
            }
            i++;
           // System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());
        }
        String signature =   getSha1(signA);
      //  System.out.println("成成后的签名="+signature);
        String notisi = signature+"&"+timestamp+"&"+nonceStr;
        return notisi;
    }
    /**
     * sha1
     * @param str
     * @return
     */
    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
/*
	public static void main(String[] args) {
		String sccesstoken = Getaccess_token();
		String jsapiticket = GetJsApiTicket(sccesstoken);

		System.out.println("accesstoken==========="+sccesstoken);
		System.out.println("签名为****"+Getsignature(jsapiticket));
	}
*/

}
