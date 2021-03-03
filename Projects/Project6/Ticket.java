/****************************************************************************
 *Ticket.java
 ****************************************************************************
 *Defining the Ticket class
 *Gavin Cutchin
 *11/6/2020
 *CMSC 255 002
 ****************************************************************************/
package Projects.Project6;

public class Ticket {
    //sets each piece of info to default values
    private Location location = Location.FRONT;
    private Food_Option food = Food_Option.NONE;
    private Drink_Option drink = Drink_Option.NONE;
    private Discount discount = Discount.NONE;

    //default constructor
    public Ticket(){
    }

    //constructor that sets location
    public Ticket(Location location) {
        this.location = location;
    }

    //location setter
    public void setLocation(Location location) {
        this.location = location;
    }

    //location getter
    public Location getLocation() {
        return location;
    }

    //food setter
    public void setFood(Food_Option food) {
        this.food = food;
    }

    //food getter
    public Food_Option getFood() {
        return food;
    }

    //drink setter
    public void setDrink(Drink_Option drink) {
        this.drink = drink;
    }

    //drink getter
    public Drink_Option getDrink() {
        return drink;
    }

    //discount setter
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    //discount getter
    public Discount getDiscount() {
        return discount;
    }

    //return the string concatenation of all relevant values
    public String toString(){
        return "\n\t" + location + "\n\t" + food + "\n\t" + drink + "\n\t" + discount + "\n";
    }
}
