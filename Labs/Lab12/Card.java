package Labs.Lab12;

public class Card {
    private String name = "";

    public Card(){

    }

    public Card(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card Holder: " + name;
    }
}
