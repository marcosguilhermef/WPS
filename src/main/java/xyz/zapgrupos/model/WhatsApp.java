package xyz.zapgrupos.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.regex.Pattern;
@Entity
public class WhatsApp extends Grupo implements Serializable {
    private final static Pattern REGEX_TITLE  =  Pattern.compile("style=\"color:#5E5E5E;\">(.+)</h3>");
    private final static Pattern REGEX_IMG   =  Pattern.compile("<img class=\"_9vx6\" src=\"(.+)\"");

    public WhatsApp(){
        super();
    }
    public WhatsApp(String url){
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
    public Pattern getRegexDescription(){
        return null;
    }
}
