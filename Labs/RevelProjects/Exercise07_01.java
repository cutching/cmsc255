package Labs.RevelProjects;
import java.util.*;

public class Exercise07_01 {
    public static void main(String[] args)
    {
        int size = 0;
        int bestGrade = 0;


        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        size = scan.nextInt();
        int[] grades = new int[size];
        System.out.println("Enter " + size + " scores: ");
        for(int i = 0 ; i < grades.length;i++)
        {
            grades[i] = scan.nextInt();
        }

        bestGrade = bestStudent(grades);
        for(int i = 0; i< grades.length;i++)
        {
            System.out.println("Student " + i + " score is " + grades[i] + " and grade is " + grade(grades[i], bestGrade));
        }

    }
    public static int bestStudent(int[] a)
    {
        int best = a[0];
        for(int i = 1; i<a.length;i++)
        {
            if(a[i]> best)
            {
                best = a[i];
            }
        }
        return best;
    }
    public static char grade(int i,int k)
    {
        char letterGrade = ' ';
        if(i >= k-10)
        {
            letterGrade = 'A';
        }
        else if(i >= k-20)
        {
            letterGrade = 'B';
        }
        else if(i >= k-30)
        {
            letterGrade = 'C';
        }
        else if(i >= k-40)
        {
            letterGrade = 'D';
        }
        else
        {
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
