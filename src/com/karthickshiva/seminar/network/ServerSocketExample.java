package com.karthickshiva.seminar.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);
        long startTime = System.currentTimeMillis();
        do {
            Socket socket = serverSocket.accept();
            (new FeedbackThread(socket)).start();
        } while (System.currentTimeMillis() - startTime >= (60 * 60 * 1000));
        serverSocket.close();
    }

    static class FeedbackThread extends Thread {
        private Socket socket;
        FeedbackThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream is = null;
            try {
                is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("ena " + line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
