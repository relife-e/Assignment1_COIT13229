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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anmol Saru
 */
 class WriteObjectToFile extends TimerTask{
    private static final String FileName = "memberlistObject";


    
    @Override
    public  void run() {
        System.out.println("TimerTask started at: " + new Date());
        try {
        BufferedReader reader = new BufferedReader(new FileReader("memberlist.txt"));
        FileOutputStream fos = new FileOutputStream("memberlistObject");

            ObjectOutputStream out = new ObjectOutputStream(fos);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(":");
                if (tokens.length >= 5) { // Ensure enough tokens to create a Member object
                    Member member;
                    
                        member = new Member(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                        out.writeObject(member);
                    } 
            else {
                    System.err.println("Invalid member details: " + line);
                }
  
            } 
            reader.close();
            out.close();
            System.out.println("TimerTask started at: " + new Date());
            System.out.println("Member list serialized to memberlistObject.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        System.out.println("End");
        }
    }
 }

