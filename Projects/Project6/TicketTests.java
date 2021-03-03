package Projects.Project6;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TicketTests {

    //@Rule
    //public Timeout globalTimeout = Timeout.seconds(3); // 3 seconds max per method tested

    @Test
    public void Ticket_instanceCountTest(){
        Ticket testTicket = new Ticket();
        @SuppressWarnings("rawtypes")
        Class c = testTicket.getClass();
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
    public void Ticket_instanceVariablesTest(){
        Ticket testTicket = new Ticket();
        instanceVariablePrivate("location",testTicket);
        instanceVariablePrivate("food",testTicket);
        instanceVariablePrivate("drink",testTicket);
        instanceVariablePrivate("discount",testTicket);

        instanceVariableStatic("location",testTicket);
        instanceVariableStatic("food",testTicket);
        instanceVariableStatic("drink",testTicket);
        instanceVariableStatic("discount",testTicket);

        instanceVariableCorrectType("location",Location.class,testTicket);
        instanceVariableCorrectType("food",Food_Option.class,testTicket);
        instanceVariableCorrectType("drink",Drink_Option.class,testTicket);
        instanceVariableCorrectType("discount",Discount.class,testTicket);
    }

    @Test
    public void Ticket_defaultConstructorTest() {
        Ticket testTicket = new Ticket();

        testVariable("location",testTicket,Location.FRONT,"When checking the value of location we");
        testVariable("food",testTicket,Food_Option.NONE,"When checking the value of food we");
        testVariable("drink",testTicket,Drink_Option.NONE,"When checking the value of drink we");
        testVariable("discount",testTicket,Discount.NONE,"When checking the value of discount we");

    }

    @Test
    public void Ticket_parameterizedConstructorTest() {
        Ticket testTicket = new Ticket(Location.MIDDLE);

        testVariable("location",testTicket,Location.MIDDLE,"When checking the value of location we");
        testVariable("food",testTicket,Food_Option.NONE,"When checking the value of food we");
        testVariable("drink",testTicket,Drink_Option.NONE,"When checking the value of drink we");
        testVariable("discount",testTicket,Discount.NONE,"When checking the value of discount we");

    }

    @Test
    public void Ticket_getLocationTest() {
        Ticket testTicket = createTicket(Location.BALCONY,Food_Option.CANDY_BOX,Drink_Option.LEMONADE,Discount.FREQUENT_MOVIE_GOER);
        assertEquals("With an Ticket object who's location instance variable is BALCONY, when calling getLocation we",Location.BALCONY,testTicket.getLocation());
    }

    @Test
    public void Ticket_setLocationTest() {
        Ticket testTicket = createTicket(Location.FRONT,Food_Option.PIZZA,Drink_Option.NONE,Discount.NONE);
        testTicket.setLocation(Location.BACK);
        testVariable("location",testTicket,Location.BACK,"After calling Ticket's setLocation method with an argument of BACK, for the value of location we");
    }

    @Test
    public void Ticket_getFoodTest() {
        Ticket testTicket = createTicket(Location.MIDDLE,Food_Option.POPCORN,Drink_Option.NONE,Discount.CHILD);
        assertEquals("With an Ticket object who's food instance variable is CHOCOLATE, when calling getFood we",Food_Option.POPCORN,testTicket.getFood());
    }

    @Test
    public void Ticket_setFoodTest() {
        Ticket testTicket = createTicket(Location.BACK,Food_Option.NONE,Drink_Option.NONE,Discount.NONE);
        testTicket.setFood(Food_Option.POPCORN);
        testVariable("food",testTicket,Food_Option.POPCORN,"After calling Ticket's setFood method with an argument of POPCORN, for the value of food we");
    }

    @Test
    public void Ticket_getDrinkTest() {
        Ticket testTicket = createTicket(Location.BALCONY,Food_Option.PIZZA,Drink_Option.BOTTLED_WATER,Discount.MILITARY);
        assertEquals("With an Ticket object who's drink instance variable is BOTTLED_WATER, when calling getDrink we",Drink_Option.BOTTLED_WATER,testTicket.getDrink());
    }

    @Test
    public void Ticket_setDrinkTest() {
        Ticket testTicket = createTicket(Location.BACK,Food_Option.NONE,Drink_Option.NONE,Discount.NONE);
        testTicket.setDrink(Drink_Option.SODA);
        testVariable("drink",testTicket,Drink_Option.SODA,"After calling Ticket's setDrink method with an argument of SODA, for the value of drink we");
    }

    @Test
    public void Ticket_getDiscountTest() {
        Ticket testTicket = createTicket(Location.FRONT,Food_Option.NONE,Drink_Option.NONE,Discount.FREQUENT_MOVIE_GOER);
        assertEquals("With an Ticket object who's discount instance variable is FREQUENT_MOVIE_GOER, when calling getDiscount we",Discount.FREQUENT_MOVIE_GOER,testTicket.getDiscount());
    }

    @Test
    public void Ticket_setDiscountTest() {
        Ticket testTicket = createTicket(Location.FRONT,Food_Option.CANDY_BOX,Drink_Option.NONE,Discount.NONE);
        testTicket.setDiscount(Discount.CHILD);
        testVariable("discount",testTicket,Discount.CHILD,"After calling Ticket's setDiscount method with an argument of CHILD, for the value of discount we");
    }

    @Test
    public void Ticket_toStringTest() {
        Ticket testTicket = createTicket(Location.MIDDLE,Food_Option.POPCORN,Drink_Option.NONE,Discount.FREQUENT_MOVIE_GOER);
        assertEquals(  "\n\tMIDDLE\n" +
                "\tPOPCORN\n" +
                "\tNONE\n" +
                "\tFREQUENT_MOVIE_GOER\n", testTicket.toString());

        testTicket = createTicket(Location.BACK,Food_Option.PIZZA,Drink_Option.ICEE,Discount.SENIOR);
        assertEquals(  "\n\tBACK\n" +
                "\tPIZZA\n" +
                "\tICEE\n" +
                "\tSENIOR\n", testTicket.toString());
    }

    private Ticket createTicket(Location aLocation, Food_Option aFood, Drink_Option aDrink, Discount aDiscount){
        Ticket testTicket = new Ticket();
        @SuppressWarnings("rawtypes")
        Class c = testTicket.getClass();

        try {
            Field location = c.getDeclaredField("location");
            location.setAccessible(true);
            location.set(testTicket, aLocation);

            Field food = c.getDeclaredField("food");
            food.setAccessible(true);
            food.set(testTicket, aFood);

            Field drink = c.getDeclaredField("drink");
            drink.setAccessible(true);
            drink.set(testTicket, aDrink);

            Field discount = c.getDeclaredField("discount");
            discount.setAccessible(true);
            discount.set(testTicket, aDiscount);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testTicket;
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

    private void testVariable(String aField, Object testObject, Object expected, String message){
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
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
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){
                //CUSTOM FOR PROJECT6TESTS!!!
                testTicketArray(message,(ArrayList) expected, (ArrayList) fieldValue);
            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

    private void testTicketArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!TicketIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean TicketIsEqual(Object o1, Object o2){
        @SuppressWarnings("rawtypes")
        Class c = o1.getClass();
        try {
            Field locationFieldo1 = c.getDeclaredField("location");
            locationFieldo1.setAccessible(true);
            Object locationo1 = locationFieldo1.get(o1);

            Field locationFieldo2 = c.getDeclaredField("location");
            locationFieldo2.setAccessible(true);
            Object locationo2 = locationFieldo2.get(o2);

            Field foodFieldo1 = c.getDeclaredField("food");
            foodFieldo1.setAccessible(true);
            Object foodo1 = foodFieldo1.get(o1);

            Field foodFieldo2 = c.getDeclaredField("food");
            foodFieldo2.setAccessible(true);
            Object foodo2 = foodFieldo2.get(o2);

            Field drinkFieldo1 = c.getDeclaredField("drink");
            drinkFieldo1.setAccessible(true);
            Object drinko1 = drinkFieldo1.get(o1);

            Field drinkFieldo2 = c.getDeclaredField("drink");
            drinkFieldo2.setAccessible(true);
            Object drinko2 = drinkFieldo2.get(o2);

            Field discountFieldo1 = c.getDeclaredField("discount");
            discountFieldo1.setAccessible(true);
            Object discounto1 = discountFieldo1.get(o1);

            Field discountFieldo2 = c.getDeclaredField("discount");
            discountFieldo2.setAccessible(true);
            Object discounto2 = discountFieldo2.get(o2);

            if(locationo1.equals(locationo2) && foodo1.equals(foodo2) && drinko1.equals(drinko2) && discounto1.equals(discounto2)){
                return true;
            }
            else{
                return false;
            }


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}