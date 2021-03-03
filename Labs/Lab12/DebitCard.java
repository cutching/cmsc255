package Labs.Lab12;

public class DebitCard extends Card {
    private int cardNumber= 00000000;
    private int pin = 0;

    public DebitCard(){
        super("Jane Doe");
    }

    public DebitCard(String name, int cardNumber, int pin){
        super(name);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String toString(){
        return super.toString() + " Card Number: " + cardNumber;
    }

}
