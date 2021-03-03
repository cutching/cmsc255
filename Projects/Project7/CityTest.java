package Projects.Project7;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CityTest {

    
    @Test
    public void instanceCountTest(){
        City testCity = new City();
        @SuppressWarnings("rawtypes")
        Class c = testCity.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    4, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void instanceVariablesTest(){
        City testCity = new City();
        instanceVariablePrivate("name",testCity);
        instanceVariablePrivate("area",testCity);
        instanceVariablePrivate("population",testCity);
        instanceVariablePrivate("distance",testCity);

        instanceVariableStatic("name",testCity);
        instanceVariableStatic("area",testCity);
        instanceVariableStatic("population",testCity);
        instanceVariableStatic("distance",testCity);

        instanceVariableCorrectType("name", String.class,testCity);
        instanceVariableCorrectType("area", double.class,testCity);
        instanceVariableCorrectType("population", int.class,testCity);
        instanceVariableCorrectType("distance", double.class,testCity);
    }

    @Test
    public void defaultConstructorTest() {
        City testCity = new City();

        testVariable("name",testCity,"","When checking the value of name we",0);
        testVariable("area",testCity,0.0,"When checking the value of area we",0);
        testVariable("population",testCity,0,"When checking the value of population we",0);
        testVariable("distance",testCity,0.0,"When checking the value of distance we",0);

    }

    @Test
    public void parameterizedConstructorTest() {
        City testCity = new City("Richmond, VA",62.57,204214,109);

        testVariable("name",testCity,"Richmond, VA","When checking the value of name we",0);
        testVariable("area",testCity,62.57,"When checking the value of area we",0);
        testVariable("population",testCity,204214,"When checking the value of population we",0);
        testVariable("distance",testCity,109.0,"When checking the value of distance we",0);

    }

    @Test
    public void getNameTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        assertEquals("With an City object who's name instance variable is Albuquerque, NM, when calling getName we","Albuquerque, NM",testCity.getName());
    }

    @Test
    public void City_setNameTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        testCity.setName("Massachusetts");
        testVariable("name",testCity,"Massachusetts","After calling City's setName method with an argument of Massachusetts, for the value of name we",0);
    }

    @Test
    public void getAreaTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        assertEquals("With an City object who's area instance variable is 188.87, when calling getArea we",188.87,testCity.getArea(),.001);
    }

    @Test
    public void setAreaTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        testCity.setArea(190.23);
        testVariable("area",testCity,190.23,"After calling City's setArea method with an argument of 190.23, for the value of area we",0);
    }

    @Test
    public void getPopulationTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        assertEquals("With an City object who's population instance variable is 545852, when calling getPopulation we",545852,testCity.getPopulation());
    }

    @Test
    public void setPopulationTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        testCity.setPopulation(60000);
        testVariable("population",testCity,60000,"After calling City's setPopulation method with an argument of 60000, for the value of population we",0);
    }

    @Test
    public void getDistanceTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        assertEquals("With an City object who's distance instance variable is 64, when calling getDistance we",64,testCity.getDistance(),.001);
    }

    @Test
    public void setDistanceTest() {
        City testCity = createCity("Albuquerque, NM",188.87,545852,64);
        testCity.setDistance(50);
        testVariable("distance",testCity,50.0,"After calling City's setDistance method with an argument of 185, for the value of distance we",0);
    }

    @Test
    public void toStringTest() {
        City testCity = createCity("Kansas City, MO",318.98,459787,63.3);
        assertEquals(  "Kansas City, MO\t318.98\t459787\t63.3", testCity.toString());

        testCity = createCity("Cincinnati, OH",79.56,296945,107);
        assertEquals(  "Cincinnati, OH\t79.56\t296945\t107.0", testCity.toString());
    }

    @Test
    public void equalsTest() {
        //new String() is not redundant, it is used to get around String interning.
        //"Richmond, VA",62.57,204214,109
        City testCity = createCity(new String("Richmond, VA"),62.57,204214,109);
        City testCityClone = createCity(new String("Richmond, VA"),62.57,204214,109);
        City testCityOtherClone = createCity(new String("Richmond, VA"),62.57,204214,109);

        City otherCity = createCity(new String("Rochester, NY"),37.17,210565,73.9);
        City thirdCity = createCity(new String("Sacramento, CA"),99.77,466488,87.9);

        Class c = testCity.getClass();
        //Test if equals takes a parameter of type City and fail them if it does
        try {
            c.getMethod("equals",City.class);
            fail("City's equals method should have a single parameter of type Object");
        } catch (NoSuchMethodException ignored) {}

        try {
            Method f = c.getMethod("equals",Object.class);

            //Test given null
            Object nullReference = null;
            assertFalse("When calling City's equals method with an argument of null, we", (boolean) f.invoke(testCity,nullReference) );

            //Test given a non state object
            assertFalse("When calling City's equals method with a non City argument, we", (boolean) f.invoke(testCity,"NotACity") );

            //Test given itself //reflexive
            assertTrue("When calling City's equals method with an argument of itself, we",(boolean) f.invoke(testCity,testCity));

            //Test symmetric (x.equals(y) == y.equals(x)
            assertTrue("Symmetric test. Expected x.equals(y) == y.equals(x), was",(boolean) f.invoke(testCity,testCityClone) && (boolean) f.invoke(testCityClone,testCity));

            //Test transitive (x.equals(y) == y.equals(z) == x.equals(z))
            assertTrue("Transitive test. Expected x.equals(y) == y.equals(z) == x.equals(z), was",
                    (boolean) f.invoke(testCity,testCityClone) ==
                            (boolean) f.invoke(testCityClone,testCityOtherClone) ==
                            (boolean) f.invoke(testCity,testCityOtherClone)
            );

            //Test non equivalent objects
            assertFalse("When calling City's equals method with an argument a logically different City, we",(boolean) f.invoke(testCity,otherCity) && (boolean) f.invoke(testCity,thirdCity));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
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

    private void instanceVariablePrivate(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue("You must make your instance variables private.", Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("You must make the speed instance variable of type"+ aClass.toString() +".", aClass, c.getDeclaredField(aField).getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField, Object testObject, Object expected, String message, int descendantLevel){
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();

        for(int i = 0; i < descendantLevel; i++){
            c = c.getSuperclass();
        }

        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if(expected == null){
                assertNull(message,fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if(expected.getClass().equals(Double.class)){
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .001);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){

            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

}
