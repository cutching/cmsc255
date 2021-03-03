package Projects.Project7;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class CityAnalysisTest {

    //@Rule
    //public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void readFileGoodInputTest() throws IOException {
        // Invoke method
        ArrayList<String> actual = CityAnalysis.readFile(generateGoodInputFile());
        // Check results
        testStringArray("When checking the String array returned from the readFile method given a file with valid input data, we",generateGoodInputStringArray(),actual);
    }

    @Test
    public void parseDataGoodInputTest(){
        ArrayList<City> actual = CityAnalysis.parseData(generateGoodInputStringArray());
        testCityArray("When checking the ArrayList returned from the parseData method given data generated from cityData.txt, we",generateGoodInputArrayList(),actual);
    }

    @Test
    public void populationAverageGoodInputTest(){
        double actual = CityAnalysis.calcPopulationAverage(generateGoodInputArrayList());
        assertEquals("When checking the return value from the calcPopulationAverage method given data generated from cityData.txt, we",353721.375,actual,0.01);
    }

    @Test
    public void areaAverageGoodInputTest(){
        double actual = CityAnalysis.calcAreaAverage(generateGoodInputArrayList());
        assertEquals("When checking the return value from the calcAreaAverage method given data generated from cityData.txt, we",133.86,actual,0.01);
    }

    @Test
    public void populationAboveAverageGoodInputTest(){
        ArrayList<String> actual = CityAnalysis.calcPopulationAboveAverage(generateGoodInputArrayList(),375.9);
        String[] temp = {"Albuquerque, NM", "Kansas City, MO", "Richmond, VA", "Sacramento, CA", "Baton Rouge, LA", "Rochester, NY", "Colorado Springs, CO", "Cincinnati, OH"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(temp));
        testStringArray("When checking the return value from the calcPopulationAboveAverage method given data generated from cityData.txt, we",expected,actual);
    }

    @Test
    public void largestDistanceGoodInputTest(){
        City actual = CityAnalysis.findLargestDistance(generateGoodInputArrayList());
        City expected = new City("Richmond, VA",62.57,204214,109.0);

        assertTrue("When checking the return value from the findLargestDistance method given data generated from cityData.txt, we expected the resulting city to be " + expected + " but was " + actual,CityIsEqual(expected,actual));
    }


    @Test
    public void findCityGoodInputTest(){
        boolean actual = CityAnalysis.findCity(generateGoodInputArrayList(),createCity("Baton Rouge, LA",88.65,229493,81.2));

        assertTrue("When checking the return value from the findCity method given data generated from cityData.txt and a valid City object, we",actual);

        actual = CityAnalysis.findCity(generateGoodInputArrayList(),createCity("San Juan, PR",51,344606,60));

        assertFalse("When checking the return value from the findCity method given data generated from cityData.txt and an invalid City object, we",actual);


    }

    @Test
    public void writeOutStringDataGoodInputTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        ArrayList<String> outputData = new ArrayList<>();
        ArrayList<String> expected = generateGoodInputStringArray();
        String message = "Hello World";
        // Invoke method
        CityAnalysis.writeOutData(message,outputData,outputFile);
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);

        int i = 1;

        assertEquals("When checking the output file produced by writeOutData given an String[] of good data, at line " +(i+1)+ " we",message,outputScan.nextLine());

        while (outputScan.hasNextLine()){
            assertEquals("When checking the output file produced by writeOutData given an String[] of good data, at line " +(i+1)+ " we",expected.get(i),outputScan.nextLine());
            i++;
        }
        outputScan.close();
    }

    @Test
    public void writeOutCitiesDataGoodInputTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        ArrayList<City> outputData = generateGoodInputArrayList();
        ArrayList<String> expected = generateGoodInputStringArray();
        // Invoke method
        CityAnalysis.writeOutData(outputData,outputFile);
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);

        int i = 0;
        while (outputScan.hasNextLine()){
            assertEquals("When checking the output file produced by writeOutData given an ArrayList<City> of good data, at line " +(i+1)+ " we",expected.get(i),outputScan.nextLine());
            i++;
        }
        outputScan.close();
    }






    @Test
    public void readFileBadInputTest() throws IOException {
        // Invoke method
        ArrayList<String> actual = CityAnalysis.readFile(generateBadInputFile());
        // Check results
        testStringArray("When checking the String array returned from the readFile method given a file with invalid input data, we",generateBadInputStringArray(),actual);
    }

    @Test
    public void parseDataBadInputTest(){
        ArrayList<City> actual = CityAnalysis.parseData(generateBadInputStringArray());
        testCityArray("When checking the ArrayList returned from the parseData method given data generated from cityDataError.txt, we",generateBadInputArrayList(),actual);
    }

    @Test
    public void populationAverageBadInputTest(){
        double actual = CityAnalysis.calcPopulationAverage(generateBadInputArrayList());
        assertEquals("When checking the return value from the calcPopulationAverage method given data generated from cityDataError.txt, we",266723.75,actual,0.001);
    }

    @Test
    public void areaAverageBadInputTest(){
        double actual = CityAnalysis.calcAreaAverage(generateBadInputArrayList());
        assertEquals("When checking the return value from the calcAreaAverage method given data generated from cityDataError.txt, we",84.048,actual,0.001);
    }

    @Test
    public void populationAboveAverageBadInputTest(){
        ArrayList<String> actual = CityAnalysis.calcPopulationAboveAverage(generateBadInputArrayList(),352.3);
        String[] temp = {"Albuquerque, NM", "Kansas City, MO", "Richmond, VA", "Rochester, NY", "Colorado Springs, CO", "Cincinnati, OH"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(temp));
        testStringArray("When checking the return value from the calcLengthAboveAverage method given data generated from cityDataError.txt, we",expected,actual);
    }

    @Test
    public void findLargestDistanceBadInputTest(){
        City actual = CityAnalysis.findLargestDistance(generateBadInputArrayList());
        City expected = new City("Richmond, VA", 62.57,204214,109.0);
        assertTrue("When checking the return value from the findLargestDistance method given data generated from cityDataError.txt, we expected the resulting city to be " + expected + " but was " + actual,CityIsEqual(expected,actual));
    }


    @Test
    public void findCityBadInputTest(){

        boolean actual = CityAnalysis.findCity(generateBadInputArrayList(),createCity("Richmond, VA",62.57,204214,109));

        assertTrue("When checking the return value from the findCity method given data generated from cityData.txt and a valid City object, we",actual);

        actual = CityAnalysis.findCity(generateBadInputArrayList(),createCity("San Juan, PR",51,344606,60));

        assertFalse("When checking the return value from the findCity method given data generated from cityData.txt and an invalid City object, we",actual);


        actual = CityAnalysis.findCity(generateBadInputArrayList(),createCity("Baton Rouge, LA",88.65,229493,81.2));

        assertFalse("When checking the return value from the findCity method given data generated from cityData.txt and an invalid City object, we",actual);


    }

    @Test
    public void writeOutStringDataBadInputTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        ArrayList<String> outputData = new ArrayList<>();
        ArrayList<String> expected = generateBadInputStringArray();
        String message = "Hello World";
        // Invoke method
        CityAnalysis.writeOutData(message,outputData,outputFile);
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);

        int i = 1;

        assertEquals("When checking the output file produced by writeOutData given an String[] of good data, at line " +(i+1)+ " we",message,outputScan.nextLine());

        while (outputScan.hasNextLine()){
            assertEquals("When checking the output file produced by writeOutData given an String[] of good data, at line " +(i+1)+ " we",expected.get(i),outputScan.nextLine());
            i++;
        }
        outputScan.close();
    }

    @Test
    public void writeOutCitiesDataBadInputTest() throws IOException {
        File outputFile = folder.newFile("bar.txt");
        ArrayList<City> outputData = generateBadInputArrayList();
        ArrayList<String> expected = generateBadOutputStringArray();
        // Invoke method
        CityAnalysis.writeOutData(outputData,outputFile);
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);

        int i = 0;
        while (outputScan.hasNextLine()){
            assertEquals("When checking the output file produced by writeOutData given an String[] of bad data, at line " +(i+1)+ " we",expected.get(i),outputScan.nextLine());
            i++;
        }
        outputScan.close();
    }





    private File generateGoodInputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print("Albuquerque, NM\t188.87\t545852\t64.0\n" +
                "Kansas City, MO\t318.98\t459787\t63.3\n" +
                "Richmond, VA\t62.57\t204214\t109.0\n" +
                "Sacramento, CA\t99.77\t466488\t87.9\n" +
                "Baton Rouge, LA\t88.65\t229493\t81.2\n" +
                "Rochester, NY\t37.17\t210565\t73.9\n" +
                "Colorado Springs, CO\t195.36\t416427\t70.5\n" +
                "Cincinnati, OH\t79.56\t296945\t107.0");
        write.close();
        return inputFile;
    }

    private ArrayList<String> generateGoodInputStringArray(){
        String[] array = {"Albuquerque, NM\t188.87\t545852\t64.0",
                "Kansas City, MO\t318.98\t459787\t63.3",
                "Richmond, VA\t62.57\t204214\t109.0",
                "Sacramento, CA\t99.77\t466488\t87.9",
                "Baton Rouge, LA\t88.65\t229493\t81.2",
                "Rochester, NY\t37.17\t210565\t73.9",
                "Colorado Springs, CO\t195.36\t416427\t70.5",
                "Cincinnati, OH\t79.56\t296945\t107.0"};
        ArrayList<String> toReturn = new ArrayList<>();
        Collections.addAll(toReturn, array);
        return toReturn;
    }

    private ArrayList<City> generateGoodInputArrayList(){
        City[] temp = {
                new City("Albuquerque, NM",188.87,545852,64),
                new City("Kansas City, MO",318.98,459787,63.3),
                new City("Richmond, VA",62.57,204214,109),
                new City("Sacramento, CA",99.77,466488,87.9),
                new City("Baton Rouge, LA",88.65,229493,81.2),
                new City("Rochester, NY",37.17,210565,73.9),
                new City("Colorado Springs, CO",195.36,416427,70.5),
                new City("Cincinnati, OH",79.56,296945,107)
        };

        return new ArrayList<>(Arrays.asList(temp));
    }


    private File generateBadInputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print("Albuquerque, NM\t188.87\t545852\t64.0\n" +
                "Kansas City, MO\t-318.98\t459787\t63.3\n" +
                "Richmond, VA\t62.57\t204214\t109.0\n" +
                "Sacramento, CA\t99.77\t-466488\t87.9\n" +
                "Baton Rouge, LA\t88.65\t22u493\t81.2\n" +
                "Rochester, NY\t37.17\t210565\t7i.9\n" +
                "Colorado Springs, CO\t195.36\t416427\t70.5\n" +
                "Cincinnati, OH\t7o9.56\t296945\t107.0");
        write.close();
        return inputFile;
    }

    private ArrayList<String> generateBadInputStringArray(){
        String[] array = {"Albuquerque, NM\t188.87\t545852\t64.0",
                "Kansas City, MO\t-318.98\t459787\t63.3",
                "Richmond, VA\t62.57\t204214\t109.0",
                "Sacramento, CA\t99.77\t-466488\t87.9",
                "Baton Rouge, LA\t88.65\t22u493\t81.2",
                "Rochester, NY\t37.17\t210565\t7i.9",
                "Colorado Springs, CO\t195.36\t416427\t70.5",
                "Cincinnati, OH\t7o9.56\t296945\t107.0"};
        ArrayList<String> toReturn = new ArrayList<>();
        Collections.addAll(toReturn, array);
        return toReturn;
    }

    private ArrayList<String> generateBadOutputStringArray(){
        String[] array = {"Albuquerque, NM\t188.87\t545852\t64.0",
                "Kansas City, MO\t0.0\t459787\t63.3",
                "Richmond, VA\t62.57\t204214\t109.0",
                "Sacramento, CA\t99.77\t0\t87.9",
                "Baton Rouge, LA\t88.65\t0\t81.2",
                "Rochester, NY\t37.17\t210565\t0.0",
                "Colorado Springs, CO\t195.36\t416427\t70.5",
                "Cincinnati, OH\t0.0\t296945\t107.0"};
        ArrayList<String> toReturn = new ArrayList<>();
        Collections.addAll(toReturn, array);
        return toReturn;
    }

    private ArrayList<City> generateBadInputArrayList(){
        City[] temp = {
                new City("Albuquerque, NM",188.87,545852,64),
                new City("Kansas City, MO",0,459787,63.3),
                new City("Richmond, VA",62.57,204214,109),
                new City("Sacramento, CA",99.77,0,87.9),
                new City("Baton Rouge, LA",88.65,0,81.2),
                new City("Rochester, NY",37.17,210565,0),
                new City("Colorado Springs, CO",195.36,416427,70.5),
                new City("Cincinnati, OH",0,296945,107)};

        return new ArrayList<>(Arrays.asList(temp));
    }


    private void testCityArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!CityIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private void testStringArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean CityIsEqual(Object o1, Object o2){
        @SuppressWarnings("rawtypes")
        Class c = o1.getClass();
        try {
            Field nameFieldo1 = c.getDeclaredField("name");
            nameFieldo1.setAccessible(true);
            Object nameo1 = nameFieldo1.get(o1);

            Field nameFieldo2 = c.getDeclaredField("name");
            nameFieldo2.setAccessible(true);
            Object nameo2 = nameFieldo2.get(o2);

            Field populationFieldo1 = c.getDeclaredField("population");
            populationFieldo1.setAccessible(true);
            Object populationo1 = populationFieldo1.get(o1);

            Field populationFieldo2 = c.getDeclaredField("population");
            populationFieldo2.setAccessible(true);
            Object populationo2 = populationFieldo2.get(o2);

            return nameo1.equals(nameo2) && populationo1.equals(populationo2);


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

    private City createCity(String aName, double anArea, int aPopulation, double aDistance){
        City testCity = new City();
        @SuppressWarnings("rawtypes")
        Class c = testCity.getClass();

        try {
            Field name = c.getDeclaredField("name");
            name.setAccessible(true);
            name.set(testCity, aName);

            Field area = c.getDeclaredField("area");
            area.setAccessible(true);
            area.set(testCity, anArea);

            Field population = c.getDeclaredField("population");
            population.setAccessible(true);
            population.set(testCity, aPopulation);

            Field distance = c.getDeclaredField("distance");
            distance.setAccessible(true);
            distance.set(testCity, aDistance);


        } catch (Exception e) {
            fail(e.toString());
        }

        return testCity;
    }

}
