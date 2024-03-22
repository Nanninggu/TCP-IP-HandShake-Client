package com.example.TCP.DataSender;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class DataSender {
    private Socket socket;
    private PrintWriter out;

    public DataSender(Socket socket) {
        this.socket = socket;
        try {
            // Set up PrintWriter for sending data
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(String data) {
        // Send data over the existing socket connection
        if (out != null) {
            out.println(data);
        } else {
            System.err.println("Failed to send data: PrintWriter is null.");
        }
    }
}
