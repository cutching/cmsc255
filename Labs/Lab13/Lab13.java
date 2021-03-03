package Labs.Lab13;
import java.io.*;
import java.util.*;

public class Lab13 {
    public static void main(String[] args){



        try {
            File stats = new File(args[0]);
            File output = new File(args[1]);
            processFile(stats, output);

        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File(s) not Found");
        }
    }

    public static void processFile(File inputFile, File outputFile) throws FileNotFoundException{
        ArrayList<Team> team = new ArrayList<Team>();
        Scanner fileInput = new Scanner(inputFile);

        PrintWriter writer = new PrintWriter(outputFile);

        while(fileInput.hasNext()){
            String[] teamInfo = fileInput.nextLine().split(",");
            Team temp = new Team(teamInfo[0], Integer.parseInt(teamInfo[1]), Double.parseDouble(teamInfo[2]));
            team.add(temp);

        }


        int min = team.get(0).getNumGoals();
        int minPosition = 0;

        int max = 0;
        int maxPosition = 0;

        int count = 0;
        double average = 0;

        for(int i = 0; i < team.size(); i++) {

            if(team.get(i).getNumGoals() > max){
                max = team.get(i).getNumGoals();
                maxPosition = i;
            }

            if(team.get(i).getNumGoals() < min){
                min = team.get(i).getNumGoals();
                minPosition = i;
            }

            average += team.get(i).getNumShots();
            count++;
        }

        average = average / count;

        writer.println("Maximum goals Scored: " + team.get(maxPosition).getName() + " " + max);
        writer.println("Minimum goals Scored: " + team.get(minPosition).getName() + " " + min);
        writer.print("Average shots per game: ");
        writer.printf( "%.3f",average);
        writer.close();
    }
}
