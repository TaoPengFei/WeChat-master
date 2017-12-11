package com.weixin.po;

import java.util.List;

/**
 *
 * @author 陶鹏飞
 * Created by 陶鹏飞 on 2017/11/15.
 *
 */
public class NewsMessage extends BaseMessage{
    private int ArticleCount;
    private List<News> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }
    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }
    public List<News> getArticles() {
        return Articles;
    }
    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}