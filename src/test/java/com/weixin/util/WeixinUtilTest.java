package com.weixin.util;

import com.weixin.po.AccessToken;
import junit.framework.TestCase;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 *
 * @author 陶鹏飞
 * Created by 陶鹏飞 on 2017/11/16.
 *
 */
public class WeixinUtilTest extends TestCase {

    /*@Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }*/

    /**
     *  测试票据access_token的获取
     */
    @Test
    public void testAccessToken() {
        try {
            AccessToken token = WeixinUtil.getAccessToken();
            System.out.println("token:"+token.getToken());
            System.out.println("expiresIn:"+token.getExpiresIn());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  测试文件上传
     */
    @Test
    public void testUpload() throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        try {
            AccessToken token1 = WeixinUtil.getAccessToken();
            String filePath = "/home/tpf/IdeaProjects/WeChat/src/main/webapp/image/park1.jpg";
			String media_id = WeixinUtil.upload(filePath, token1.getToken(), "image");
			System.out.println("media_id:"+media_id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  测试用户自定义菜单
     */
    @Test
    public void testMenu() {
        try {
            AccessToken tokenM = WeixinUtil.getAccessToken();
            String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
            int result = WeixinUtil.createMenu(tokenM.getToken(), menu);
            if(result==0){
                System.out.println("创建成功");
                System.out.print(menu);
            }else{
                System.out.println("创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
