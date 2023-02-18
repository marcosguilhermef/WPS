package xyz.zapgrupos.application.tool;

import xyz.zapgrupos.application.scrap.Invokator;
import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.Telegram;
import xyz.zapgrupos.model.WhatsApp;
import xyz.zapgrupos.services.GruposDAO;
import xyz.zapgrupos.services.ServiceDAO;

import java.util.Iterator;
import java.util.List;

public class UpdateAll implements ToolComander<String>{

    ServiceDAO<Grupo, String> service = new GruposDAO();
    List<Grupo> grupos = null;
    Iterator<Grupo> gruposInterator = null;

    public UpdateAll(){
        serParameters();
    }
    @Override
    public void run() {
        Invokator invokator = new Invokator();
        int i = 0;
        while (gruposInterator.hasNext()){
            Grupo gp = gruposInterator.next();
            System.out.println("[Atualizando index: ]"+i);
            switch (gp.getType()){
                case "WhatsApp":
                    System.out.println(String.format("Atualizando: %s do tipo WhatsApp", gp.getId()));
                    invokator.run((WhatsApp) gp);
                    service.update(gp);
                break;
                case "Telegram":
                    System.out.println(String.format("Atualizando: %s do tipo Telegram", gp.getId()));
                    invokator.run((Telegram) gp);
                    service.update(gp);
                    break;
                default:
                    System.out.println(String.format("Não foi identificado o tipo desde grupo %s", gp.getId()));
            }
            this.gruposInterator.remove();
            i++;
        }
    }

    @Override
    public void setParameters(String a) {

    }

    public void serParameters(){
        grupos = service.getAll();
        gruposInterator = this.grupos.iterator();
    }
}
