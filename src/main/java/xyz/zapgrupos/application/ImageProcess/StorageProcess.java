package xyz.zapgrupos.application.ImageProcess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class StorageProcess<T extends ByteArrayOutputStream> implements ProcessContract<T>{
    public final static String URL_FOLDER = "/home/zispo/imagens/%s";
    public final static String IMAGE_PATH = "/home/zispo/imagens/%s/%s.jpg";
    public String nameImage;

    StorageProcess(String nameImage){
        this.nameImage = nameImage;
    }
    @Override
    public boolean handler(T e){
        try {
            File theDir = new File(String.format(URL_FOLDER, nameImage));
            if (theDir.exists()) {
                theDir.delete();
            }
            theDir.mkdirs();
            InputStream is = new ByteArrayInputStream(e.toByteArray());
            Files.copy(is, Paths.get(String.format(IMAGE_PATH, this.nameImage, this.nameImage)), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(String.format(IMAGE_PATH, this.nameImage, this.nameImage));
            return true;
        }
        catch (IOException err){
            err.printStackTrace();
            return false;
        }
    }
}
