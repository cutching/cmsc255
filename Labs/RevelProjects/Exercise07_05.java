package Labs.RevelProjects;
import java.util.*;

public class Exercise07_05 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int[] entry = new int[10];
        int[] holder = new int[10];
        int total = 0;

        System.out.println("Enter ten numbers: ");
        for (int i=0;i<entry.length;i++)
        {
            entry[i] = scan.nextInt();
        }

        for(int i = 0; i<entry.length;i++)
        {
            int count = 0;
            for(int k = 0;k<entry.length;k++)
            {
                if(entry[k]== entry[i])
                {
                    count++;
                }

                if(count == 1 && duplicate(holder,entry[i]) != true)
                {
                    holder[i] = entry[i];
                }
            }
        }

        for(int i = 0; i<holder.length; i++)
        {
            if(holder[i] != 0)
            {
                total++;
            }
        }

        System.out.println("The number of distinct number is " + total);
        System.out.println("The distinct numbers are: ");
        for(int i = 0; i<holder.length;i++)
        {
            if(holder[i]!= 0)
            {
                System.out.print(" " + holder[i]);
            }
        }


    }
    public static boolean duplicate(int[] val, int p)
    {
        int amount = 0;
        for(int i = 0; i<val.length;i++)
        {
            if(val[i] == p)
            {
                amount++;
            }


        }
        if(amount > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
