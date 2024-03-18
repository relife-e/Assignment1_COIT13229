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
public class TCPServer {
    public static void main (String args[]) throws IOException {
    try{
        int serverPort = 781;
        ServerSocket sSocket = new ServerSocket(serverPort);
        
        while(true) {
            Socket cSocket =sSocket.accept();
            
            Data d = new Data(cSocket);
            System.out.println("Connection established client  ");
        }
    }
    catch (IOException e) {
            System.out.println("Listen :"+e.getMessage());}
    
            
            }}

        class Data extends Thread {
            DataInputStream in;
            DataOutputStream out;
            Socket clientS;
            public Data (Socket s) {
            try 
            {
                clientS = s;
                in = new DataInputStream (clientS.getInputStream());
                out = new DataOutputStream (clientS.getOutputStream());
                run();
            }
            catch (IOException e) 
            {
            System.out.println("Connection:" +e.getMessage());}

            }
            public void run(){
            try{
                // Read the data from the client
                String name = in.readUTF();
                String age = in.readUTF();
                String address = in.readUTF();
                String phnNum = in.readUTF();

                // Process the received data (you can add your logic here)
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Address: " + address);
                System.out.println("Phone Number: " + phnNum);
            String data = "recived";
            out.writeUTF(data);
            writeInFile(name,age,address,phnNum);
            
             System.out.print("Message Recived: " + data);
            }
            catch(EOFException e) {
		System.out.println("EOF:"+e.getMessage());}
	  catch(IOException e){
		System.out.println("IO:"+e.getMessage());}
	  
	  //finally {
	    //try {clientS.close();}
	   // catch(IOException e){/*close failed*/}}

           }
            
            //making method for reading input data and storing it in file
            public void writeInFile(String name, String age, String address, String phNum){
                try (FileWriter writer = new FileWriter("member.txt",true)) {
                    writer.write(name + "," + age + "," + address + "," + phNum );
                }
                catch (IOException e){
                System.out.println("IO:"+e.getMessage());}
                System.out.print("Message Recived: " );
                }
            }
            


    
        

