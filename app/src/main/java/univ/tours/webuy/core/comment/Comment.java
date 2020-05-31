package univ.tours.webuy.core.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import univ.tours.webuy.core.utils.BaseWebuy;

public class Comment extends BaseWebuy implements Serializable {
    private String content;
    private Timestamp PublishedAt;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishedAt() {
        return PublishedAt;
    }

    public void setPublishedAt(Timestamp publishedAt) {
        PublishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", PublishedAt=" + PublishedAt +
                '}';
    }
}
