package Labs.Lab12;

public class IDCard extends Card{
    private int idNumber = 0;

    public IDCard(){
        super("Jane Smith");
    }

    public IDCard(String name, int idNumber){
        super(name);
        this.idNumber = idNumber;
    }

    public String toString(){
        return super.toString() + " ID Number: " + idNumber;
    }
}
