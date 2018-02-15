/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.center;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class Tutor  extends Staff implements Serializable {
    String teachCourse ;
    // lw 3ayz aktr mn course bydrso
    //public  ArrayList<String> Teaching =  new ArrayList<String> ;
    private final String TutorFileName = "Tutor.bin";
    public static ArrayList<Tutor> Tutors = new ArrayList<Tutor>() ;
   // FileManagerBinary FManger=new FileManagerBinary();
    
    public Tutor () {
} 

    public Tutor (String username , String password ,int id ,String firstname , String lastname  , int age ,String email , double salary , int hours  ) {
       super ( username , password , id ,firstname , lastname , age , email , salary , hours);
    }
    
    public boolean commitToFile() {
        return FManager.Write(TutorFileName, Tutors);
    }
    
    public void loadFromFile() {
        Tutors = (ArrayList<Tutor>) FManager.Read(TutorFileName);
    }
    
    public boolean Add () {
        loadFromFile ();
        Tutors.add(this);
        return commitToFile ();
    }
    
    private int getindex (int id) {
        for (int i=0 ; i<Tutors.size(); i++ ){
            if (Tutors.get(i).getID ()== id){
                return i ;
            }
        }
        return -1 ;
    }
    
    public ArrayList<Tutor> List() {
        loadFromFile();
        return Tutors;
    }

    public Tutor Search(int id) {
        Tutor temp = new Tutor();
        loadFromFile();
        int index = getindex(id);
        if (index != -1) {
            return Tutors.get(index);
        } else {
            return temp;
        }
    }

    public boolean Update() {
        loadFromFile();
        int index = getindex(this.getID());

        if (index != -1) {
            Tutors.set(index, this);

            return commitToFile();
        }

        return false;
    }

    public boolean Delete(int id) {
        loadFromFile();
        int index = getindex(id);

        if (index != -1) {
            Tutors.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    @Override
    public String toString() {
        return "\nI'm Tutor : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + hours + "\n" + "Dept. : " + "\nUserName: " + userName + "\t Password: " + password + "\n";
    }
    /*
 
    
    
 public boolean assigngrade (int Sid,String Cname,float x){
     Grade xx = new Grade();
   return  xx.Assign(Sid, Cname, x);
 }
 
 // zay al attendence
 public int assignattendence (int Sid , int Cid){
 
 }
*/
    @Override
 public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Tutor x : Tutors) {
            if (userName.equals(x.userName) && Pass.equals(x.password)) {
                return true;
            }
        }
        return false;
    }
} 