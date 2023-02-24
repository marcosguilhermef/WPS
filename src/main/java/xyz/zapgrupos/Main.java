package xyz.zapgrupos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("O que você deseja realizar?");
        System.out.println("a: UpdateAll");
        System.out.println("b: verifyGroup?");
        System.out.println("c: sensible");

        Scanner s = new Scanner(System.in);
        String commander = s.next();

        switch (commander){
            case "a":
                App.updateAll();
                break;
            case "b":
                App.verify();
                break;
            case "c":
                App.sernsible();
                break;
        }
        System.out.println("-----------------------------------------------------------------------------");
        Main.main(args);
    }
}