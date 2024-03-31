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

/**
 *
 * @author Anmol Saru
 */
//Class ImpRun that implents Runnable which allows multiple threads of connection at same time
public class ImpRun implements Runnable {

    TCPServer tS = new TCPServer(); // creating TCPServer
    private Socket cSocket; //initalizing Socket variable

    //constructor for ImpRun  with Socket type arguments
    public ImpRun(Socket s) {
        cSocket = s;

    }

    /*Overriding run method
    Executes when .start is invoked in TCPServer class
    It takes inoput from client and saves it in a file*/
    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(cSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(cSocket.getOutputStream()); // creating
            
            while (true) {
                // Read the data from the client
                String nameF = in.readUTF();
                String nameL = in.readUTF();
                String age = in.readUTF();
                String address = in.readUTF();
                String phnNum = in.readUTF();

                Member memb = new Member(nameF, nameL, age, address, phnNum); //Member object and calling Member constructor

                tS.writeInFile(nameF, nameL, age, address, phnNum);//calling writeInFile method of TCPServer class to write the file details

                System.out.print("Message Recived: ");

            }//Catching EOFExcpetion
        } catch (EOFException e) {
            System.out.println("Error while reading file at the end.  " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Error. Please check while readig file of creating new member object"); // catches error while reading files or creating member object
        } finally {
            try {
                Timer t = new Timer(); // creating Timer object
                t.schedule(new WriteObjectToFile(), 0, 2000); //using schedule method that call WeiteObjectToFile class every 2 secs
                cSocket.close(); //closing socket
                //catching IOException
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            }

        }

    }
}
