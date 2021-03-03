/************************************
*StarSign.java 
*************************************
*Finds the price of a custom star shaped sign
*Gavin Cutchin
*9/23/2020
*CMSC 255 002
************************************/
import java.util.*;

public class StarSign
{
	public static void main(String[] args)
	{
		//initializes scanner object
		Scanner scan = new Scanner(System.in);
		
		//initializes all variables
		double starArea, pyramidArea, totalArea, radius, base, height, cost;
		String signString, answer = "";
		
		//do loop guarantees the program in the loop will run at least once
		do
		{
			//prints asking for radius and then reads for radius
			System.out.println("Enter the radius of the star:");
			radius = scan.nextDouble();
			
			//prints asking for base and then reads for base
			System.out.println("Enter the base of the pyramid:");
			base = scan.nextDouble();
			
			//prints asking for height and then reads height
			System.out.println("Enter the height of the pyramid:");
			height = scan.nextDouble();
			
			//eats the next line so the scanner doesn't skip the next input
			scan.nextLine();
			
			//prints asking for a string and then reads the string
			System.out.println("Enter the string you would like on your sign:");
			signString = scan.nextLine();
			
			//replaces all whitespace in the string so we can accurately count characters
			signString = signString.replace(" ", "");
			
			//computes star area
			starArea = (radius * radius * 5.0) / (Math.tan(72) + Math.tan(54));
			
			//computes the pyramids area
			pyramidArea = (base * base) + (2.0 * base * (Math.pow(((base * base) / 4.0) + (height * height), 0.5 )));
			
			//computes the combined shape area
			totalArea = starArea + pyramidArea;
			
			//computes relative cost for each area and totals it
			cost = (totalArea * 3.45) + (signString.length() * 2.35);
			
			//formats cost output to $###,###.##
			System.out.printf("$%.2f%n", cost);
			
			//prints asking for quit option and trims response
			System.out.println("Would you like to create another sign? Enter quit to exit.");
			answer = scan.nextLine();
			answer = answer.trim();
			
			//loops as long as the user doesn't enter quit
		}while(answer.equalsIgnoreCase("quit") != true);
	}
}
