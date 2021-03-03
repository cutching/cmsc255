package Labs.Lab14;
import java.io.PrintWriter;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *   DaysPerMonth
 *   VCU - Computer Science Department
 *   A program that prompts the user for a month and year (both as integers)
 *   then displays the number of days in that month.
 **/

public class DaysPerMonth {

    public static void main(String[] args){

        try {
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            processFile(inputFile, outputFile);
        }
        catch(Exception ex){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a valid File Path: ");
            File inputFile = new File(scan.nextLine());
            File outputFile = new File(scan.nextLine());
            processFile(inputFile,outputFile);
            scan.close();
        }


    }


    public static void processFile(File inputFile, File outputFile){
            Scanner reader = null;
            PrintWriter writer = null;
            try{
                reader = new Scanner(inputFile);
                writer = new PrintWriter(outputFile);

                while(reader.hasNext()){

                    String[] temp = reader.nextLine().split(",");
                    int month;
                    int year;
                    try{
                        month = Integer.parseInt(temp[0]);
                        year = Integer.parseInt(temp[1]);
                        if(month >= 1 && month <= 12){
                            if(year > 0){
                                writer.println("There are " + getDays(month, year) + " days in this month.");
                            }
                            else{
                                writer.println("Year cannot be negative");
                            }
                        }
                        else{
                            writer.println("Month must be between 1 and 12");
                        }
                    }
                    catch(NumberFormatException ex){
                        writer.println("Not an integer");
                    }
                }

                writer.close();
            }
            catch(FileNotFoundException e){
                System.out.println("Bad File Name");
            }



    }

    /**
     * method to determine the days for the given month and year
     **/
    private static int getDays(int mon, int yr) {
        int numDays = 0;

        switch(mon) {
            case 2: // February
                numDays = 28;
                if (yr % 4 == 0) {
                    numDays = 29;
                    if (yr % 100 == 0 && yr % 400 != 0) {
                        numDays = 28;
                    }
                }
                break;

            case 4:   //April
            case 6:   // June
            case 9:   // September
            case 11:  // November
                numDays = 30;
                break;

            default: numDays = 31;  // all the rest
        }
        return numDays;
    }

}
