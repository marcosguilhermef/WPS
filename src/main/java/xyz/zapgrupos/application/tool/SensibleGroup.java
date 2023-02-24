package xyz.zapgrupos.application.tool;

import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.services.GruposDAO;
import xyz.zapgrupos.services.ServiceDAO;

public class SensibleGroup implements ToolComander<String>{

    ServiceDAO<Grupo, String> service = new GruposDAO();

    Grupo g;
    @Override
    public void run() {
        g.setSensivel(!g.isSensivel());
        System.out.println("[FINISH]: "+g.toString());
        service.update(g);
    }

    @Override
    public void setParameters(String id) {
        g = service.getById(id);
        System.out.println("[INIT]: "+g.toString());
    }
}
