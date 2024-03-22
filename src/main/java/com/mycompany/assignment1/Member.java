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
public class Member  implements Serializable{
    private String fName;
    private String lName;
    private String age;
    private String address;
    private String num;
    
    public Member (String fName, String lName, String age, String address, String num) throws IOException {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.address = address;
        this.num = num;
        
    }
    public Member() throws IOException {    
    }
   

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
