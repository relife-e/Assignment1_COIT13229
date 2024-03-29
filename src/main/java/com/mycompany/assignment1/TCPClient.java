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

//Class TCPClient that allows client to interact with server. This class is used by client side
public class TCPClient {
    public static void main (String args[]) throws IOException {
        System.out.println("Hello Welcome to Our Program");
        Socket s= null; //initializing socket
        String hostName = "localhost"; //initializg hostname
        try {
        Scanner sc = new Scanner (System.in); // creating scanner object
        
        int serverPort = 1127; //initialzing server port
        //creating new TCP connection
       s = new Socket ("localhost", serverPort); 
       DataInputStream in = new DataInputStream (s.getInputStream()); // reading input stream from socket and storing it in "in" var
       DataOutputStream out = new DataOutputStream (s.getOutputStream()); //reading output stream from socket and stroing it in "out" var
        String stopS = "Yes";
        int count =1;
            while ("Yes".equalsIgnoreCase(stopS)){ //ignores case
                System.out.println("Enter details for your member num: " + count);
                count++;
                //asking user to enter details
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

                System.out.print("Do you want to enter another set of details? (Yes/No): "); //Asking if user wants another loop/ enter another details
                stopS = sc.nextLine();
                System.out.println("**-**-**-**-**-**-**-****-****-**");
        }
             
        
        } catch (IOException e){
        System.out.print("Message has not been send to client ");
    }
   
        }
    
    }
    
    

