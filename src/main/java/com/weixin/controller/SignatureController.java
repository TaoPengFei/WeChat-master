package com.weixin.controller;

import com.weixin.Oper.MemberCardOperImp;
import com.weixin.card.HttpTool;
import com.weixin.membean.MemberCard;
import com.weixin.util.AddCardUtil;
import com.weixin.util.TokenSingleton;
import com.weixin.util.WeCardUtil;
import com.weixin.util.WeChatApi;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Signature*")
public class SignatureController {
    @RequestMapping("/getSignature.do")
    @ResponseBody
    public  HashMap<String, String> wxconfMethod(HttpServletRequest  request, HttpServletResponse response) {
    	String openid="";
    	HttpSession session = request.getSession();
        HashMap<String,String> map = new HashMap<String, String>();
        //WeCardUtil WeChatTool = new WeCardUtil();
        //需要从前台拿到membercode去数据库匹配
        //获取code 然后放到后台用以获取openid
        String urlcode = request.getParameter("param");
        String cardcode = request.getParameter("cardcode");
        
        String[] codelist = urlcode.split("code=");
        String CODE = codelist[1];
        
        if(CODE.equals((String)session.getAttribute("CODE"))){
        	openid=(String)session.getAttribute("openid");
        }else {
        	 openid = AddCardUtil.GetOpenId(CODE);
             session.setAttribute("CODE", CODE); 
             session.setAttribute("openid", openid); 
        }
        
        String url = urlcode+"&state=123";
      //  String sccesstoken = WeCardUtil.Getaccess_token();
      //  String jsapiticket = WeCardUtil.GetJsApiTicket(sccesstoken);
        TokenSingleton sin = TokenSingleton.getInstance();
        
        HashMap<String,String> hamap = (HashMap<String, String>) sin.getMap();
        String sccesstoken =  hamap.get("access_token");
        String jsapiticket = hamap.get("jsapi_token");
        System.out.println(hamap.get("time"));
        System.out.println("添加卡的sccesstoken==========="+sccesstoken);
        System.out.println("添加卡的jsapiticket==========="+jsapiticket);
        
        
        String notisi=WeCardUtil.Getsignature(jsapiticket,url);
        String[] sourceStrArray = notisi.split("&");
        String signature = sourceStrArray[0];
        String timestamp = sourceStrArray[1];
        String nonceStr = sourceStrArray[2];
        //获取addcard的签名
        String api_ticket =  AddCardUtil.GetApiTicket(sccesstoken);

        String GAddCardSign = AddCardUtil.GetCardSign(api_ticket, timestamp, WeChatApi.CARDID, cardcode, openid, nonceStr);
        map.put("signature",signature);
        map.put("timestamp",timestamp);
        map.put("nonceStr",nonceStr);
        map.put("jsapiticket", jsapiticket);
        map.put("GAddCardSign", GAddCardSign);
        map.put("openid", openid);
        map.put("appid", WeChatApi.APPID);
        map.put("cardId",WeChatApi.CARDID);
        //result.put("data",map);
        return map;

    }
    /**
     * 创建会员卡获取card_id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/CreateCard.do")
    @ResponseBody
    public HashMap<String, String> CreateCard(HttpServletRequest  request, HttpServletResponse response) {
    	String sccesstoken = WeCardUtil.Getaccess_token();
		 String ADD_URL = "https://api.weixin.qq.com/card/create?access_token="+sccesstoken;
    	HashMap<String,String> map = new HashMap<String, String>();
    	map.put("haidilao", "haidilao");
    	String urlcode = request.getParameter("param");
    	JSONObject json_test = JSONObject.fromObject(urlcode);
    	HttpTool.HttpReqPostJson(ADD_URL, "POST", json_test);
    	System.out.println(urlcode);
    	System.out.println(json_test);
		return map;
    	
    }
    
    @RequestMapping("/scanQRCode.do")
    @ResponseBody
    public  HashMap<String, String> scanQRCode(HttpServletRequest  request, HttpServletResponse response) {
    	 HashMap<String,String> map = new HashMap<String, String>();
    	 String urlcode = request.getParameter("param");
    	 String url = urlcode+"&state=123";
    	 TokenSingleton sin = TokenSingleton.getInstance();
         HashMap<String,String> hamap = (HashMap<String, String>) sin.getMap();
         String sccesstoken =  hamap.get("access_token");
         String jsapiticket = hamap.get("jsapi_token");
         System.out.println(hamap.get("time"));
         System.out.println("扫码的sccesstoken==========="+sccesstoken);
         System.out.println("扫码的jsapiticket==========="+jsapiticket);
         String notisi=WeCardUtil.Getsignature(jsapiticket,url);
         String[] sourceStrArray = notisi.split("&");
         map.put("signature", sourceStrArray[0]);
         map.put("timestamp",sourceStrArray[1]);
         map.put("nonceStr",sourceStrArray[2]);
         map.put("appid", WeChatApi.APPID);
        
		return map;
    }
}