package xyz.zapgrupos.application.tool;

public class Commander {

    public <T> void run(ToolComander<T> commander, T parameter){
        commander.setParameters(parameter);
        commander.run();
    }
    public <T> void run(ToolComander<T> commander){
        commander.run();
    }
}
