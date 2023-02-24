package xyz.zapgrupos.application.tool;

import org.junit.Test;
import xyz.zapgrupos.App;
import xyz.zapgrupos.model.Grupo;

public class SensibleGroupTest {
    @Test
    public void tournSensible(){
        Commander t = new Commander();
        t.run(new SensibleGroup(), "6142752e1dbe863be63f09f8");
    }
}
