package driver;

import util.FileIO;
import model.Automotive;

/**
* Hung Quach
* CIS 35B
* Lab 1:
* Due Date:       4/15/2013
* Date Submitted: 4/15/2013
*
* This class read in an automotive text file name, FordZTW.txt and use the 
* data to build an automotive object from it. The automotive object is then 
* serialize to a file name, FordZTW.ser and then deSerialize back from the file
* to a new automotive object.
*/
public class Main 
{
    public static void main(String[] args) 
    {
        FileIO io = new FileIO("FordZTW.txt"); 
        
        System.out.printf("\nOriginal Object's data before serialization.\n\n");
        Automotive FordZTW = io.readFile(); 
        FordZTW.printModel(); 
        
        System.out.printf("\nNew Object's data after serialization and deSerialization.\n\n");
        io.serializeAutomotive(FordZTW); 
        io.deserializeAutomotive("FordZTW.ser").printModel(); 
    }
}
