package xyz.zapgrupos.application.tool;

import org.junit.Test;

public class VerifyGroupTest {
    @Test
    public void testVerifyGroup(){
        VerifyGroup f = new VerifyGroup();
        f.setParameters("6142752e1dbe863be63f09f8");
        f.run();
    }
}
