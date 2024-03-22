/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Anmol Saru
 */
public class MemberList {
   ArrayList<Member> memb = new ArrayList<>();
   
   public MemberList(){}
   
     public void readMemberDataFromFile() throws IOException {
        Scanner input = new Scanner(System.in);
        //ArrayList<Land> landList = new ArrayList<>();
        File file = new File("member.txt");
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    String[] fields = line.split(":");
                    String fName = fields[0];
                    String lName = fields[1];
                    String age = fields[2];
                    String address = fields[3];
                    String number = fields[4];
                    Member member = new Member( fName,  lName,  age,  address,  number);
                   
                    line = reader.readLine();
                }

                reader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading SellerInfo.txt: " + e.getMessage());
        }
        
} 
     
}
