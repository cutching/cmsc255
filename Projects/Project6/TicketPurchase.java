/****************************************************************************
 *TicketPurchase.java
 ****************************************************************************
 *Test Ticket class and Customer class
 *Gavin Cutchin
 *10/29/2020
 *CMSC 255 002
 ****************************************************************************/
package Projects.Project6;
public class TicketPurchase {
    public static void main(String[] args){

        //creates two new customer objects
        Customer zach = new Customer("Whitten", "Zach", 27, "zwhitten@vcu.edu");
        Customer caroline = new Customer("Budwell", "Caroline", 39, "ccbudwell@vcu.edu");

        //creates 3 new ticket objects
        Ticket testTicket1 = new Ticket();
        Ticket testTicket2 = new Ticket();
        Ticket testTicket3 = new Ticket();

        //sets values of ticket1
        testTicket1.setLocation(Location.FRONT);
        testTicket1.setFood(Food_Option.POPCORN);
        testTicket1.setDrink(Drink_Option.ICEE);
        testTicket1.setDiscount(Discount.SENIOR);

        //sets values  of ticket2
        testTicket2.setLocation(Location.BALCONY);
        testTicket2.setFood(Food_Option.CANDY_BOX);
        testTicket2.setDrink(Drink_Option.SODA);
        testTicket2.setDiscount(Discount.NONE);

        //sets values of ticket3
        testTicket3.setLocation(Location.BACK);
        testTicket3.setFood(Food_Option.PIZZA);
        testTicket3.setDrink(Drink_Option.LEMONADE);
        testTicket3.setDiscount(Discount.FREQUENT_MOVIE_GOER);

        //adds both ticket1 and ticket2 to caroline
        caroline.purchaseTicket(testTicket1);
        caroline.purchaseTicket(testTicket2);

        //adds ticket3 to zach
        zach.purchaseTicket(testTicket3);

        //prints all relevant information
        System.out.println(caroline.toString());
        System.out.println(zach.toString());

    }
}
