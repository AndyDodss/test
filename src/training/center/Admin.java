/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.center;

import java.io.Serializable;

/**
 *
 * @author Andrew
 */
public class Admin extends Staff implements Serializable {
    
     public Admin() {

    }

    public Admin(String user, String pass,int id,  String fname, String lname, int age,String Email, double salary,int hours) {
        super(user, pass, id, fname, lname, age, Email ,salary ,hours);
    }
    
    public String toString() {
        return "I'm Manager : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + " Email : " + Email + "\nUserName: " + userName + "\t Password: " + password + "\n";
    }

   
    public boolean login(String userName, String Pass) {

        if (userName.equals("Admin@yahoo.com") && Pass.equals("12345678")) {
            return true;
        }
        return false;

    }
}
