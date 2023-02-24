package xyz.zapgrupos.application.util;

import org.junit.Test;
import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.WhatsApp;
import xyz.zapgrupos.services.GruposDAO;
import xyz.zapgrupos.model.Telegram;
import java.beans.IntrospectionException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;


public class insert {

    public String random(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    @Test
    public void addGruou() {
        WhatsApp pessoa = new WhatsApp("https://"+random());
        pessoa.setTitulo("[sulista]");
        pessoa.setDescricao("[xandinho!]");
        pessoa.setAtivo(false);
        GruposDAO dao = new GruposDAO();
        try {
            Grupo g = dao.insert(pessoa);
            System.out.println(g.getId());
        } catch (Exception e) {
            System.out.println("here: " + e.getMessage());
        }
    }

    @Test
    public void update(){
        Telegram pessoa = new Telegram("https://"+random());
        pessoa.setTitulo("[TESTANDO UPDATE 2]"+random());
        pessoa.setDescricao("[[TESTANDO UPDATE 2]]"+random());
        pessoa.setAtivo(true);
        pessoa.setId("63f00b82f1ebde3ba92b0fc6");
        GruposDAO dao = new GruposDAO();
        try {
            Grupo g = dao.update(pessoa);
            System.out.println(g.getId());
        } catch (Exception e) {
            System.out.println("here: " + e.getMessage());
        }
    }

    @Test
    public void findId(){
        GruposDAO dao = new GruposDAO();
        Grupo f = dao.getById("6142752f1dbe863be63f09fd");
        System.out.println(f.toString());
    }

    @Test
    public void beandescriptor() throws IntrospectionException, NoSuchFieldException {
        Telegram pessoa = new Telegram("https://fasklfaskldfj.com/sdafasdfadsf");
        pessoa.setTitulo("[shablau]");
        pessoa.setDescricao("[UM GRUPO MUITewrfqwerqwerqO!]");


        Arrays.stream(pessoa.getClass().getFields()).filter( e -> {
            System.out.println(e.getName()+" : "+e.getModifiers());
            return e.getModifiers() == Modifier.PUBLIC;
        });

    }



}
