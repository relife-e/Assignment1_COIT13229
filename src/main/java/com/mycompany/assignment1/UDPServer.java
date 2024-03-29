/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

//UDPServer that interacts with UDPClient
public class UDPServer {

    public static void main(String args[]) throws ClassNotFoundException {
        DatagramSocket aSocket = null; //initialzing DatagramSocket
        System.out.println("Dispaying memberList object as per client request:");
        try {
            aSocket = new DatagramSocket(2227); //creating new DatagramSocket object
            byte[] buffer = new byte[1024]; //creating a byte arrays that holds the buffer data
            while (true) {
                //Creating a request DatagramPacket that holds client data
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request); //reciving the request
                InetAddress clientAddress = request.getAddress(); // Get the client's IP address
                int clientPort = request.getPort(); //getting client port
                buffer = run();//calls run() method and stores it in buffer

                //creating a DatagramPacket reply that sends data to UDPClient
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length,
                        clientAddress, clientPort);
                aSocket.send(reply); //sends reply datagram packet

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

    //run method
    public static byte[] run() {
        ArrayList<Member> m = new ArrayList<>();
        try {

            FileInputStream fos = new FileInputStream("memberlistObject"); //reading file named memberlistObject

            ObjectInputStream in = new ObjectInputStream(fos); //reading input object from fos

            byte[] sendData = null;
            while (true) {
                try {
                    Member memb = (Member) in.readObject();
                    m.add(memb); // Add the read Member object to the list
                } catch (ClassNotFoundException e) {

                } catch (EOFException e) {
                    break; // Exit the loop when end of file is reached
                }
            }

            StringBuilder memberDetailsBuilder = new StringBuilder();//String builder object that stores memberdetails
            //for loop to iterate for each arraylist m available
            for (Member memb : m) {
                memberDetailsBuilder.append(memb.getfName()).append("\t\t|") //appending member details
                        .append(memb.getlName()).append("\t|")
                        .append(memb.getAddress()).append("\t|")
                        .append(memb.getAge()).append("\t|")
                        .append(memb.getNum()).append("|\n");
            }
            String memberDetails = memberDetailsBuilder.toString(); //Converts memberDetailsBuider data to string
            sendData = memberDetails.getBytes(); // convert memberDetais to bytes
            in.close(); //closing inputstream
            return sendData; //returning
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
