package xyz.zapgrupos.application.scrap;

import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import xyz.zapgrupos.application.ImageProcess.Image;
import xyz.zapgrupos.application.ImageProcess.Invokator;
import xyz.zapgrupos.model.Grupo;

import java.util.ArrayList;
import java.util.List;

public class ScrapImage implements ScrapContract{
    @Override
    public String scrap(Grupo grupo) {
        String[] urls = grupo.getImgUrlRegex().matcher(Commander.getBody().toString().toString()).results().map((e) -> e.group(1)).toArray(String[]::new);
        if(urls.length != 0){
            grupo.setImgGroupUrl(urls[0].replaceAll("&amp;","&"));
            String imgProcessed = downloadImage(urls[0].replaceAll("&amp;","&"), grupo.getId());
            List<String> url = new ArrayList<>();
            url.add(imgProcessed);
            grupo.setImg(url);
            return urls[0].replaceAll("&amp;","&");
        }
        return null;
    }

    private String downloadImage(String url, String name){
        System.out.println("Download image");
        Invokator imbProcess = new Invokator(url, name);
        return imbProcess.getImage().getResouseUrl();
    }
}
