package xyz.zapgrupos.application.scrap;

import xyz.zapgrupos.model.Telegram;
import xyz.zapgrupos.model.WhatsApp;
import xyz.zapgrupos.services.Invoker;

import java.net.http.HttpResponse;

public class Invokator {
    public void run(WhatsApp grupo){
        Commander com = new Commander(grupo);
        com.run(
                new ScrapTitle() ,
                new ScrapImage(),
                new VerifyIfActive<WhatsApp>()
        );
        Commander.response = null;
    }

    public void run(Telegram grupo){
        Commander com = new Commander(grupo);
        com.run(
                new ScrapTitle() ,
                new ScrapImage(),
                new ScrapDescription(),
                new VerifyIfActive<Telegram>()
        );
        Commander.response = null;
    }

}
