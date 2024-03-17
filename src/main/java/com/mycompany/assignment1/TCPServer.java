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
        int serverPort = 7812;
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
            String data = in.readUTF();
            out.writeUTF(data);
            
            }
            catch(EOFException e) {
		System.out.println("EOF:"+e.getMessage());}
	  catch(IOException e){
		System.out.println("IO:"+e.getMessage());}
	  
	  finally {
	    try {clientS.close();}
	    catch(IOException e){/*close failed*/}}

            }
            }


    
        

