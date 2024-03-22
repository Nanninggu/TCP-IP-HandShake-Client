package com.example.TCP.HeaderVlueGetter;

import com.example.TCP.DataSender.DataSender;
import com.example.TCP.Sleep.Sleep;
import com.example.TCP.Sleep.SleepFor10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPHeaderInfo {

    public static void main(String[] args) {
        String host = "localhost"; // Change this to the desired host
        int port = 9999; // Change this to the desired port
        BufferedReader userInput = null;
        try {
            InetAddress address = InetAddress.getByName(host);
            SocketAddress socketAddress = new InetSocketAddress(address, port);
            Socket socket = new Socket();
            socket.connect(socketAddress);

            // Retrieve TCP header information
            int localPort = socket.getLocalPort();
            InetAddress localAddress = socket.getLocalAddress();
            int remotePort = socket.getPort();
            InetAddress remoteAddress = socket.getInetAddress();

            System.out.println("Local Address: " + localAddress);
            System.out.println("Local Port: " + localPort);
            System.out.println("Remote Address: " + remoteAddress);
            System.out.println("Remote Port: " + remotePort);

            // Set up input stream to read user input
            userInput = new BufferedReader(new InputStreamReader(System.in));

            // Create DataSender instance and pass the existing socket to it
            DataSender dataSender = new DataSender(socket);

            String userInputString;
            while ((userInputString = userInput.readLine()) != null) {
                // Send data to server using DataSender
                dataSender.sendData(userInputString);

                // Break loop if user enters "exit"
                if (userInputString.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Close");

            SleepFor10000.sleep();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
