package xyz.zapgrupos.application.scrap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

public class Request <T>{
    private String url;
    private HttpResponse<T> response;
    public Request(String url){
        this.url = url;
    }

    public void run(){
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                        URI.create(url))
                .header("accept", "application/json")
                .build();
        try {
            response = (HttpResponse<T>) client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Document getBody(){
        return Jsoup.parse((String) response.body());
    }

    public HttpResponse<T> getResponse(){
        return response;
    }
}
