
/**
 * Write a description of class EmployeeSalary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Import respective packages
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

//Driver class
public class EmployeeSalary {
    //Driver method
    public static void main(String[] args) {
        
        //Instantiate the object of DecimalFormat
        DecimalFormat dF = new DecimalFormat("0.00");

        try 
        //Input File
        (BufferedReader inputFile = new BufferedReader(new FileReader("employeeSalary.txt"));
        //Output File
        PrintWriter incrementSal = new PrintWriter(new FileWriter("incrementSalary.txt"))) 
             {

            incrementSal.println("List of employees who will get a 5% increment salary for each year of service");
            incrementSal.println("\nEmployee Name \t\tAnnual Salary (RM) \t\tSalary after Increment(RM)");
            incrementSal.println("-------------------------------------------------------------------------------");

            String inputData;
            while ((inputData = inputFile.readLine()) != null) {
                StringTokenizer sT = new StringTokenizer(inputData, ";");

                String staffName = sT.nextToken();
                double staffSal = Double.parseDouble(sT.nextToken());
                double yearService = Double.parseDouble(sT.nextToken());

                if (staffSal < 0)
                    throw new IllegalArgumentException("Invalid input for " + staffName + ": The salary must be a positive number");

                double annualSal = staffSal + (staffSal * 5 / 100 * yearService);

                incrementSal.println(staffName + "\t\t" + dF.format(annualSal) + "\t\t" + dF.format(annualSal));
            }
        } 
        catch (IOException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}


