package com.karthickshiva.seminar.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FeedbackMultiClientSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);
        long startTime = System.currentTimeMillis();
        do {
            Socket socket = serverSocket.accept();
            FeedBackThread thread = new FeedBackThread(socket);
            thread.start();
        } while (System.currentTimeMillis() - startTime < (60L * 60 * 1000));
        serverSocket.close();
    }

    static class FeedBackThread extends Thread {
        private Socket socket;

        FeedBackThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}