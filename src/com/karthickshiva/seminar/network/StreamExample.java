package com.karthickshiva.seminar.network;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("files/sample.txt"); //hello
        FileOutputStream fos = new FileOutputStream("files/output.txt");
        int c;
        while((c = fis.read()) != -1) {
            fos.write(c);
        }
    }
}
