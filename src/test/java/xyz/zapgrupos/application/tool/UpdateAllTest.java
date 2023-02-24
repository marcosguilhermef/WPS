package xyz.zapgrupos.application.tool;

import org.hibernate.sql.Update;
import org.junit.Test;

public class UpdateAllTest {
    @Test
    public void updateAll(){
        Commander t = new Commander();
        t.run(new UpdateAll());
    }
}
