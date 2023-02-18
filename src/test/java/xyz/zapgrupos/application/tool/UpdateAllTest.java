package xyz.zapgrupos.application.tool;

import org.hibernate.sql.Update;
import org.junit.Test;

public class UpdateAllTest {
    @Test
    public void updateAll(){
        UpdateAll up = new UpdateAll();
        up.run();
    }
}
