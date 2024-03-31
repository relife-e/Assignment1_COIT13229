/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.net.*;
import java.io.*;

//UDPClient class that interacts with UDPServer. This class is used by manager manager
public class UDPClient {
    //initialzinghostname
    private static String hostName;

    public static void main(String args[]) {
        DatagramSocket aSocket = null;
        StringBuilder str = new StringBuilder();
        hostName = "localhost"; //sets variable hostName as localhost
        try {
            aSocket = new DatagramSocket(); //creating new datagram socket
            byte[] m = str.toString().getBytes(); //converts all the str data to bytes
            InetAddress aHost = InetAddress.getByName(hostName); //it retrives the ip address
            int serverPort = 2227;//initializing serverport 
            //request datagrampacket to send to server 		                                                 
            DatagramPacket request = new DatagramPacket(m, str.length(), aHost, serverPort);
            aSocket.send(request); //sends request object
            byte[] buffer = new byte[1000]; //creating a byte array that holds data from datagram
            // packet to receive message, specify, array and array size
            DatagramPacket reply = new DatagramPacket(buffer,
                    buffer.length);

            aSocket.receive(reply); //recive reply from server and stores it in reply Datagram packet
            //disply reply form server i.e. deserialized data 
            System.out.println("First Name \t|" + "Last Name \t|" + "Address \t|" + "Age\t|" + "Number  |");
            System.out.println("=========================================================================");
            System.out.println( new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage()); //catches when it fails to create or acess socket
        } catch (IOException e) { 
            System.out.println("Error while reciving file " + e.getMessage()); //catches error whe reciving reply from server
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
