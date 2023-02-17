package xyz.zapgrupos.application.scrap;

import xyz.zapgrupos.model.Grupo;

import java.util.regex.Pattern;

public interface ScrapContract <T extends Grupo,L extends Object> {
    public L scrap(T value);
}
