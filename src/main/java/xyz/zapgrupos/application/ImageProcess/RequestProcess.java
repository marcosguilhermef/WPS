package xyz.zapgrupos.application.ImageProcess;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestProcess<T extends Image> implements ProcessContract<T>{

    ProcessContract next;

    Image image;
    public RequestProcess(Image image){
        this.next = new ImageProcess(image.getNameIMage());
        this.image = image;
    }
    @Override
    public boolean handler(T url) {
        try(InputStream in = new URL(image.getUrl()).openStream()) {
            return next.handler(in);
        }
        catch (MalformedURLException err){
            err.getMessage();
            return false;
        }
        catch (IOException err){
            err.getMessage();
            return false;
        }
    }
}
