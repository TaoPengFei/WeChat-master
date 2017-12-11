package com.weixin.po;

/**
 *
 * @author 陶鹏飞
 * Created by 陶鹏飞 on 2017/11/15.
 *
 */
public class News {
    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getPicUrl() {
        return PicUrl;
    }
    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
    public String getUrl() {
        return Url;
    }
    public void setUrl(String url) {
        Url = url;
    }
}
