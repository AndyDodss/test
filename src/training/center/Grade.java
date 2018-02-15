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
public class Grade implements Serializable {
    
    private int Sid , Cid;
    private String Sname,Cname;
    private float minGrade,maxGrade,SGrade;
    final private String GradeFileName ="Grades.bin";
    public static ArrayList<Grade> Grades=new ArrayList<Grade>();
    FileManagerBinary FManger=new FileManagerBinary();
    
    public Grade () {};
    public Grade(int Sid,int cid,String Sname,String Cname,float minGrade,float maxGrade,float SGrade){
    
    this.Sid=Sid;
    this.Cid= Cid;
    this.Sname=Sname;
    this.Cname=Cname;
    this.minGrade=minGrade;
    this.maxGrade=maxGrade;
    this.SGrade=SGrade;
}

    public void setSid(int Sid){
      this.Sid=Sid;  
    }
    public void setCid(int cid){
      this.Cid=cid;  
    }
    public void setSname(String Sname){
      this.Sname=Sname;
    }
    public void setCname(String Cname){
      this.Cname=Cname;
    }
    public void setMinGrade(float minGrade){
      this.minGrade=minGrade;  
    }
    public void setMaxGrade(float maxGrade){
      this.maxGrade=maxGrade;  
    }
    public void setSGrade(float SGrade){
      this.SGrade=SGrade;  
    }


    public int getSid(){
      return this.Sid;  
    }
    public int getCid(){
      return this.Cid;  
    }
    public String getSname(){
      return this.Sname;
    }
    public String getCname(){
      return this.Cname;
    }
    public float getMinGrade(){
      return this.minGrade;  
    }
    public float getMaxGrade(){
      return this.maxGrade;  
    }
    public float getSGrade(){
      return this.SGrade;  
    }

    
    public boolean commitToFile(){
          return FManger.Write(GradeFileName,Grades);
      }
    public void loadFromFile(){
          Grades=(ArrayList<Grade>)FManger.Read(GradeFileName);
      }
    public boolean AddGrade(){
          loadFromFile();
          Grades.add(this);
          return commitToFile();
          
      }
    
    public ArrayList<Grade> List() {
            loadFromFile();
            return Grades;
    }
    
   ////// al Gded bfhm aktr ll GUL  return ArrayList of only course for this student///////////////////  
    public int getindexGrade(int sid, int cid){
       loadFromFile();
       for(int i=0; i<Grades.size(); i++)
       {
            if (Grades.get(i).getSid()==sid && Grades.get(i).getCid()==cid) 
            { return i ;  }
       }
       return -1;
    }
    
    public  boolean Update() {
        loadFromFile();
        int index = getindexGrade(this.getSid(),this.getCid());
        
        if (index != -1) {
            Grades.set(index, this);

            return commitToFile();
        }

        return false;
    }     
    
    public boolean Delete(int sid,int cid) {
        loadFromFile();
        int index = getindexGrade(sid,cid);

        if (index != -1) {
            Grades.remove(index);
            return commitToFile();
        }
        return false;
    }
   
   public Grade Search (int sid,int cid)
    {
        Grade temp = new Grade();
        loadFromFile();
        int index = getindexGrade(sid,cid);
        if (index != -1) {
            return Grades.get(index);
        } else {
            return temp;
        }
    }
    
    public ArrayList<Grade> SreahcStudent (int sid){
        loadFromFile();
        ArrayList<Grade> returned = new ArrayList<Grade>();
        for(int i=0; i<Grades.size();i++){
            if (Grades.get(i).getSid()== sid)
            {
                returned.add(Grades.get(i));
            }
        }
        return returned;
        
    }
    // momkn a5le al tutor mydene4 al id course w a3mlo b asm al course al feh
    
    public ArrayList<Grade> SreahcTutor (int cid){
        loadFromFile();
        ArrayList<Grade> returned = new ArrayList<Grade>();
        for(int i=0; i<Grades.size();i++){
            if (Grades.get(i).getCid()== cid)
            {
                returned.add(Grades.get(i));
            }
        }
        return returned;
        
    }
    
    public boolean Assign (int sid,int cid,float sgrade){
        loadFromFile();
       // ArrayList<Grade> returned = new ArrayList<Grade>();
        for(int i=0; i<Grades.size();i++){
            if (Grades.get(i).getSid()== sid && Grades.get(i).getCid()== cid)
            {
                Grades.get(i).setSGrade(sgrade);
            }
        }
       return commitToFile();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    
    
    
    
    ///// momkn array list ////////////////
    
    // hesgha zay ma hya lw 3arft arraylist ma4e//////////
    private int[] getGradeStudentIndex(int Sid) {
       int[]x=new int[10];
        for(int j=0;j<10;j++){
            x[j]=-1;
        }
        
        int v=0;
        for (int i = 0; i < Grades.size(); i++) {
            if (Grades.get(i).getSid()==Sid ) {
                x[v++]=i;
            }
        }
             return x;
    }
    ////// lw as2l pola /////////
    private int[]getGradeCourseIndex(String Cname) {
        int[]x=new int[1000];
        for(int j=0;j<1000;j++){
            x[j]=-1;
        }
        int v=0;
       for (int i = 0; i < Grades.size(); i++) {
         if (Grades.get(i).getCname().equals(Cname)) {
             x[v++]=i;
         }
            }
             return x;
    }
    
    public ArrayList<Grade> List() {
            loadFromFile();
            /* 
            String S = "\nAll Courses Data:\n";
            for (Grade x : Grades) {
                S = S + x.toString();
            }
            return S;
            *   
            return Grades;
}
    ///// trg3  'course name + grade ' ->> string
    ////f al gui yb2a fe gdwl fe asm al course w al max w al min w dargto  w mtsafr fady w lma ya3ml show al gadwl ytmle////
    ///// m4 3ayzo yarg3 string moomk grade
    /// bos de ba3t al student lma ya3ml showw
     public String searchGradesStudent(int Sid) {
            loadFromFile();
            int []index = getGradeStudentIndex(Sid);
            String GforS="";
            int i=0;
            if(index[0]==-1){return "no Grade yet";}
            else{
            while(index[i]!=-1){
             GforS=GforS+Grades.get(index[i]).getCname()+"@"+Grades.get(index[i]).getSGrade();
             i++;
            }
            return GforS;
            }
    }
     // lma al tutor ya3ml showw grades kol students
    public String searchGradesCourse(String Cname) {
            loadFromFile();
            int []index = getGradeCourseIndex(Cname);
            String GforT="";
            int i=0;
            if(index[0]==-1){return "\n Not Found";}
            else{
            while(index[i]!=-1){
             GforT=GforT+Grades.get(index[i]).getSname()+"@"+Grades.get(index[i]).getSGrade();
             i++;
            }
            return GforT;
            }
    }
    
    ///pola yafhmny
    ////check tany 3la al index
    
     public boolean Assign(int Sid,String Cname,float x){
            loadFromFile();
        int []index = getGradeStudentIndex(Sid);
        int []index1 = getGradeCourseIndex(Cname);
        int i=0;
        int j=0;
        while(index[i]!=-1){
            while(index1[j]!=-1){
             if(index[i]==index1[j]){
                Grades.get(index[i]).setSGrade(x);
                return commitToFile();
            }
            j++; 
            }
            j=0;
            i++;
        }
        return false;
    }
     
     
    public boolean deleteGradeCourse(String Cname) {
        loadFromFile();
        int []index = getGradeCourseIndex(Cname);
        int i=0;
        if(index[0]==-1){return false;}
        while(index[i]!=-1){
         Grades.remove(index[i]);
         i++;
        }
        return commitToFile();
    }
    
    
    public boolean deleteGradeStudent(int Sid,String Cname) {
        loadFromFile();
        int []index = getGradeStudentIndex(Sid);
        int []index1 = getGradeCourseIndex(Cname);
        int i=0;
        int j=0;
        while(index[i]!=-1){
            while(index1[j]!=-1){
         if (index[i]==index1[j] ) {
            Grades.remove(index[i]);
             return commitToFile();
         }
         j++;
         }
         j=0;
         i++;
        }
        return false;
    }
    
@Override
public String toString(){
    return "\nStudent : " + Sid + "\t" + "Student Name : " + Sname + "\n"+"Course Name :" + Cname + "\n" + "Grade : " + SGrade + "\n"+ "Max Grade : " + maxGrade + "\n"+ "MinemumGrade : " + minGrade + "\n";
}
*/
}
