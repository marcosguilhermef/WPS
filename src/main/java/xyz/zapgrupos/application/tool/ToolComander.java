package xyz.zapgrupos.application.tool;

public interface ToolComander<T>{
    public void run();
    public void setParameters(T a);
}
