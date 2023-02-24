package xyz.zapgrupos.application.scrap;

import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.Telegram;
import xyz.zapgrupos.model.WhatsApp;

public class VerifyIfActive<T extends Grupo>  implements ScrapContract<T,Boolean> {


    @Override
    public Boolean scrap(T grupo) {
        if(grupo instanceof Telegram){
            return verificar((Telegram) grupo);
        }else if(grupo instanceof WhatsApp){
            return verificar((WhatsApp) grupo);
        }
        return false;
    }

    private boolean verificar(Telegram grupo){
        if( (grupo.getTitulo().isEmpty()) || (grupo.getTitulo().isBlank()) || (grupo.getTitulo() == null)){
            grupo.setAtivo(true);
            System.out.println(grupo.getImg());
            System.out.println(String.format("O grupos %s para telegram está ativo", grupo.getTitulo()));
            return true;
        }
        grupo.setAtivo(false);
        return false;
    }

    private boolean verificar(WhatsApp grupo){
        if(grupo.getTitulo() != null){
            grupo.setAtivo(true);
            System.out.println(String.format("O grupos %s para whatsapp está ativo", grupo.getTitulo()));
            return true;
        }
        grupo.setAtivo(false);
        return false;
    }
}
