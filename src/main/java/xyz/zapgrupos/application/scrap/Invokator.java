package xyz.zapgrupos.application.scrap;

import xyz.zapgrupos.model.Telegram;
import xyz.zapgrupos.model.WhatsApp;
import xyz.zapgrupos.services.Invoker;

public class Invokator {
    public void run(WhatsApp grupo){
        Commander com = new Commander(grupo);
        com.run(
                new ScrapTitle() ,
                new ScrapImage(),
                new VerifyIfActive<WhatsApp>()
        );
    }

    public void run(Telegram grupo){
        Commander com = new Commander(grupo);
        com.run(
                new ScrapTitle() ,
                new ScrapImage(),
                new ScrapDescription(),
                new VerifyIfActive<Telegram>()
        );
    }

}
