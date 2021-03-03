package Labs.Lab10;

public class FanTest
{
    public static void main(String[] args)
    {
        Fan fan1 = new Fan(3,true,10,"yellow");
        Fan fan2 = new Fan(2,false,20,"blue");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

    }
}
