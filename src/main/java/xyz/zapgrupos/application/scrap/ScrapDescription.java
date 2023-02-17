package xyz.zapgrupos.application.scrap;

import xyz.zapgrupos.model.Grupo;

import java.util.regex.Pattern;

public class ScrapDescription implements ScrapContract{

    @Override
    public String scrap(Grupo grupo) {
        String[] description = grupo.getRegexDescription().matcher(Commander.getBody().toString()).results().map((e) -> e.group(1)).toArray(String[]::new);

        if(description.length != 0){
            grupo.setDescricao(description[0]);
            return description[0];
        }
        return null;
    }
}
