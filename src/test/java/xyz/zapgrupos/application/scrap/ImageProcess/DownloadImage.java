package xyz.zapgrupos.application.scrap.ImageProcess;

import org.junit.Test;
import xyz.zapgrupos.application.ImageProcess.Invokator;

public class DownloadImage {
    @Test
    public void download(){
        Invokator img = new Invokator("https://cdn1.telegram-cdn.org/file/X0uIcueCaErdLD9kR24W3WbC_-dbWkZxHqGalt0OWLikNEqa96kZ7q4Rd2vdQt85a_9xxV3PkBRMB75-chMFyZ53oftaCVj40ETfwQM0m6PkwEBptOh8rl57h5JMIwK1xESD7B8Wm96RlkIHARt_X_ZfF0oiFwr0qjxqRi_7FQnml9tYgsY2HCqKsOmqmCIFZ9aMUltcL7MaBEnCYKg0V4EsWmxd_EZ03NAAEfHrn2ggJdwrHbnXCKAXa1QHlP0gW6FYHncrrVB1vmvnpiF6UmRi24emkH38MKzq2GewCqdXXrUuHM7GW8V_RuUGqvNqfak8pRYllRZal5C2LMfHNA.jpg","sapo");
        img.getImage();
    }
}
