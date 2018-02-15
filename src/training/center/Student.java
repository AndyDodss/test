/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.center;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Andrew
 */
public class Student extends User implements Serializable { 
    
    
    public static ArrayList<Student> Students = new ArrayList<Student>();
    private final String studentFileName = "Students.bin";
    private ArrayList<String> Actived = new ArrayList<String>();
    private ArrayList<String> DeActived = new ArrayList<String>();
    FileManagerBinary FManger=new FileManagerBinary();
    
    
    public Student (){
}
    public Student (String username , String password ,int id ,String fname , String lname ,int age , String email ){
             super ( username , password , id ,fname , lname , age , email);
    }
  /*  
    public void setlearnC (ArrayList<String> learnCourses){
       this.learnC = learnCourses ;
    }

    public ArrayList<String> getlearnC (){
        return this.learnC ;
    }
    */
    
    public void Book (String Cname){
       // if not exist
        this.DeActived.add(Cname);
    }
    public void Active (String Cname){
        this.Actived.add(Cname);
        this.DeActived.remove(Cname);
        
    }
    public void Drop (String Cname){
        this.Actived.remove(Cname);
    }
    
    public void loadFromFile() {
        Students = (ArrayList<Student>) FManager.Read(studentFileName);
    }
    public boolean commitToFile() {
        return FManager.Write(studentFileName, Students);
    }
    
    public boolean Add() {
        loadFromFile();
        Students.add(this);
        return commitToFile();
    }
    
    private int getStudentIndex(int id) {
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
     } 
    
    public ArrayList<Student> List() {
        loadFromFile();
        return Students;
    }
            
    public Student Search (int id)
    {
        Student temp = new Student();
        loadFromFile();
        int index = getStudentIndex(id);
        if (index != -1) {
            return Students.get(index);
        } else {
            return temp;
        }
    }    

   
    public  boolean Update() {
        loadFromFile();
        int index = getStudentIndex(this.getID());

        if (index != -1) {
            Students.set(index, this);

            return commitToFile();
        }

        return false;
    }
    
    public boolean Delete(int id) {
        loadFromFile();
        int index = getStudentIndex(id);

        if (index != -1) {
            Students.remove(index);

            return commitToFile();
        }

        return false;
    }
    @Override
      public String toString() {
        return "\nI'm  : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n"
                 + "\nUserName: " + userName + "\t Password: " + password + "\n";
    }
      
      @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Student x : Students) {
            if (userName.equals(x.userName) && Pass.equals(x.password)) {
                return true;
            }
        }
        return false;
    }

      
      
}
