package com.weixin.po;


import org.json.JSONException;

import java.util.Collection;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 陶鹏飞
 * Created by 陶鹏飞 on 2017/11/16.
 *
 */
/*
public class WxCardBaseInfo  {

    org.json.JSONObject m_data;

    public WxCardBaseInfo() {
        m_data = new org.json.JSONObject();
        try {
            m_data.put("date_info", new org.json.JSONObject());
            m_data.put("location_id_list", new org.json.JSONArray());
            m_data.put("sku", new org.json.JSONObject());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toJsonString() {
        return m_data.toString();
    }

    public String toString() {
        return toJsonString();
    }

    public void setLogoUrl(String logoUrl) {
        try {
            m_data.put("logo_url", logoUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getLogoUrl() {
        return m_data.optString("logo_url");
    }

    static int CODE_TYPE_TEXT = 0;
    static int CODE_TYPE_BARCODE = 1;
    static int CODE_TYPE_QRCODE = 2;

    public void setCodeType(int code) {
        try {
            m_data.put("code_type", code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getCodeType() {
        return m_data.optInt("code_type");
    }

    public void setBrandName(String name) {
        try {
            m_data.put("brand_name", name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String GetBrandName() {
        return m_data.optString("brand_name");
    }

    public void setTitle(String title) {
        try {
            m_data.put("title", title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return m_data.optString("title");
    }

    public void setSubTitle(String subTitle) {
        try {
            m_data.put("sub_title", subTitle);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getSubTitle() {
        return m_data.optString("sub_title");
    }

    public void setDateInfoTimeRange(Date beginTime, Date endTime) {
        setDateInfoTimeRange(beginTime.getTime() / 1000, endTime.getTime() / 1000);
    }

    public void setDateInfoTimeRange(long beginTimestamp, long endTimestamp) {
        try {
            getDateInfo().put("type", 1);
            getDateInfo().put("begin_timestamp", beginTimestamp);
            getDateInfo().put("end_timestamp", endTimestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setDateInfoFixTerm(int fixedTerm) {
        setDateInfoFixTerm(fixedTerm, 0);
    }

    public void setDateInfoFixTerm(int fixedTerm, int fixedBeginTerm) { //fixedBeginTerm是领取后多少天开始生效
        try {
            getDateInfo().put("type", 2);
            getDateInfo().put("fixed_term", fixedTerm);
            getDateInfo().put("fixed_begin_term", fixedBeginTerm);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public org.json.JSONObject getDateInfo() {
        return m_data.optJSONObject("date_info");
    }

    public void setColor(String color) {
        try {
            m_data.put("color", color);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getColor() {
        return m_data.optString("color");
    }

    public void setNotice(String notice) {
        try {
            m_data.put("notice", notice);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getNotice() {
        return m_data.optString("notice");
    }

    public void setServicePhone(String phone) throws JSONException {
        m_data.put("service_phone", phone);
    }

    public String getServicePhone()
    {
        return m_data.optString("service_phone");
    }

    public void setDescription(String desc) throws JSONException {
        m_data.put("description", desc);
    }

    public String getDescription()
    {
        return m_data.optString("description");
    }

    public void setLocationIdList(Collection<Integer> value) throws JSONException {
        org.json.JSONArray array = new org.json.JSONArray();
        value.stream().forEach((integer) ->
        {
            array.put(integer);
        });
        m_data.put("location_id_list", array);
    }

    public void addLocationIdList(int locationId) throws JSONException {
        getLocationIdList().put(locationId);
    }

    public org.json.JSONArray getLocationIdList() throws JSONException {
        return m_data.getJSONArray("location_id_list");
    }

    public void setUseLimit(int limit) throws JSONException {
        m_data.put("use_limit", limit);
    }

    public int getUseLimit()
    {
        return m_data.optInt("useLimit");
    }

    public void setGetLimit(int limit) throws JSONException {
        m_data.put("get_limit", limit);
    }

    public int getGetLimit()
    {
        return m_data.optInt("get_limit");
    }

    public void setCanShare(boolean canShare) throws JSONException {
        m_data.put("can_share", canShare);
    }

    public boolean getCanShare() {
        return m_data.optBoolean("can_share");
    }

    public void setCanGiveFriend(boolean canGive) throws JSONException {
        m_data.put("can_give_friend", canGive);
    }

    public boolean getCanGiveFriend() {
        return m_data.optBoolean("can_give_friend");
    }

    public void setUseCustomCode(boolean isUse) throws JSONException {
        m_data.put("use_custom_code", isUse);
    }

    public boolean getUseCustomCode() {
        return m_data.optBoolean("use_custom_code");
    }

    public void setBindOpenid(boolean isBind) throws JSONException {
        m_data.put("bind_openid", isBind);
    }

    public boolean getBindOpenid()
    {
        return m_data.optBoolean("bind_openid");
    }

    public void setQuantity(int quantity) throws JSONException {
        m_data.optJSONObject("sku").put("quantity", quantity);
    }

    public int getQuantity()
    {
        return m_data.optJSONObject("sku").optInt("quantity");
    }
}
*/
