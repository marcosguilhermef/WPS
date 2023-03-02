package xyz.zapgrupos.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Embeddable
public class Image {
    public String url;
    public Date created_at;

    public Image(){

    }
    public Image(String url){
        this.url = url;
        created_at = new Date();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

}
