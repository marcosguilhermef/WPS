package xyz.zapgrupos.application.scrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import xyz.zapgrupos.model.Grupo;

import java.net.http.HttpResponse;


public class Commander {
    private Grupo grupo;
    public static HttpResponse<String> response;
    public Commander(Grupo grupo){
        this.grupo = grupo;
    }
    public void run(ScrapContract... commander){
        makeRequest();
        for(ScrapContract cm : commander){
            cm.scrap(this.grupo);
        }
    }

    private void makeRequest(){
        Request<String> request = new Request(grupo.getUrl());
        request.run();
        response = request.getResponse();
    }

    public static Document getBody(){
        return Jsoup.parse(response.body());
    }
}
