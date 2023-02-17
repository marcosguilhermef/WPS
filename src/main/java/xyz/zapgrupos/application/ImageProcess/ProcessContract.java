package xyz.zapgrupos.application.ImageProcess;

import java.io.IOException;
import java.io.InputStream;

public interface ProcessContract<T> {
    boolean handler(T e);
}
