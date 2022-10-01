package com.karthickshiva.seminar.network;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLStreamExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ash_Tree_-_geograph.org.uk_-_590710.jpg");
        FileOutputStream fos = new FileOutputStream("files/image.jpg");
        InputStream is = url.openStream();
        int c;
        int bytes = 0;
        while((c = is.read()) != -1) {
            fos.write(c);
            bytes++;
        }
        System.out.println(bytes/1000 + " KB downloaded");
        is.close();
        fos.close();
    }
}
