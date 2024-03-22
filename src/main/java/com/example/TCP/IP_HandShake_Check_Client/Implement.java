package com.example.TCP.IP_HandShake_Check_Client;

import com.example.TCP.Sleep.Sleep;

import java.io.*;
import java.net.*;

public class Implement {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 9999);
            System.out.println("Connected to server.");
            Sleep.sleep(); // 10초 대기

            String IP_Address = String.valueOf(socket.getInetAddress()); // 해당 연결된 IP Address를 찾는다.
            String LocalPort = String.valueOf(socket.getLocalPort()); // 해당 연결된 Port Number를 찾는다.
            System.out.println(IP_Address + " IP_Address");
            System.out.println(LocalPort + " LocalPort" );

            // Open input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Sleep sleep = new Sleep();

            // Perform handshake
            String message = in.readLine();
            System.out.println("message ::::: " + message);
            if ("SYN".equals(message)) {
                System.out.println("⏪⏪⏪⏪⏪ Client: SYN received ⏪⏪⏪⏪⏪");
                Sleep.sleep(); // 10초 대기
                out.println("ACK");
                System.out.println("⏩⏩⏩⏩⏩ Client: ACK sent ⏩⏩⏩⏩⏩");
                Sleep.sleep(); // 10초 대기
            }

            // Wait for FIN and respond with ACK
            message = in.readLine();
            if ("FIN".equals(message)) {
                System.out.println("⏪⏪⏪⏪⏪ Client: FIN received ⏪⏪⏪⏪⏪");
                Sleep.sleep(); // 10초 대기
                out.println("ACK");
                System.out.println("⏩⏩⏩⏩⏩ Client: ACK sent ⏩⏩⏩⏩⏩");
                Sleep.sleep(); // 10초 대기
            }

            // Close resources
            in.close();
            out.close();
            socket.close();
            System.out.println("END");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
