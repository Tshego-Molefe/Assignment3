/**
 * RunSupplier.java
 * In this class I will be doing Step3: a and b
 * @author Tshegofatso Molefe{219001235}
 * 08 June 2021
 */
package za.ac.cput.assignment_3;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;



public class RunSupplier extends Supplier{
    
    public RunSupplier(){
    super();
    }
        
    ArrayList<Supplier> supplierArray= new ArrayList<>();
    ObjectInputStream input;
    InputStream instream;
    Supplier Supplier;
    FileReader fr;
    BufferedWriter bfw;
    
    //a)
  
           
    
    //b)
    public void openFile() {
        try
        {
              input = new ObjectInputStream(new FileInputStream ("stakeholder.ser"));
              System.out.println("ser file now open");    
        }
        catch (IOException e)
        {
            System.out.println("error opening ser file:" + e.getMessage());
            System.exit(1);
        }
    }
    
    public void closeFile(){
        try
        {
            input.close( ); 
        }
        catch (IOException ioe)
        {            
            System.out.println("error closing ser file: " + ioe.getMessage());
            System.exit(1);
        }        
    }
     public void readFile () throws ClassNotFoundException
    {
       try
       {
            for (int i = 0; i<5; i++)
            {
                Object object = input.readObject();
           
                if (object.getClass() == Supplier.class)
                {
                    supplierArray.add((Supplier)Supplier);
                    System.out.println("Supplier");
                }
              /*  else if (object.getClass() == Customer.class)
                {
                    System.out.println("Customer");
                }*/
            }
       }

     catch (IOException io)
            {
               System.out.println("error opening stakeholder.ser file:" + io.getMessage());
               System.exit(1);
            }
    }
     
     public void writeToFile()
    {
        try
        {
            FileWriter fr = new FileWriter ("supplierOutFile.txt");
            BufferedWriter bfw = new BufferedWriter(fr);
            bfw.write(String.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Product Type", "Product Description"));
            bfw.write(String.format("%-20s%-20s%-20s%-20s\n", super.toString(), getName(), getProductType(), getProductDescription()));
            bfw.close();
            System.out.println("Supplier txtFile successfully created");
        }
        
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
     public static void main(String[] args) throws ClassNotFoundException 
    {
       RunSupplier obj = new RunSupplier();
       obj.openFile();
       obj.writeToFile();
       obj.closeFile();
    }
    
}	

