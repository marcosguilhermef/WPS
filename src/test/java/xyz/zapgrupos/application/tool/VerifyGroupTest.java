package xyz.zapgrupos.application.tool;

import org.junit.Test;

public class VerifyGroupTest {
    @Test
    public void testVerifyGroup(){
       Commander t = new Commander();
       t.run(new VerifyGroup(), "6142752e1dbe863be63f09f8");
    }
}
