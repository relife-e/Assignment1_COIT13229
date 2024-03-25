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
        String hostName = "localhost";
        try {
        Scanner sc = new Scanner (System.in);
        
        int serverPort = 1127;
       s = new Socket ("localhost", serverPort);
       DataInputStream in = new DataInputStream (s.getInputStream());
       DataOutputStream out = new DataOutputStream (s.getOutputStream());
        String stopS = "Yes";
            while ("Yes".equalsIgnoreCase(stopS)){
                System.out.print("Enter First name: ");
                String nameF = sc.nextLine();
                System.out.print("Enter Last name: ");
                String nameL = sc.nextLine();
                System.out.print("Enter age: ");
                String age = sc.nextLine();
                System.out.print("Enter address: ");
                String address = sc.nextLine();
                System.out.print("Enter phone number: ");
                String phnNum = sc.nextLine();

                // Send the details to the server
                out.writeUTF(nameF);
                out.writeUTF(nameL);
                out.writeUTF(age);
                out.writeUTF(address);
                out.writeUTF(phnNum);

                System.out.print("Do you want to enter another set of details? (Yes/No): ");
                stopS = sc.nextLine();
        }
             
        
        } catch (IOException e){
        System.out.print("Message not esd: ");
    }
   
        }
    
    }
    
    

