/************************************
 *Fan.java
 *************************************
 *Making a Fan Object Class
 *Gavin Cutchin
 *10/21/2020
 *CMSC 255 002
 ************************************/
package Labs.Lab10;

public class Fan
{
    //initialize all constant variables
    final public static int SLOW = 1;
    final public static int MEDIUM = 2;
    final public static int FAST = 3;

    //initialize all class level variables
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    //default constructor
    public Fan()
    {
    }

    //specifying constructor
    public Fan(int speed, boolean on, double radius, String color)
    {
        //class level variable = instance variable
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    //returns the string of info related to each fan
    public String toString()
    {
        if(on == true)
        {
            return "fan is " + speed + ", " + color + ", and size " + radius;
        }
        else
        {
            return "fan is off";
        }

    }

    //returns current speed
    public int getSpeed()
    {
        return speed;
    }

    //sets a new speed
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    //returns if a fan is on
    public boolean isOn ()
    {
        return on;
    }

    //sets a power state for the fan
    public void setOn(boolean on)
    {
        this.on = on;
    }

    //returns the radius of a fan
    public double getRadius() {
        return radius;
    }

    //sets a new radius for a fan
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //sets a new color for a fan
    public void setColor(String color) {
        this.color = color;
    }

    //gets the current color of a fan
    public String getColor() {
        return color;
    }


}
