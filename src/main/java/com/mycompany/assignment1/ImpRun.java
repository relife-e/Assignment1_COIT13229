/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

//importing important libraries
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anmol Saru
 */

//
public class ImpRun implements Runnable {    
    
    TCPServer tS = new TCPServer(); // creating TCPServer
    private Socket cSocket; //initalizing Socket variable
    
    

        
        
    //constructor for ImpRun  with Socket type arguments
    public  ImpRun (Socket s){
        cSocket = s;
        
    }   
    /*Overriding run method
    Executes when .start is invoked in TCPServer class
    It takes inoput from client and saves it in a file*/
    @Override
            public void run(){
            try{
            DataInputStream in = new DataInputStream (cSocket.getInputStream());
            DataOutputStream out= new DataOutputStream (cSocket.getOutputStream());
                int interval = 2000;
            Timer tm = new Timer();
            
            while(true){
                // Read the data from the client
            String nameF = in.readUTF();
            String nameL = in.readUTF();
            String age = in.readUTF();
            String address = in.readUTF();
            String phnNum = in.readUTF();

              
            String response = "recived" + Thread.currentThread().getName() + "\n";
            out.writeUTF(response);
            Member memb = new Member(nameF,nameL, age,address,phnNum);

            
            tS.writeInFile(nameF,nameL, age,address,phnNum);
            
             System.out.print("Message Recived: " + response);
             
             
            }  
            }
            catch(EOFException e) {
		
            } catch (IOException ex) {
            System.out.println("EOF:"+ex.getMessage());
        }
            finally {
                try {
                Timer t = new Timer();
                t.schedule(new WriteObjectToFile(), 2000, 1127);
             cSocket.close();
             
                }
            
	  catch(IOException e){
		System.out.println("IO:"+e.getMessage());}

                }
            
           }
}
            