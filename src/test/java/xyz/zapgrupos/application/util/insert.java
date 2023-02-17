package xyz.zapgrupos.application.util;

import org.junit.Test;
import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.GrupoDAO;
import xyz.zapgrupos.model.Telegram;
import java.beans.IntrospectionException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;


public class insert {
    @Test
    public void addGruou() {
        Telegram pessoa = new Telegram("https://fasklfaskldfj/ffffffff");
        pessoa.setId("63ef711dbddc3b3fe6d86175");
        pessoa.setTitulo("[sulista]");
        pessoa.setDescricao("[xandinho!]");
        pessoa.setAtivo(true);
        GrupoDAO dao = new GrupoDAO();
        try {
            Grupo g = dao.salvar(pessoa);
            System.out.println(g.getId());
        } catch (Exception e) {
            System.out.println("here: " + e.getMessage());
        }
    }

    @Test
    public void beandescriptor() throws IntrospectionException, NoSuchFieldException {
        Telegram pessoa = new Telegram("https://fasklfaskldfj.com/ffffffff");
        pessoa.setId("63ef1f079b6f6b2254489656");
        pessoa.setTitulo("[shablau]");
        pessoa.setDescricao("[UM GRUPO MUITewrfqwerqwerqO!]");


        Arrays.stream(pessoa.getClass().getFields()).filter( e -> {
            System.out.println(e.getName()+" : "+e.getModifiers());
            return e.getModifiers() == Modifier.PUBLIC;
        });

    }


    @Test
    public void getAllTeste(){
        GrupoDAO g = new GrupoDAO();
        List<Grupo> gr = g.getAll();
        for(Grupo f : gr){
            System.out.println(f);
        }
    }

}
