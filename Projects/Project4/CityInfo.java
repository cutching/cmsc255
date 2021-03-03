/************************************
 *CityInfo.java
 *************************************
 *Finds city info with array manipulation
 *Gavin Cutchin
 *10/9/2020
 *CMSC 255 002
 ************************************/

package Projects.Project4;
import java.util.*;

public class CityInfo
{
    public static void main(String[] args)
    {   //only method allowed in main, executes entire program
        processInput();
    }

    //returns an array of corresponding population densities
    public static double [] calcPopDensity()
    {
        //initialization of each array and their corresponding values
        double[] cityArea = {188.87,318.98,62.57,99.77,88.65,37.17,195.36,79.56};
        int[] population = {545852,459787,204214,466488,229493,210565,416427,296945};
        double[] populationDensity = new double[8];

        //writes the population density to each position in the populationDensity array
        for(int i = 0; i < populationDensity.length; i++)
        {
            populationDensity[i] = population[i] / cityArea[i];
        }

        //returns the entire populationDensity array so it can be referenced
        return populationDensity;
    }

    //given an array it returns the average density
    public static double calcPopAvgDensity(double[] populationDensity)
    {
        //initialize an average variable
        double averageDensity = 0.0;

        //sums all the elements in populationDensity
        for(int i = 0; i <populationDensity.length;i++)
        {
            averageDensity += populationDensity[i];
        }

        //calculates the average using the sum that was generated in the for loop
        averageDensity = averageDensity / populationDensity.length;

        //returns the average of populationDensity
        return averageDensity;
    }

    //given and array it sorts through and pulls lowest value
    public static double getLowestPopDensity(double[] populationDensity)
    {
        //sets baseline value for comparison
        double lowestDensity = populationDensity[0];

        //iterates through each other element to find lowest value
        for(int i = 1; i < populationDensity.length; i++)
        {
            //if lowestDensity is bigger than the value at populationDensity[i], that value is the new value of lowestDensity
            if(lowestDensity > populationDensity[i])
            {
                lowestDensity = populationDensity[i];
            }
        }
        //returns the lowest value from the array populationDensity
        return lowestDensity;
    }

    //finds the position of the city in the array
    public static int getCityPosition(String city)
    {
        //initialize the array of given city names
        String[] cityName = {"Albuquerque, NM","Kansas City, MO","Richmond, VA","Sacramento, CA","Baton Rouge, LA","Rochester, NY","Colorado Springs, CO","Cincinnati, OH"};
        //returns a value of -1 if the city does not exist in the array
        int position = -1;

        //iterates through the array to find the city and set the position to the position in the array where that city is
        for(int i = 0; i < cityName.length; i++)
        {
            if(city.equals(cityName[i]))
            {
                position = i;
            }
        }

        //returns where the city is in the cityName array
        return position;
    }

    //converts each distance from miles to kilometers
    public static double getDistance(int position)
    {
        //conversion variable
        final double MILES_TO_KM = 1.60934;
        double[] distance = {64,63.3,109,87.9,81.2,73.9,70.5,107};
        //returns the corresponding city distance to kilometers
        return distance[position] * MILES_TO_KM;
    }

    public static void processInput()
    {
        //initializes scanner object and city and string to nothing
        Scanner scan = new Scanner(System.in);
        String city = "";
        String answer = "";

        //keeps the program running while the users doesn't input quit
        while(!answer.equalsIgnoreCase("quit"))
        {
            //creates a temp array so we can manipulate the result of calcPopDensity
            double[] temp =  calcPopDensity();
            System.out.println("Enter the city:");
            //sets city to the next entry trimmed
            city = scan.nextLine().trim();

            //loop continues while the city isn't valid resulting in a -1 for position if that's the case
            while(getCityPosition(city) == -1)
            {
                System.out.println("Please enter a valid city name");
                //sets city to next entry trimmed
                city = scan.nextLine().trim();
            }

            //printf("%#,.2f", ) rounds the entry to two decimals and includes commas at every third number
            //this block prints: (city) dist of: (distance of city in km)km and pop density of: (corresponding population density)
            System.out.print(city + " dist of: ");
            System.out.printf("%#,.2f", getDistance(getCityPosition(city)));
            System.out.print("km and pop density of: ");
            System.out.printf("%#,.2f", temp[getCityPosition(city)]);
            System.out.println();

            //this block prints: Average pop density of: (average density of the temp array)
            System.out.print("Average pop density of: ");
            System.out.printf("%#,.2f",calcPopAvgDensity(temp));
            System.out.println();

            //this block prints: Lowest pop density of: (lowest value of array temp)
            System.out.print("Lowest pop density of: ");
            System.out.printf("%#,.2f",getLowestPopDensity(temp));
            System.out.println();

            //continuation statement
            System.out.println("Would you like to enter another city? Enter quit to exit.");
            //sets answer to the next string entry trimmed
            answer = scan.nextLine().trim();
        }
    }
}
