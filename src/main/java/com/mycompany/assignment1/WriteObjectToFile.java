/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.TimerTask;


/**
 *
 * @author Anmol Saru
 */
//WriteObjectToFie class that writes member detiils to object
 class WriteObjectToFile extends TimerTask{
    private static final String FileName = "memberlistObject"; //initazling filename


    //overriding run method
    @Override
    public  void run() {
        System.out.println("TimerTask started at: " + new Date());
        try {
        BufferedReader reader = new BufferedReader(new FileReader("memberlist.txt")); //Reads file from memberlist.txt
        FileOutputStream fos = new FileOutputStream("memberlistObject"); //allows to write in memberlistObject

            ObjectOutputStream out = new ObjectOutputStream(fos);//writes in memberlistObject
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(":");
                if (tokens.length >= 5) { // Ensure enough tokens to create a Member object
                    Member member;
                        //calling nee Member object and passing paramemters to its constructor
                        member = new Member(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                        out.writeObject(member);//writing member object to a file 
                    } 
            else {
                    System.err.println("Invalid member details: " + line);
                }
  
            } 
            reader.close(); //closing buffered reader
            out.close(); //closing output stream
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        System.out.println("Member list serialized to memberlistObject.");
        }
    }
 }

