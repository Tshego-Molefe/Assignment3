
/**
 * RunCustomer.java
 * In this class I will be doing Step2: b - f
 * @author Tshegofatso Molefe {219001235}
 * Date: 08 June 2021
 */
package za.ac.cput.assignment_3;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class RunCustomer extends Customer{
    Customer Customer;
    ObjectInputStream input;
    InputStream instream;
    FileReader fw;
    BufferedWriter bw;
    
    
    
    public RunCustomer(){
    super();
    }
        
    ArrayList<Customer> customerArray= new ArrayList<>();
   
    
    //b
    String[] sortStakeholderID = new String[customerArray.size()];
     for (int k = 0; k <customerArray.size(); k++) {
        for(int j = 0; j<customerArray.size(); j++){
        sortStakeholderID[i]= customerArray.get[i].getStHolderId();
        }
        Arrays.sort(sortStakeholderID);
    for (int i = 0; i <customerArray.size(); i++) {
    for(int j=0; j < customerArray.size(); j++){
        if(sortStakeholderID[i].equals(customerArray.get(j).getStHolderId())){
        Customer.add(customerArray.get(j));
        }
    }
    }   
}
    
    
    
    //c
   public int getCustomerAge(String dob){
       String[] birthArray = dob.split(" ");
       LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(birthArray[0]),Integer.parseInt(birthArray[1]),Integer.parseInt(birthArray[2]));
       LocalDate today = LocalDate.now();
       Period difference = Period.between(dateOfBirth, today);
       int age = difference.getYears();
       return age;
    }
    
    
    //d
    public String dobFormatter(String dateOfBirth){
    DateTimeFormatter correctFormat = DateTimeFormatter.ofPattern("dd MM yyyy");
    LocalDate dateOfBirthVar = LocalDate.parse(dateOfBirth);
    String correctDateOfBirth = dateOfBirthVar.format(correctFormat);
    return correctDateOfBirth;
    
    }
    //e)
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
            for (int i = 0; i<6; i++)
            {
                Object object = input.readObject();
           
                if (object.getClass() == Customer.class)
                {
                    System.out.println("Customer");
                }
             
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
            FileWriter fw = new FileWriter ("customerOutFile.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(String.format("%-10s\\t%-10s\\t%-10s\\t%-15s\\t%-10s\\tR%-10.2f\\t%-10s", "First Name", "Last Name", "Address", "Date of Birth", "Credit", "Rent?"));
            bw.write(String.format("%-10s\t%-10s\t%-10s\t%-15s\t%-10s\tR%-10.2f\t%-10s", super.toString(), getFirstName(), getSurName(), getAddress(), getDateOfBirth(), getCredit(), getCanRent()));
            bw.close();
            System.out.println("Customer txtFile successfully created");
        }
        
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
     public static void main(String[] args) throws ClassNotFoundException 
    {
       RunCustomer obj = new RunCustomer();
       obj.openFile();
       obj.writeToFile();
       obj.closeFile();
    }
    
	
    
    //f

    
    }

