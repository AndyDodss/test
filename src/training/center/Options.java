/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.center;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface Options {
    
    boolean Add () ;
    Object Search (int id);
    ArrayList<Student> List ();
    boolean Update ();
    boolean Delete (int id);
    
}
