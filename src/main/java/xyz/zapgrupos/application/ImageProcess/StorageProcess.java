package xyz.zapgrupos.application.ImageProcess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class StorageProcess<T extends ByteArrayOutputStream> implements ProcessContract<T>{
    public final String URL_FOLDER ;// = "/home/zispo/imagens/%s";
    public final String IMAGE_PATH;// = "/home/zispo/imagens/%s/%s.jpg";
    public final String IMAGE_URL;// = "/home/zispo/imagens/%s/%s.jpg";

    public String nameImage;
    public Image image;

    StorageProcess(Image image){
        this.nameImage = image.getNameIMage();
        this.image = image;
        Properties p = readPropertiesFile("directories.properties");
        URL_FOLDER = p.getProperty("URL_FOLDER");
        IMAGE_PATH = p.getProperty("IMAGE_PATH");
        IMAGE_URL  = p.getProperty("IMAGE_URL");

    }

    private static Properties readPropertiesFile(String fileName)  {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
            fis.close();

        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return prop;
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
            this.image.setResouseUrl(String.format(IMAGE_URL, this.nameImage, this.nameImage));
            System.out.println(String.format(IMAGE_URL, this.nameImage, this.nameImage));
            return true;
        }
        catch (IOException err){
            err.printStackTrace();
            return false;
        }
    }
}
