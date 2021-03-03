package Labs.RevelProjects;
import java.util.*;
public class Exercise08_01 {
    public static void main(String[] args)
    {
        double[][] input = new double[3][4];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a 3-by-4 matrix row by row:");
        for(int i = 0; i<input.length; i++)
        {
            for(int k = 0; k<input[i].length; k++)
            {
                input[i][k] = scan.nextDouble();
            }
        }
        double sum = 0;
        for(int i = 0; i<input[0].length;i++)
        {
            sum = sumColumn(input,i);
            System.out.println("Sum of the elements at column " + i + " is " + sum);
        }
    }

    public static double sumColumn(double[][] m, int columnIndex)
    {
        double sum  = 0;
        for(int i = 0; i<m.length; i++)
        {
            sum += m[i][columnIndex];
        }
        return sum;
    }
}
