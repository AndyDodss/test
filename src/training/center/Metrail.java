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
public class Metrail implements Serializable {

    private int num;
    private String Cname;
    public static ArrayList<Metrail>Metrails = new ArrayList<Metrail>();
    FileManagerBinary FManger = new FileManagerBinary();
    private final String MetrailsFileName = "Metrail.txt";

    public Metrail() {

    }

    public Metrail(int num,String Cname) {
        this.num = num;
        this.Cname = Cname;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }
    
    public int getnum() {
        return this.num;
    }
    
    public String getCname(){
        return this.Cname;
    }
    
    public void loadFromFile() {
        Metrails = (ArrayList<Metrail>) FManger.Read(MetrailsFileName);
    }
    
    public boolean commitToFile(){
        return FManger.Write(MetrailsFileName,Metrails);
    }}
    
    /*@Override
    public String toString() {
        return ;
    }

}*/
