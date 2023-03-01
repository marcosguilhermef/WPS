package xyz.zapgrupos.application.util;

import org.junit.Test;
import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.services.GruposDAO;

import java.util.List;

public class select {
    @Test
    public void addGruou2() {

        GruposDAO dao = new GruposDAO();
        try {
            List<Grupo> g = dao.getAll();
            int i = 0;
            for(Grupo a : g){
                i++;
                System.out.println(
                        String.format("%s ) [_ID]: %s [URL]: %s ", i,a.getId(), a.getUrl())
                );
            }
        } catch (Exception e) {
            System.out.println("here: " + e.getMessage());
        }
    }
}
