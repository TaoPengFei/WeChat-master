package com.weixin.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.weixin.card.HttpTool;

import net.sf.json.JSONObject;

public class AddCardUtil {
	 private static final  String APPID = "wx7ae52acace660eb5";
	 private static final  String SECRET = "76384fdf10fe3a2f2443b0366fd0d882";
	 private static final String APITICKETURL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
	 private static final String GETOPENIDURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	 private static final String CARDID="pAf4H0_r0H3N6zwjHAbyTHBnAM_I";
	 /**
	  * 获取api_ticket  添加会员卡时使用
	  */
	 public static String GetApiTicket(String ACCESS_TOKEN) {
	        String APITicketURL = APITICKETURL+ACCESS_TOKEN+"&type=wx_card";
	        String JsonApiTicket = HttpTool.httpsRequest(APITicketURL, "GET", "");
	        JSONObject jsonObject =JSONObject.fromObject(JsonApiTicket);
	        System.out.println(jsonObject);
	        String apiticket = (String) jsonObject.get("ticket");
	        return apiticket;
	 }
	 
	/**
	 * 根据code 获取openid
	 */
	 public static String GetOpenId(String CODE) {
		 String requestUrl = GETOPENIDURL.replace("APPID", APPID).replace("SECRET", SECRET).replace("CODE", CODE);
		 String jsonOpenId = HttpTool.httpsRequest(requestUrl, "GET", "");
		 JSONObject jsonobject = JSONObject.fromObject(jsonOpenId);
		 System.out.println(jsonobject);
		 String GetOpenId = jsonobject.getString("openid");
		return GetOpenId;
		 
	 }
	 /**
	  * 计算签名得到cardSign
	  * @param api_ticket
	  * @param timestamp
	  * @param card_id
	  * @param code
	  * @param openid
	  * @param nonce_str
	  * @return
	  */
	 public static String GetCardSign(String api_ticket,String timestamp,String card_id,String code,String openid,String nonce_str) {
		/** HashMap<String,String> map = new HashMap<String,String>();
		 map.put("api_ticket", api_ticket);
		 map.put("timestamp", timestamp);
		 map.put("card_id", card_id);
		 map.put("code", code);
		 map.put("openid", openid);
		 map.put("nonce_str", nonce_str);*/
		 List<String> list = new ArrayList<String>();
		 list.add(api_ticket);
		 list.add(timestamp);
		 list.add(card_id);
		 list.add(code);
		 list.add(openid);
		 list.add(nonce_str);
		 Collections.sort(list);
		 String signA = list.get(0)+list.get(1)+list.get(2)+list.get(3)+list.get(4)+list.get(5);
		  System.out.println("===============================");
	        System.out.println("timestamp="+timestamp);
	        System.out.println("nonce_str="+nonce_str);
	        System.out.println("api_ticket="+api_ticket);
	        System.out.println("code="+code);
	        System.out.println("card_id="+card_id);
	        System.out.println("openid="+openid);
	        System.out.println("排序后字符串="+signA);
	        System.out.println("=================================");
		 
		 
		 
		 
		 /*
		 SortedMap<String,String> sort=new TreeMap<String,String>(map);
	        Set<Entry<String,String>> entry1=sort.entrySet();
	        Iterator<Entry<String,String>> it=entry1.iterator();
	        String signA = ""; // 根据签名格式组装数据，详见微信支付api\
	        int i = 0;
	        while(it.hasNext()) {
	            Entry<String,String> entry=it.next();
	            if (i==0) {
	                signA = entry.getValue();
	            }else{
	                signA += entry.getValue();
	            }
	            i++;
	           // System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());
	        }
	        System.out.println("===============================");
	        System.out.println("timestamp="+timestamp);
	        System.out.println("nonce_str="+nonce_str);
	        System.out.println("api_ticket="+api_ticket);
	        System.out.println("code="+code);
	        System.out.println("排序后字符串="+signA);
	        System.out.println("=================================");*/
	        String signature = getSha1(signA);
		return signature;
		 
	 }
	 /**
	  * sha1加密
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
	 public static String  DeleteCode() {
		 String sccesstoken = WeCardUtil.Getaccess_token();
		 String url = "https://api.weixin.qq.com/card/membercard/unactivate?access_token="+sccesstoken;
		 HashMap<String,String> map = new HashMap<String, String>();
		 map.put("card_id", "");
		 map.put("code", "807983709647");
		 JSONObject jsonObject = JSONObject.fromObject(map);
		 String JsonACCESSTOKEN = HttpTool.httpsRequest(url, "POST", "");
		 System.out.println(JsonACCESSTOKEN);
		return JsonACCESSTOKEN;
		 
	 }
	 
	 
	 public static void main(String[] args) {
		/* String sccesstoken = WeCardUtil.Getaccess_token();
		 String GetApiTicket = WeCardUtil.GetApiTicket(sccesstoken);
		 String sccesstoken2 = WeCardUtil.Getaccess_token();
		 String api_ticket =  AddCardUtil.GetApiTicket(sccesstoken2);
		 System.out.println(sccesstoken);
		 System.out.println(sccesstoken2);
		 System.out.println(GetApiTicket);
		 System.out.println(api_ticket);*/
		 appadd();
		
	}
	 
	 
	 
/**
 * 发送http请求 post方式  json数据
 */
	    public static void appadd() {
	        try {
	            //创建连接
	        	 String sccesstoken = WeCardUtil.Getaccess_token();
	    		 String ADD_URL = "https://api.weixin.qq.com/card/code/update?access_token="+sccesstoken;
	            URL url = new URL(ADD_URL);
	            HttpURLConnection connection = (HttpURLConnection) url
	                    .openConnection();
	            connection.setDoOutput(true);
	            connection.setDoInput(true);
	            connection.setRequestMethod("POST");
	            connection.setUseCaches(false);
	            connection.setInstanceFollowRedirects(true);
	            connection.setRequestProperty("Content-Type",
	                    "application/x-www-form-urlencoded");
	            connection.connect();
	            //POST请求
	            DataOutputStream out = new DataOutputStream(
	                    connection.getOutputStream());
	            JSONObject obj = new JSONObject();
	            obj.element("code", "12345678");
	            obj.element("card_id", "pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
	            obj.element("new_code", "3495739475");
	           
	           // obj.element("new_code", "123456789");
	            out.writeBytes(obj.toString());
	            out.flush();
	            out.close();
	            //读取响应
	            BufferedReader reader = new BufferedReader(new InputStreamReader(
	                    connection.getInputStream()));
	            String lines;
	            StringBuffer sb = new StringBuffer("");
	            while ((lines = reader.readLine()) != null) {
	                lines = new String(lines.getBytes(), "utf-8");
	                sb.append(lines);
	            }
	            System.out.println(sb);
	            reader.close();
	            // 断开连接
	            connection.disconnect();
	        } catch (MalformedURLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	   
}
