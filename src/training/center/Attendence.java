
package training.center;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;



public class Attendence implements Serializable {
    private int Sid,Cid;
    private String Sname;
    private String Cname;
    private int Attend;
    private int Abset;
    final String AttendenceFileName = "Attendence.bin";
    FileManagerBinary FManager = new FileManagerBinary();
    public static ArrayList<Attendence> Attendences;
    
    
    public Attendence () {};
    public Attendence(int Sid,int cid,String Sname,String Cname,int attend,int abset){
        this.Sid=Sid;
        this.Cid= cid;
        this.Sname=Sname;
        this.Cname=Cname;
        this.Attend = attend;
        this.Abset = abset;
}    
    

    public void setSname(String Sname){
        this.Sname = Sname;
    }
    public void setCname(String Cname){
        this.Cname = Cname;
    }
    public void setSid(int Sid){
    this.Sid = Sid;
    }
    public void setCid(int Cid){
        this.Cid = Cid;
    }
    public void setAttend(int Attend){
        this.Attend= Attend;
    }
    public void setAbset(int Abset){
        this.Abset = Abset;
    }
    
    
    public String getSname (){
        return this.Sname;
    }
    public String getCname (){
        return this.Cname;
    }
    public int getSid(){
        return this.Sid ;
    }
    public int getCid(){
        return this.Cid ;
    }
    public int getAttend(){
        return this.Attend;
    }
    public int getbset(){
        return this.Abset;
    }
    
    public boolean commitToFile(){
          return FManager.Write(AttendenceFileName,Attendences);
    }
    
    public void loadFromFile(){
          Attendences=(ArrayList<Attendence>)FManager.Read(AttendenceFileName);
    }
    
    public boolean AddAttnedence(){
          loadFromFile();
          Attendences.add(this);
          return commitToFile();
    }
    
    public int getindexAttendence(int sid, int cid){
       loadFromFile();
       for(int i=0; i<Attendences.size(); i++)
       {
            if (Attendences.get(i).getSid()==sid && Attendences.get(i).getCid()==cid) 
            { return i ;  }
       }
       return -1;
    }
    
    public  boolean Update() {
        loadFromFile();
        int index = getindexAttendence(this.getSid(),this.getCid());
        
        if (index != -1) {
            Attendences.set(index, this);

            return commitToFile();
        }

        return false;
    }     
    
    public boolean Delete(int sid,int cid) {
        loadFromFile();
        int index = getindexAttendence(sid,cid);

        if (index != -1) {
            Attendences.remove(index);
            return commitToFile();
        }
        return false;
    }
   
   public Attendence Search (int sid,int cid)
    {
        Attendence temp = new Attendence();
        loadFromFile();
        int index = getindexAttendence(sid,cid);
        if (index != -1) {
            return Attendences.get(index);
        } else {
            return temp;
        }
    }
   
    public ArrayList<Attendence> List() {
            loadFromFile();
            return Attendences;
    }
    
     public ArrayList<Attendence> ShowStudent (int sid){
        loadFromFile();
        ArrayList<Attendence> returned = new ArrayList<Attendence>();
        for(int i=0; i<Attendences.size();i++){
            if (Attendences.get(i).getSid()== sid)
            {
                returned.add(Attendences.get(i));
            }
        }
        return returned;
        
    }
    
    public ArrayList<Attendence> ShowTutor (int cid){
        loadFromFile();
        ArrayList<Attendence> returned = new ArrayList<Attendence>();
        for(int i=0; i<Attendences.size();i++){
            if (Attendences.get(i).getCid()== cid)
            {
                returned.add(Attendences.get(i));
            }
        }
        return returned;   
    }
     
    public boolean AssignAttendence (int sid,int cid,int Attend, int Abset){
        loadFromFile();
        int index = getindexAttendence(sid,cid);
        if(index != -1)
        {
            Attendences.get(index).setAttend(Attend);
            Attendences.get(index).setAbset(Abset);
        }
        
        
       return commitToFile();
        
    }
}
