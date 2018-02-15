 
package training.center;
import java.util.*;
import java.io.Serializable;

public  abstract class User implements Serializable {

    protected int id;
    protected String userName;
    protected String password;
    protected String fname;
    protected String lname;
    protected int age;
    protected String Email;
    FileManagerBinary FManager = new FileManagerBinary();
    
    public User() {
    }

    public User(String userName, String password, int id, String fname, String lname, int age,String Email) {
             
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.Email = Email;
    }
    public void setID(int id) {
        this.id = id;
    }
      public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPass(String pass) {
        this.password = pass;
    }
    public void setFName(String fname) {
        this.fname = fname;
    }
    public void setLName(String lname) {
        this.lname = lname;
    }
    public void setAge(int age) {
        this.age = age;
    }    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    

    public int getID() {
        return this.id;
    }
    public String getuserName() {
        return this.userName;
    }
    public String getPass() {
        return this.password;
    }   
    public String getFNname() {
        return this.fname;
    }
    public String getLName() {
        return this.lname;
    }
    public int getAge() {
        return this.age;
    }
    public String getEmail() {
        return this.Email;
    }
    
     
     @Override
    public abstract String toString();
    
    public abstract boolean login(String username, String Pass);
    
   // public void untitledMethod(){}
    
    
       
                    
}