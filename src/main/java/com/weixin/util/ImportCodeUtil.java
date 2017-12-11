package com.weixin.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.weixin.card.HttpTool;

import net.sf.json.JSONObject;

public class ImportCodeUtil {
	private static String depositurl = "http://api.weixin.qq.com/card/code/deposit?access_token=";
	private static String urlurl = "http://api.weixin.qq.com/card/code/checkcode?access_token=";
	
	
	/**
	 * 导入Code 每次导入一个
	 * @return
	 */
	public static String DepositCode() {
		String sccesstoken = WeCardUtil.Getaccess_token();
		String Arr[] = {"95687498"};
		String url = urlurl+sccesstoken;
		List<String> list = new ArrayList<>();
		list.add("333344445555");
        JSONObject obj = new JSONObject();
        obj.element("card_id", "pDF3iY0_dVjb_Pua96MMewA96qvA");
        obj.element("code", Arr[0]);
       String info =  HttpTool.HttpReqPostJson(url, "POST", obj);
	     
		return info;
		
	}
	
	public static void main(String[] args) {
		System.out.println(DepositCode());
		
	}

}
