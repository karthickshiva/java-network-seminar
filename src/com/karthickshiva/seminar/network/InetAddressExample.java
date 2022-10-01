package com.karthickshiva.seminar.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    private static void printIp(String host) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println(host + ": " + inetAddress.getHostAddress());
    }
    public static void main(String[] args) throws UnknownHostException {
        printIp("google.com");
        printIp("facebook.com");
        printIp("localhost");
    }
}
