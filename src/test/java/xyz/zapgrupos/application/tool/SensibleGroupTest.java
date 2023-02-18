package xyz.zapgrupos.application.tool;

import org.junit.Test;
import xyz.zapgrupos.model.Grupo;

public class SensibleGroupTest {
    @Test
    public void tournSensible(){
        SensibleGroup f = new SensibleGroup();
        f.setParameters("6142752e1dbe863be63f09f8");
        f.run();
    }
}
