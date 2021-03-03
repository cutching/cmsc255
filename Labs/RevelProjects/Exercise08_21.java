package Labs.RevelProjects;
import java.util.*;

public class Exercise08_21 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int numCity = 0;
        double total = 0;

        System.out.println("Enter the number of cities: ");
        numCity = scan.nextInt();
        double[][] cities = new double[numCity][2];

        System.out.println("Enter the coordinates of the cities: ");
        for(int i = 0; i<cities.length;i++)
        {
            for(int k = 0; k < cities[i].length;k++)
            {
                cities[i][k] = scan.nextDouble();
            }
        }

        System.out.println("The central city is at (" + cities[findCenter(cities)][0] + ", " +cities[findCenter(cities)][1] + ")");

        for(int i = 0; i < cities[findCenter(cities)].length;i++)
        {
            total = totalDistance(cities, findCenter(cities));
        }
        
        System.out.print("The total distance to all other cities is ");
        System.out.printf("%.2f", total);

    }

    public static double distance(double[] c1, double[] c2)
    {
        return Math.hypot(c2[0]-c1[0],c2[1]-c1[1]);
    }

    public static double totalDistance(double[][] cities, int i)
    {
        double sum = 0;
        for(int k = 0; k < cities.length;k++)
        {
            sum+= distance(cities[i], cities[k]);
        }
        return sum;
    }

    public static int findCenter(double[][] cities)
    {
        int position = 0;
        for(int i = 0; i < cities.length;i++)
        {
            if(totalDistance(cities , i) < totalDistance(cities,position))
            {
                position = i;
            }
        }
        return position;
    }

}
