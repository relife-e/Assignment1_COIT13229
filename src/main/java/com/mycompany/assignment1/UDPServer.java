/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.net.*;
import java.io.*;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Date;

public class UDPServer {

    public static void main(String args[]) throws ClassNotFoundException {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket(2227);
            byte[] buffer = new byte[1024];
            while (true) {
                
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                InetAddress clientAddress = request.getAddress(); // Get the client's IP address
                int clientPort = request.getPort();
                buffer = run();
                //System.out.println("Client Request: " + new String(request.getData(), 0, request.getLength()));
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length,
                        clientAddress, clientPort );
                aSocket.send(reply);

            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }

    public static byte [] run() throws ClassNotFoundException {
        ArrayList<Member> m = new ArrayList<>();
        try {

            FileInputStream fos = new FileInputStream("memberlistObject");
            
            ObjectInputStream in = new ObjectInputStream(fos);
            String line;
            byte [] sendData = null;
            while (true) {
                try {
                    Member memb = (Member) in.readObject();
                    m.add(memb); // Add the read Member object to the list
                } catch (EOFException e) {
                    break; // Exit the loop when end of file is reached
                }
            }
           StringBuilder memberDetailsBuilder = new StringBuilder();
            for (Member memb : m) {
             memberDetailsBuilder.append(memb.getAddress()).append(" ")
                            .append(memb.getfName()).append(" ")
                            .append(memb.getlName()).append(" ")
                            .append(memb.getAge()).append(" ")
                            .append(memb.getNum()).append("\n");
            }
            String memberDetails = memberDetailsBuilder.toString();
            sendData = memberDetails.getBytes();
            in.close();
            return sendData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
