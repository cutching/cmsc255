package Labs.RevelProjects;
import java.util.*;

public class Exercise07_03
{
    public static void main(String[] args)
    {
        String entry;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the integers between 1 and 100: ");
        entry = scan.nextLine();
        String[] numb = entry.split(" ");
        int[] i = new int[numb.length];

        for(int k = 0; k<i.length;k++)
        {
            i[k] = Integer.parseInt(numb[k]);
        }
        Arrays.sort(i);
        for(int k = 1; k<i.length;k++)
        {
            int count = 0;
            for(int j = 0; j<i.length;j++)
            {
                if(i[k] == i[j])
                {
                    count++;
                }
            }

            if(i[k] != i[k-1] && i[k]!=0)
            {
                if (count > 1) {
                    System.out.println(i[k] + " occurs " + count + " times");
                } else {
                    System.out.println(i[k] + " occurs " + count + " time");
                }
            }

        }
    }
}
