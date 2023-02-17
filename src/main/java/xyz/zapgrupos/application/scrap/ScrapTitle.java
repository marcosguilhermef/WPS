package xyz.zapgrupos.application.scrap;

import org.jsoup.nodes.Element;
import xyz.zapgrupos.model.Grupo;
import org.jsoup.select.Elements;
import java.util.regex.Pattern;
public class ScrapTitle implements ScrapContract{
    @Override
    public String scrap(Grupo grupo) {
        String[] titulo = grupo.getTitleRegex().matcher(Commander.getBody().toString()).results().map((e) -> e.group(1)).toArray(String[]::new);

        if(titulo.length != 0){
            grupo.setTitulo(titulo[0]);
            return titulo[0];
        }

        return null;
    }
}
