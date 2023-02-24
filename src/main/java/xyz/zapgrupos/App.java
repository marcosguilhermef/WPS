package xyz.zapgrupos;

import xyz.zapgrupos.application.tool.Commander;
import xyz.zapgrupos.application.tool.SensibleGroup;
import xyz.zapgrupos.application.tool.UpdateAll;
import xyz.zapgrupos.application.tool.VerifyGroup;
import xyz.zapgrupos.model.Grupo;
import xyz.zapgrupos.model.WhatsApp;

import java.util.Scanner;

public class App {
    private static Commander comm = new Commander();
    public static void updateAll(){
        comm.run(new UpdateAll());
    }

    public static void sernsible(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o _id do grupo?");
        String _id = scan.next();
        comm.run(new SensibleGroup(),_id);
    }

    public static void verify(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o _id do grupo?");
        String _id = scan.next();
        comm.run(new VerifyGroup(),_id);
    }
}
