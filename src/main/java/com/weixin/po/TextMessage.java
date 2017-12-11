package com.weixin.po;

/**
 *
 * @author 陶鹏飞
 * Created by 陶鹏飞 on 2017/11/15.
 *
 */
public class TextMessage extends BaseMessage {
    private String Content;
    private String MsgId;

    public String getMsgId() {
        return MsgId;
    }
    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
}
