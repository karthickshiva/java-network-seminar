package com.karthickshiva.seminar.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8090);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            line = scanner.nextLine();
            pw.println(line);
            pw.flush();
        } while (!"end".equals(line));
        socket.close();
    }
}
