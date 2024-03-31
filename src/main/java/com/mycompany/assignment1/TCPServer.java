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
//TCPServer class that interacts with TCPClient class
public class TCPServer {

    public static void main(String args[]) {
        try {
            int serverPort = 1127;//initalizing serverport
            ServerSocket sSocket = new ServerSocket(serverPort);
            System.out.println("Server running. \nWaiting for client");

            while (true) {
                Socket cSocket = sSocket.accept();//accepting connection from client when port matches

                Thread th = new Thread(new ImpRun(cSocket));//creating new thread object that runs ImpRun class that implements runnable
      
               
                th.start();//starts new thread

            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage()); //catches error, in this context used to catch error while accepting socket from client
        }
    }
    //making method for reading input data and storing it in file
    public void writeInFile(String nameF, String nameL, String age, String address, String phNum) {

        try (FileWriter writer = new FileWriter("memberlist.txt", true)) { // creating FileWriter Object to write into file
            writer.write(nameF + ":" + nameL + ":" + age + ":" + address + ":" + phNum + "\n");
            System.out.println(nameF + " " + nameL + ", " + age + ", " + address + ", " + phNum);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

}
