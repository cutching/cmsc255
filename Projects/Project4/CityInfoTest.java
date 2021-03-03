package Projects.Project4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CityInfoTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void processInputInvalidCity(){
        String input = "Boston, MA\nSacramento, CA\nquit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CityInfo.processInput();
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","Enter the city:",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","Please enter a valid city name",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","Sacramento, CA dist of: 141.46km and pop density of: 4,675.63",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","Average pop density of: 3,298.57",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","Lowest pop density of: 1,441.43",rawOutput[4].trim());
        assertEquals("When checking the sixth line of output we","Would you like to enter another city? Enter quit to exit.",rawOutput[5].trim());
    }

    @Test
    public void processInputValidCity(){
        String input = "Richmond, VA\nquit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CityInfo.processInput();
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","Enter the city:",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","Richmond, VA dist of: 175.42km and pop density of: 3,263.77",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","Average pop density of: 3,298.57",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","Lowest pop density of: 1,441.43",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","Would you like to enter another city? Enter quit to exit.",rawOutput[4].trim());
    }

    @Test
    public void processInputLooping(){
        String input = "Richmond, VA\nyes\nKansas City, MO\nanother!\nCharlottesville, VA\nRochester, NY\nquit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CityInfo.processInput();
        String[] rawOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("When checking the first line of output we","Enter the city:",rawOutput[0].trim());
        assertEquals("When checking the second line of output we","Richmond, VA dist of: 175.42km and pop density of: 3,263.77",rawOutput[1].trim());
        assertEquals("When checking the third line of output we","Average pop density of: 3,298.57",rawOutput[2].trim());
        assertEquals("When checking the fourth line of output we","Lowest pop density of: 1,441.43",rawOutput[3].trim());
        assertEquals("When checking the fifth line of output we","Would you like to enter another city? Enter quit to exit.",rawOutput[4].trim());

        assertEquals("When checking the sixth line of output we","Enter the city:",rawOutput[5].trim());
        assertEquals("When checking the seventh line of output we","Kansas City, MO dist of: 101.87km and pop density of: 1,441.43",rawOutput[6].trim());
        assertEquals("When checking the eight line of output we","Average pop density of: 3,298.57",rawOutput[7].trim());
        assertEquals("When checking the ninth line of output we","Lowest pop density of: 1,441.43",rawOutput[8].trim());
        assertEquals("When checking the tenth line of output we","Would you like to enter another city? Enter quit to exit.",rawOutput[9].trim());

        assertEquals("When checking the eleventh line of output we","Enter the city:",rawOutput[10].trim());
        assertEquals("When checking the twelfth line of output we","Please enter a valid city name",rawOutput[11].trim());


        assertEquals("When checking the thirteenth line of output we","Rochester, NY dist of: 118.93km and pop density of: 5,664.92",rawOutput[12].trim());
        assertEquals("When checking the fourteenth line of output we","Average pop density of: 3,298.57",rawOutput[13].trim());
        assertEquals("When checking the fiftieth line of output we","Lowest pop density of: 1,441.43",rawOutput[14].trim());

        assertEquals("When checking the sixteenth line of output we","Would you like to enter another city? Enter quit to exit.",rawOutput[15].trim());
    }

    @Test
    public void calcPopDensityTest(){
        double[] expected = {2890.093715,1441.4289297,3263.768579,4675.633958,2588.7535250,5664.917944,2131.5878378,3732.3403720};
        double[] actual = CityInfo.calcPopDensity();

        assertEquals("When checking the length of the double array returned by calcPopDensity we",expected.length,actual.length);

        for(int i = 0; i < actual.length; i++){
            assertEquals("When checking the value at index "+i+" of the double array returned by calcPopDensity we",expected[i],actual[i],.001);
        }
    }

    @Test
    public void calcPopDensityGivenDataTest(){
        double[] popDensity = {2890.093715,1441.4289297,3263.768579,4675.633958,2588.7535250,5664.917944,2131.5878378,3732.3403720};
        double actual = CityInfo.calcPopAvgDensity(popDensity);
        double expected = 3298.5656;
        assertEquals("When checking the result of calcPopDensity we",expected,actual,.001);
    }

    @Test
    public void calcPopDensityUnknownDataTest(){
        double[] popDensity = {4898.61689,9066.039091,9906.200887,5506.878361,9842.643940,9620.781657,272.5559730,7775.999380};
        double actual = CityInfo.calcPopAvgDensity(popDensity);
        double expected = 7111.2145;
        assertEquals("When checking the result of calcPopDensity we",expected,actual,.001);
    }

    @Test
    public void getLowestPopDensityGivenDataTest(){
        double[] popDensity = {2890.093715,1441.4289297,3263.768579,4675.633958,2588.7535250,5664.917944,2131.5878378,3732.3403720};
        double actual = CityInfo.getLowestPopDensity(popDensity);
        double expected = 1441.4289;
        assertEquals("When checking the result of getLowestPopDensity we",expected,actual,.001);
    }

    @Test
    public void getLowestPopDensityUnknownDataTest(){
        double[] popDensity = {4898.61689,9066.039091,9906.200887,5506.878361,9842.643940,9620.781657,2772.5559730,7775.999380};
        double actual = CityInfo.getLowestPopDensity(popDensity);
        double expected = 2772.5559;
        assertEquals("When checking the result of getLowestPopDensity we",expected,actual,.001);
    }

    @Test
    public void getCityPositionValidDataTest(){
        String[] cities = {"Albuquerque, NM", "Kansas City, MO", "Richmond, VA", "Sacramento, CA", "Baton Rouge, LA", "Rochester, NY", "Colorado Springs, CO", "Cincinnati, OH"};
        for(int i = 0; i < cities.length; i++){
            assertEquals("Calling getCityPosition with an argument of "+cities[i]+" we",i,CityInfo.getCityPosition(cities[i]));
        }
    }

    @Test
    public void getCityPositionInvalidDataTest(){
        String[] cities = {"Boston, MA", "West Palm Beach, FL"};
        for(int i = 0; i < cities.length; i++){
            assertEquals("Calling getCityPosition with an argument of "+cities[i]+" we",-1,CityInfo.getCityPosition(cities[i]));
        }
    }

    @Test
    public void getDistanceTest(){
        double[] expected = {102.9977,101.8712,175.4180,141.4609,130.6784,118.9302,113.4584,172.1993};

        for(int i = 0; i < expected.length; i++){
            assertEquals("Calling getDistance with an argument of "+i+" we",expected[i],CityInfo.getDistance(i),.001);
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
