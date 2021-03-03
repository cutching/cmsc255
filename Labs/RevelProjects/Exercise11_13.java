package Labs.RevelProjects;
import Labs.Lab8.Array;

import java.util.*;
public class Exercise11_13 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter ten integers: ");
        ArrayList<Integer> entry = new ArrayList<Integer>();

        String[] test = scan.nextLine().trim().split(" ");
        for(int i = 0; i < test.length; i++)
        {
            entry.add(Integer.parseInt(test[i]));
        }

        removeDuplicate(entry);
        System.out.print("The distinct integers are");
        for(int i = 0; i< entry.size();i++)
        {
            System.out.print(" " + entry.get(i) );
        }
    }

    public static void removeDuplicate(ArrayList<Integer> list)
    {
        int temp;
        for(int i = 0; i < list.size(); i++)
        {
            temp = list.get(i);
            for(int k = i; k< list.size();k++)
            {

                if(temp == list.get(k) && k != i)
                {
                    list.remove(k);
                    k--;
                }
            }


        }
    }
}
