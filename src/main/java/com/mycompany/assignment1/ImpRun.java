/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Anmol Saru
 */
public class ImpRun implements Runnable {    
    
    TCPServer tS = new TCPServer();
    private Socket cSocket;
    
    public  ImpRun (Socket s){
        cSocket = s;
        
    }   
    @Override
            public void run(){
            try{
            DataInputStream in;
            DataOutputStream out;
            
            
                in = new DataInputStream (cSocket.getInputStream());
                out = new DataOutputStream (cSocket.getOutputStream());
                // Read the data from the client
                String nameF = in.readUTF();
                String nameL = in.readUTF();
                String age = in.readUTF();
                String address = in.readUTF();
                String phnNum = in.readUTF();

              
            String data = "recived" + Thread.currentThread().getName() + "\n";
            out.writeUTF(data);
            
            tS.writeInFile(nameF,nameL, age,address,phnNum);
            
             System.out.print("Message Recived: " + data);
             
             in.close();
            out.close();
            cSocket.close();
            }
            catch(EOFException e) {
		System.out.println("EOF:"+e.getMessage());}
	  catch(IOException e){
		System.out.println("IO:"+e.getMessage());}
	  
	  //finally {
	    //try {clientS.close();}
	   // catch(IOException e){/*close failed*/}}

           }
}
            