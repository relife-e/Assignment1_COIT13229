/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;
import java.net.*;
import java.io.*;

/**
 *
 * @author Anmol Saru
 */
public class TCPClient {
    public static void main (String args[]) throws IOException {
         Socket s= null;
        String hostName = "loclhost";
        String message = "X";
        
    try{
       int serverPort = 781;
       s = new Socket ("localhost", serverPort);
       DataInputStream in = new DataInputStream (s.getInputStream());
       DataOutputStream out = new DataOutputStream (s.getOutputStream());
       out.writeUTF(message);
       String data = in.readUTF();
       System.out.print("Message Recived: ");
    }
    catch (IOException e){
    System.out.print("Message not esd: ");
    }
    finally {
        if (s != null)
        try {
            s.close();
        }
        catch (IOException e){
    System.out.print("Message not ed: ");
    }
    }
    
    }
}
