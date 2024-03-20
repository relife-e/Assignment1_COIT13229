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
        int serverPort = 1127;
        ServerSocket sSocket = new ServerSocket(serverPort);
        
        while(true) {
            Socket cSocket =sSocket.accept();
            
            Thread th = new Thread(new ImpRun(cSocket));
            System.out.println("Connection established client " + Thread.currentThread().getName() + "\n");
            th.start();
        }
    }
    catch (IOException e) {
            System.out.println("Listen :"+e.getMessage());}                
}
         //making method for reading input data and storing it in file
            public void writeInFile(String nameF, String nameL, String age, String address, String phNum){
                try (FileWriter writer = new FileWriter("member.txt",true)) {
                    writer.write(nameF + ":" + nameL + ":" +age + ":" + address + ":" + phNum );
                }
                catch (IOException e){
                System.out.println("IO:"+e.getMessage());}
                System.out.print("Message Recived: " );
                }
            }
            


    
        

