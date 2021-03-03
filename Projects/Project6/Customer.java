/****************************************************************************
 *Customer.java
 ****************************************************************************
 *Defining the Customer class and their attributes
 *Gavin Cutchin
 *11/6/2020
 *CMSC 255 002
 ****************************************************************************/
package Projects.Project6;
import java.util.ArrayList;

public class Customer {

    //initialize class variables to default values
    private String lastName = "";
    private String firstName = "";
    private int age = 0;
    private String email = "";
    //customers will hold an array of tickets
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    //default constructor
    public Customer(){
    }

    //constructor that takes first and last name, age and email and stores it
    public Customer(String lastName, String firstName, int age, String email){
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
    }

    //lastName setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //lastName getter
    public String getLastName() {
        return lastName;
    }

    //firstName setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //firstName getter
    public String getFirstName() {
        return firstName;
    }

    //age setter
    public void setAge(int age) {
        this.age = age;
    }

    //age getter
    public int getAge() {
        return age;
    }

    //email setter
    public void setEmail(String email) {
        this.email = email;
    }

    //email getter
    public String getEmail() {
        return email;
    }

    //adds a ticket to the ticket array list
    public void purchaseTicket(Ticket ticket){
        tickets.add(ticket);
    }

    //returns the array list of tickets
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    //returns the number of tickets in the arrayList
    public int getNumTickets(){
        int numTicket = 0;
        for(int i = 0; i < tickets.size();i++) {
            if(!tickets.isEmpty() && tickets.get(i) != null) {
                numTicket++;
            }
        }
        return numTicket;
    }

    //updates the toString function to print all customer info and all their tickets
    public String toString(){
        String output =  firstName + " " + lastName + "\n" + age + "\n" + email + "\nTicket Order:\n";
        for (Ticket inList: tickets) {
            output += inList.toString();
        }
        return output;
    }
}
