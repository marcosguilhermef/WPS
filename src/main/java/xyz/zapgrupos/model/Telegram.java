package xyz.zapgrupos.model;

import java.io.Serializable;
import java.util.regex.Pattern;
import javax.persistence.*;



@Entity
public class Telegram extends Grupo implements Serializable {

    private final static Pattern REGEX_TITLE  =  Pattern.compile("<span dir=\"auto\">(.+)</span>");
    private final static Pattern REGEX_IMG   =  Pattern.compile("<img class=\"tgme_page_photo_image\" src=\"(.+)\">");
    private final static Pattern REGEX_DESCRIPTION   =  Pattern.compile("<meta property=\"og:description\" content=\"(.+)\"");
    public final static Pattern ZUMBA   =  Pattern.compile("<meta property=\"og:description\" content=\"(.+)\"");

    public Telegram() {
        super();
    }
    public Telegram(String url){
        super(url);
        this.url = url;
    }
    @Override
    public Pattern getTitleRegex() {
        return REGEX_TITLE;
    }
    @Override
    public Pattern getImgUrlRegex() {
        return REGEX_IMG;
    }
    @Override
    public Pattern getRegexDescription() {
        return REGEX_DESCRIPTION;
    }

}
