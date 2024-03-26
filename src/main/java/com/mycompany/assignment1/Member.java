/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Anmol Saru
 */
//Member class that defines the data type of member
public class Member  implements Serializable{
    //initializing
    private String fName;
    private String lName;
    private String age;
    private String address;
    private String num;
    //constructor 
    public Member (String fName, String lName, String age, String address, String num) throws IOException {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.address = address;
        this.num = num;
        
    }
    //constructor with no parameter
    public Member() throws IOException {    
    }
    
    //get methods
    
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAge() {
        return age;
    }


    public String getAddress() {
        return address;
    }

    public String getNum() {
        return num;
    }

    
    
    
}
