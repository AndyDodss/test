
package training.center;


public abstract class Staff extends User {
    
    protected double salary;
    protected int hours;
    
    
    public Staff( String userName, String password,int id, String fname, String lname, int age, String Email  , double salary,int hours) {      
         super(userName, password, id, fname, lname, age, Email);
                   
         this.salary = salary;
         this.hours=hours;
    }
    
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    
    public double getSalary() {
        return this.salary;
    }
    public int getoHours() {
        return this.hours;
    }
    public Staff(){
    }
    
   
    
    

          
   

    

   
}
