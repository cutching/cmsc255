/****************************************************************************
 *ScoopsAhoy.java
 ****************************************************************************
 *Find Ice Cream Compatibility Based on Flavor Choice and Compatibility Score
 *Gavin Cutchin
 *10/22/2020
 *CMSC 255 002
 ****************************************************************************/

package Projects.Project5;
import java.util.*;

public class ScoopsAhoy
{
    public static void main(String[] args)
    {
        //initialize scanner object
        Scanner scan = new Scanner (System.in);
        //SET string inputFlavor to next line and trim it
        String inputFlavor = scan.nextLine();
        inputFlavor = inputFlavor.trim();
        //SET string inputScores to next line and trim it
        String inputScores = scan.nextLine();
        inputScores = inputScores.trim();
        //initialize 1d array to hold all the flavors
        String[] flavors = getFlavors(inputFlavor);
        //initialize 2d array to hold all compatibility scores
        double[][] scores = getScores(inputScores);
        //initialize boolean answer for close and far off comparisons
        boolean answer = false;

        //PRINT asking for a true or false response to set the boolean answer
        System.out.println("Type true if you would like to search flavors that are most compatible or false if you would like to search for flavors that are least compatible: ");
        //SET response to the next line trimmed
        String response = scan.nextLine();
        response = response.trim();

        //IF ELSE statements that translate from a string to a boolean response for the variable answer
        if(response.equalsIgnoreCase("true"))
        {
            answer = true;
        }
        else if(response.equalsIgnoreCase("false"))
        {
            answer = false;
        }

        //PRINT asking for compatibility score to start at
        System.out.println("Enter the compatibility score you would like to starts from: ");
        //SET compatibility score
        double compatibilityScore = scan.nextDouble();

        //PRINT asking for a flavor of choice to compare
        System.out.println("Enter the flavor to compare");
        //SET flavor of choice and trim it
        String flavorChoice = scan.next();
        flavorChoice = flavorChoice.trim();

        //SET string array result to the corresponding flavors in alphabetical order using searchCompatibility
        String[] result = searchCompatibility(scores,flavors,answer,compatibilityScore,flavorChoice);
        //PRINT results using Arrays.toString()
        System.out.println(Arrays.toString(result));

    }

    //METHOD getFlavors returns a string array of all flavors to compare
    public static String[] getFlavors(String inputFlavorString)
    {
        //SET string array flavor to each flavor in the string separated by a comma ~","
        String[] flavor = inputFlavorString.split(",");
        return flavor;
    }

    //METHOD getScores returns a double 2d array of all corresponding flavors from the scores input
    public static double[][] getScores(String inputScoresString)
    {
        //SET string array firstDelim to the scores input separated by the first delimiter <>
        String[] firstDelim = inputScoresString.split("<>");
        //initialize a 2d string array secondDelim to a row size of firstDelim.length
        String[][] secondDelim = new String[firstDelim.length][];

        //LOOP through the length of the firstDelim and split each element of firstDelim by "," into each row of secondDelim
        for(int i = 0; i < firstDelim.length; i++)
        {
            secondDelim[i] = firstDelim[i].split(",");
        }

        //initialize 2d double array result to a row size of secondDelim length by secondDelim column length
        double[][] result = new double[secondDelim.length][secondDelim[0].length];

        //LOOP through each element in the secondDelim array and parse the double to each mirroring element in the result array
        for(int i = 0; i < secondDelim.length; i++)
        {
            for(int k = 0; k < secondDelim[i].length; k++)
            {
                result[i][k] =   Double.parseDouble(secondDelim[i][k]);
            }
        }
        return result;
    }

    //METHOD searchCompatibility that returns a string array of the most compatible or least compatible flavors based on score
    public static String[] searchCompatibility(double[][] scores, String[] flavors, boolean isOver, double aScore, String aFlavor)
    {
        //initialize temp array to the amount of flavors there are
        String[] tempCompatibility = new String[flavors.length];
        //position holds the index of the specified aFlavor in the flavors array
        int position = 0;
        //count is used twice for the number of relevant flavors to store
        int count = 0;

        //LOOP through the flavors array for the aFlavor and store the position
        for(int i = 0; i < flavors.length;i++)
        {
            if(aFlavor.equals(flavors[i]))
            {
                position = i;
            }
        }


        //IF ELSE depending on whether the choice is true or false
        if(isOver == false)
        {
            //LOOP through the length of scores array
            for(int i = 0; i < scores.length; i++)
            {
                //IF entered score is greater than the score at current position AND check if the flavor at the index is the same flavor we are checking
                if(aScore > scores[position][i] && flavors[position] != flavors[i])
                {
                    //copy the relevant flavors to the temp array
                    tempCompatibility[i] = flavors[i];
                    count++;

                }
            }
        }
        else
        {
            //LOOP through the length of the scores array
            for(int i = 0; i < scores.length; i++)
            {
                //IF entered score is less than or equal to the score at current position AND check if the flavor at the index is the same flavor we are checking
                if(aScore <= scores[position][i] && flavors[position] != flavors[i])
                {
                    //copy the relevant flavors to the temp array
                    tempCompatibility[i] = flavors[i];
                    count++;
                }
            }
        }

        //initialize string array compatibility with the size of all relevant flavors (count)
        String[] compatibility = new String[count];

        //reset count to 0 to be reused
        count = 0;

        //LOOP through the temp array
        for(int i = 0; i < tempCompatibility.length;i++)
        {
            //the temp array is null everywhere where there isn't a relevant flavor
            if(tempCompatibility[i] != null)
            {
                //the flavor is stored in the new array with no extra spaces
                compatibility[count] = tempCompatibility[i];
                count++;
            }
        }

        //LOOP through the length of compatibility
        for(int i = 0; i < compatibility.length;i++)
        {
            //initialize temp string variable to hold individual string values
            String temp = "";

            //LOOP through the compatibility array again
            for(int k = 0; k < compatibility.length; k++)
            {
                //IF the current string at the index is further lexicographically than the rest it gets rotated to where it should be
                if (compatibility[i].compareToIgnoreCase(compatibility[k]) < 0)
                {
                    //array index switching
                    temp = compatibility[i];
                    compatibility[i] = compatibility[k];
                    compatibility[k] = temp;
                }
            }
        }

        return compatibility;
    }


}
