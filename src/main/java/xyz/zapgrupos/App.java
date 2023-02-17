package xyz.zapgrupos;

import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.WhatsApp;

public class App {
    public void runScrap(Grupo grupo){

    }

    public void runScrap(String url){
        WhatsApp w = new WhatsApp(url);
        //Scrap.run(w);
    }
}
