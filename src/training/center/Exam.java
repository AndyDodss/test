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
public class Exam implements Serializable {
    private String CName;
    private String SName;
    private int SID;
    private int MAXGrade;
    private int MINGrade;
    private float SGrade;
    FileManagerBinary FManager = new FileManagerBinary();
    private final String ExamFile="Exams.bin";
    
    public Exam(){}
    
    public Exam (String CName,String SName,int SID,int MAXGrade,int MINGrade,float SGrade){
      this.CName=CName;
      this.SName=SName;
      this.SID=SID;
      this.MAXGrade=MAXGrade;
      this.MINGrade=MINGrade;
      this.SGrade=SGrade;
}
    public void setCName (String CName){
     this.CName=CName;
    }
    public void setSName (String SName){
     this.SName=SName;
    }
    public void setSID (int SID ){
     this.SID=SID;
    }
    public void setMAXGrade (int MAXGrade){
     this.MAXGrade=MAXGrade;
    }
    public void setMINGrade (int MINGrade){
     this.MINGrade=MINGrade;
    }
    public void setSGrade (float SGrade){
     this.SGrade=SGrade;  
} 
    
    public String setCName (){
     return this.CName=CName;
    }
    public String setSName (){
     return this.SName=SName;
    }
    public int setSID (){
     return this.SID=SID;
    }
    public int setMAXGrade (){
     return this.MAXGrade=MAXGrade;
    }
    public int setMINGrade (){
     return this.MINGrade=MINGrade;
    }
    public float setSGrade (){
     return this.SGrade=SGrade;  
} 
    // 3ayzen nzwad feh
public boolean addExam() {
        if (FManager.Write(getExamData(), ExamFile)) {
            return true;
        } else {
            return false;
        }
    }
 private String getExamData() {
        return this.CName+"-"+this.SName+"-"+this.SID+"-"+this.SGrade;
    }

    @Override
    public String toString() {
        return "Exam Name : " + CName + "\t" + "Student ID : " + SID + "\n" + "Exam Grade : " + SGrade + "\n";
    }

}