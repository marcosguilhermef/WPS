package xyz.zapgrupos.application.ImageProcess;

public class Image {
    public String url;
    public String raw;
    public String nameIMage;

    public Image(String url, String nameIMage){
        this.url = url;
        this.nameIMage = nameIMage;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getNameIMage() {
        return nameIMage;
    }

    public void setNameIMage(String nameIMage) {
        this.nameIMage = nameIMage;
    }
}
