package xyz.zapgrupos.application.scrap;

import org.junit.Test;
import xyz.zapgrupos.model.Telegram;

public class GroupProcess {
    @Test
    public void download(){
        Invokator inv = new Invokator();
        Telegram wp = new Telegram("https://t.me/wpgruposc");
        inv.run(wp);
        //inv.run(wp1);
        System.out.println("concluido: "+wp.getTitulo());
        System.out.println("concluido: "+wp.getAtivo());
        System.out.println("concluido: "+wp.getUrl());
        System.out.println("concluido: "+wp.getImgGroupUrl());

    }
}
