/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Anmol Saru
 */
public class TCPClient {
    public static void main (String args[]) throws IOException {
         Socket s= null;
        String hostName = "loclhost";
        
        Scanner sc = new Scanner (System.in);
    try{
       int serverPort = 781;
       s = new Socket ("localhost", serverPort);
       DataInputStream in = new DataInputStream (s.getInputStream());
       DataOutputStream out = new DataOutputStream (s.getOutputStream());
        System.out.print("Enter name: ");
       String name = sc.nextLine();
       System.out.print("Enter name: ");
       String age = sc.nextLine();
       System.out.print("Enter name: ");
       String address = sc.nextLine();
       System.out.print("Enter name: ");
       String phnNum = sc.nextLine();
       out.writeUTF(name);
       out.writeUTF(age);
       out.writeUTF(address);
       out.writeUTF(phnNum);
      // String data = in.readUTF();
       //System.out.print("Message Recived: " + data);
    }
    catch (IOException e){
    System.out.print("Message not esd: ");
    }
    

    
    }
}
