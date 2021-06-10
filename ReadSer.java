/**
 *ReadSer.java
 * In this class I will be doing STEP 2: Nr a
 * @author Tshegofatso Molefe {219001235}
 */
package za.ac.cput.assignment_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.util.ArrayList;


public class ReadSer extends Stakeholder{
    
    //a)
    
               
    Supplier[] supplierArray = new Supplier[5];
    Customer[] customerArray = new Customer[6] ;
    ObjectInputStream inputObject;
    Customer customer;
    Supplier supplier;
    Stakeholder stakeholder;
    
      
    public void openFile(){
    try
    {
        inputObject = new ObjectInputStream( new FileInputStream( "stakeholder.ser" ) ); 
            System.out.println(" ser file created and opened for writing ");               
    }
    
    catch (IOException ioe){
            System.out.println("error opening ser file: " + ioe.getMessage());
            System.exit(1);
        }
    }
    
    public void closeFile(){
    try
    {
    inputObject.close();
    }
    catch(IOException ioe) {
        System.out.println("error opening ser file: " + ioe.getMessage());
        }       
    }
   
    
    public void readFromFile() throws ClassNotFoundException{
        
        
        
    //Customer  
      try    
    {
        for (int i = 0; i<customerArray.length; i++){  
          customerArray[i] = (Customer) inputObject.readObject();
          System.out.println(customerArray[i]);
            }
    }
    catch (ClassCastException ioe){
        System.out.println("error opening ser file: " + ioe.getMessage());
    }
    
    catch (ClassNotFoundException | IOException ioe){
        System.out.println("error opening ser file: " + ioe.getMessage());
    }
    //Supplier
    try
    {
        for (int k = 0; k<supplierArray.length; k++){
          supplierArray[k] = (Supplier) inputObject.readObject();
          System.out.println(supplierArray[k]);
            }
    }
    catch (ClassCastException | ClassNotFoundException | IOException ioe){
        System.out.println("error opening ser file: " + ioe.getMessage());
    }
    
    finally{
    closeFile();
        System.out.println("File is now closed!");
    }
    }
    

public static void main(String args[]) throws ClassNotFoundException  {
        ReadSer obj = new ReadSer();
        obj.openFile();
        obj.readFromFile();
    }//end main  
}


