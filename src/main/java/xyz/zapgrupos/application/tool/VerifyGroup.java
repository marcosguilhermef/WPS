package xyz.zapgrupos.application.tool;

import xyz.zapgrupos.application.scrap.Invokator;
import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.Telegram;
import xyz.zapgrupos.model.WhatsApp;
import xyz.zapgrupos.services.GruposDAO;
import xyz.zapgrupos.services.ServiceDAO;

public class VerifyGroup implements ToolComander<String>{

    ServiceDAO<Grupo,String> s = new GruposDAO();
    Grupo grupo = null;
    @Override
    public void run() {
        Invokator scrap = new Invokator();

        if(grupo.getType().equals("WhatsApp")){
            scrap.run((WhatsApp) grupo);
            System.out.println("[finish]: "+grupo.toString());
            s.update(grupo);
        }else{
            scrap.run((Telegram) grupo);
            System.out.println("[finish]: "+grupo.toString());
            s.update(grupo);
        }

    }
    @Override
    public void setParameters(String a) {
        grupo = s.getById(a.toString());
        System.out.println("[init]: "+grupo.toString());

    }

}
