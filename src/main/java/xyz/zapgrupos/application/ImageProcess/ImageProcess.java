package xyz.zapgrupos.application.ImageProcess;

import java.awt.*;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

public class ImageProcess<T extends InputStream> implements ProcessContract<T>{
    ProcessContract next;
    String nameImage;
    ImageProcess(String nameImage){
        this.nameImage = nameImage;
        this.next = new StorageProcess(nameImage);
    }
    @Override
    public boolean handler(T e){
        try{
            BufferedImage imageResized = resizeImage(ImageIO.read(e), 320, 320);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(imageResized, "jpg", os);
            return next.handler(os);
        }catch (IOException err){
            return false;
        }
    }
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

}
