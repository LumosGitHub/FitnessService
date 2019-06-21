package com.fitness.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author 刘冠麟
 */
@Entity
public class NewsListItem implements Serializable {

    private String title;

    @Id
    private Integer newsId;


    private String username;


    public NewsListItem() {
    }

    public NewsListItem(Integer newsId, String title , String username) {
        this.title = title;
        this.newsId = newsId;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewsListItem{");
        sb.append("title='").append(title).append('\'');
        sb.append(", newsId=").append(newsId);
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
