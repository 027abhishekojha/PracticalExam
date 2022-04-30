/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abhishekojha.server1.aospract4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aayus
 */
public class Server {
     private static Socket socket;
       public static void main(String[] args) {
        try {
            int port = 6102;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 6102");
 
            //Server is running always. This is done using this while(true) loop
            while (true) {
                //Reading the message from the client
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String msg = br.readLine();
                System.out.println("Message received from Yash Prajapati - 022 Client is " + msg);
 
                String returnMessage = "";
                try {
                    int d = 0;
                    int v = 0;
                    for (int i = 0; i < msg.length(); ++i) {
                        char k = msg.charAt(i);
 
                        if (k >= '0' && k <= '9') {
                            d++;
                        } else if (k == 'a' || k == 'e' || k == 'i' || k == 'o' || k == 'u') {
                            v++;
                        }
                    }
                    String ans = "No.of characters = " + msg.length() + "; No. of vovels = " + v + "; No.of digits= " + d;
 
                    returnMessage = String.valueOf(ans) + "\n";
                } catch (Exception e) {
                }
 
                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client is " + returnMessage);
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
