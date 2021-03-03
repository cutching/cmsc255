package Labs.RevelProjects;
import java.util.*;

public class Exercise12_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String entry = "";

        System.out.println("Enter a binary number: ");
        entry = scan.nextLine();

        try{
           System.out.println(bin2Dec(entry));
        }
        catch(NumberFormatException ex) {
            System.out.println(ex);
        }

    }

    public static int bin2Dec(String binaryString) throws NumberFormatException{
        try{
            return Integer.parseInt(binaryString, 2);
        }
        catch(NumberFormatException ex) {
            throw new NumberFormatException("Not a binary number: " + binaryString);
        }
    }
}
