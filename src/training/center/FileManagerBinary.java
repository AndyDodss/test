/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.center;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andrew
 */
public class FileManagerBinary implements Serializable {
    public boolean Write (String bath,Object data){
        try{
             System.out.println("Write in.../"+bath);
             ObjectOutputStream Writter =new ObjectOutputStream(new FileOutputStream(bath));
             Writter.writeObject(data);
             System.out.println("...Done");
             Writter.close();
        return true;
           }
             catch(IOException ex){
             System.out.println("Cant Write >>" + ex);
             }
        return false;
    }
public Object Read (String bath){
   Object Back=null;
   try{
       System.out.println("Read From.../"+bath);
       ObjectInputStream Reader =new ObjectInputStream(new FileInputStream(bath));
       Back =Reader.readObject();
      }
   catch(IOException ex){
       System.out.println("Cant Read >>" + ex);
   }
   catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManagerBinary.class.getName()).log(Level.SEVERE, null, ex);
   }
   return Back;
 }
}
    

