package xyz.zapgrupos.application.ImageProcess;

public class Invokator {
    Image img;
    public Invokator(String url, String nameImage){
        img = new Image(url,nameImage);
        RequestProcess<Image> download = new RequestProcess<>(img);
        download.handler(null);
    }

    public Image getImage(){
        return img;
    }
}
