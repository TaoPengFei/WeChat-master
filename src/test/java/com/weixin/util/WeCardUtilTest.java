package com.weixin.util;

import org.junit.Test;

import static com.weixin.util.WeCardUtil.GetJsApiTicket;
import static com.weixin.util.WeCardUtil.Getaccess_token;
import static com.weixin.util.WeCardUtil.Getsignature;

public class WeCardUtilTest {
    @Test
    public void testWeCardUtil() {
        String sccesstoken = Getaccess_token();
        String jsapiticket = GetJsApiTicket(sccesstoken);

        System.out.println("accesstoken==========="+sccesstoken);
        System.out.println("签名为****"+Getsignature(jsapiticket,""));

    }
}
