/****************************************************************************
 *CityAnalysis.java
 ****************************************************************************
 *Defining the methods for reading city info and processing it
 *Gavin Cutchin
 *11/19/2020
 *CMSC 255 002
 ****************************************************************************/
package Projects.Project7;


import java.util.*;
import java.io.*;

public class CityAnalysis {
    public static void main(String[] args){
        //creates new File objects to potentially hold values
        File input = null;
        File output = null;
        //ArrayList of output string for the end file
        ArrayList<String> data = new ArrayList<String>();
        //initialize scanner object
        Scanner scan = new Scanner(System.in);

        //try to read the file paths from console
        try{
            input = new File(args[0]);
            output = new File(args[1]);
            data = readFile(input);
        } //if console file path isn't found then prompt for manual input
        catch(FileNotFoundException ex){
            try{
                input = new File(scan.nextLine());
                output = new File(scan.nextLine());
                data = readFile(input);
            } //If file still isn't found program will print to console
            catch(FileNotFoundException e){
                System.out.println("Incorrect input filename");
            }
        }
        //initialize 2 array lists, one of type city to hold each city object and one of type string to hold the information to be printed
        ArrayList<City> cityData = parseData(data);
        ArrayList<String> result = new ArrayList<String>();

        //add each string of information to the result array list
        result.add("The average population is: " + calcPopulationAverage(cityData));
        result.add("The average area is: " + calcAreaAverage(cityData));
        //initialize a string array to hold all names of all cities with population above average
        ArrayList<String> aboveAvg = calcPopulationAboveAverage(cityData, calcPopulationAverage(cityData));

        //adds the aboveAvg arrayList to the result arrayList
        if(aboveAvg.size() > 0){
            String aboveTheAvg = "The cities above the average population are: " + aboveAvg.get(0);
            for(int i = 1; i < aboveAvg.size(); i++){
                aboveTheAvg += ", " + aboveAvg.get(i);
            }
            result.add(aboveTheAvg);
        }

        //add city with largest distance to result
        result.add("The largest distance is: " + findLargestDistance(cityData).getName());
        //initialize a city to equal baton rouge as a test for findCity()
        City baton = new City("Baton Rouge, LA", 88.65, 229493, 81.2);
        //and the result of findCity() to result
        result.add("Is " + baton.getName() + " in the data? " + findCity(cityData, baton));

        //try writing data to a new file
        try {
            writeOutData("City info for " + input.getName(),result, output);
        } //if output is not found it will loop until a correct filename is placed
	    catch(FileNotFoundException ex) {
            output = new File(scan.nextLine());
            while (!output.exists()) {
                System.out.println("Incorrect output filename");
                output = new File(scan.nextLine());

            }
            //try writing the result to the output file
            try{
                writeOutData("Output file correct", result, output);
            } //if output is still wrong then print to console
            catch(FileNotFoundException e){
                System.out.println("Incorrect output file");
            }

        }
        //close scanner
        scan.close();
    }

    //readFile method throws FileNotFoundException, reads each line of the file and adds it to the string array list
    public static ArrayList<String> readFile(File input) throws FileNotFoundException{
        ArrayList<String> result = new ArrayList<String>();
        Scanner fileScan = new Scanner(input);
        while(fileScan.hasNext()){
            result.add(fileScan.nextLine());
        }
        return result;
    }

    //parseData method that makes a City array with corresponding City info
    public static ArrayList<City> parseData(ArrayList<String> lines){
        //initialize array list to be returned
        ArrayList<City> data = new ArrayList<City>();
        //loop through all of the info
        for(int i = 0; i < lines.size(); i++){
            //split each line into a string array to handle information
            String[] cityInfo = lines.get(i).split("\t");
            //create local city temp to hold the info
            City temp = new City();
            //set temps name
            temp.setName(cityInfo[0]);

            //try setting each city number value -- if the value is not a number, NumberFormatException is caught and the piece of city info is defaulted to 0
            try{
                temp.setArea(Double.parseDouble(cityInfo[1]));
            }
            catch(NumberFormatException ex){
                temp.setArea(0);
            }

            try{
                temp.setPopulation(Integer.parseInt(cityInfo[2]));
            }
            catch(NumberFormatException ex){
                temp.setPopulation(0);
            }

            try{
                temp.setDistance(Double.parseDouble(cityInfo[3]));
            }
            catch(NumberFormatException ex){
                temp.setDistance(0);
            }

            //if any of the values for the city is less than 0 then the value is defaulted to 0
            if(temp.getArea() < 0){
                temp.setArea(0);
            }

            if(temp.getPopulation() < 0){
                temp.setPopulation(0);
            }

            if(temp.getDistance() < 0){
                temp.setDistance(0);
            }
            //add the city temp to the array that will be returned
            data.add(temp);
        }
        return data;
    }

    //calcPopulationAverage method to return the population average of all the cities
    public static double calcPopulationAverage(ArrayList<City> cities){
        double avg = 0;
        int count = 0;
        for(int i = 0; i < cities.size();i++){
            avg += cities.get(i).getPopulation();
            count++;
        }

        avg = avg / count;
        return avg;
    }

    //calcAreaAverage method to return average area of all the cities
    public static double calcAreaAverage(ArrayList<City> cities){
        double avg = 0;
        int count = 0;
        for(int i = 0; i < cities.size(); i++){
            avg += cities.get(i).getArea();
            count++;
        }

        avg = avg / count;
        return avg;
    }

    //calcPopulationAboveAverage method to return a String list of all names of cities above city population average
    public static ArrayList<String> calcPopulationAboveAverage(ArrayList<City> cities, double avg){
        ArrayList<String> aboveAvg = new ArrayList<String>();
        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).getPopulation() > avg){
                aboveAvg.add(cities.get(i).getName());
            }
        }
        return aboveAvg;
    }

    //findLargestDistance method compares each cities distance and returns the city with the largest
    public static City findLargestDistance(ArrayList<City> cities){
        int position = 0;
        double distance = 0;

        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).getDistance() > distance){
                distance = cities.get(i).getDistance();
                position = i;
            }
        }
        return cities.get(position);
    }

    //findCity method that return true if the city to test has the same name and population in the all the info
    public static boolean findCity(ArrayList<City> cities, City city){

        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).equals(city)){
                return true;
            }
        }
        return false;
    }

    //writeOutData method throws FileNotFoundException, writes output message the date array to the corresponding output file
    public static void writeOutData(String outputMessage, ArrayList<String> data, File outputFile) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(outputFile);
        writer.println(outputMessage);
        for(int i = 0; i < data.size(); i++){
            writer.println(data.get(i));
        }
        writer.close();
    }

    //writeOutData method throws FileNotFoundException, writes to output file all cities that were in the data
    public static void writeOutData(ArrayList<City> data, File outputFile) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(outputFile);
        while(!data.isEmpty()){
           writer.println(data.remove(0));
        }
        writer.close();
    }
}
