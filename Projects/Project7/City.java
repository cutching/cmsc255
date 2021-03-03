/****************************************************************************
 *City.java
 ****************************************************************************
 *Defining the City object and appropriate attributes
 *Gavin Cutchin
 *11/19/2020
 *CMSC 255 002
 ****************************************************************************/
package Projects.Project7;

import java.util.Objects;

public class City {
    //initialize starting  city values
    private String name = "";
    private double area = 0;
    private int population = 0;
    private double distance = 0;
    //default constructor
    public City(){}
    //parameterized constructor
    public City(String name, double area, int population, double distance){
        this.name = name;
        this.area = area;
        this.population = population;
        this.distance = distance;
    }

    //override of the equals method for a City object, only checks if name and population are the same
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }
        City city = (City) o;
        return population == city.population && Objects.equals(name, city.name);
    }

    //toString method to return all relevant city info
    public String toString(){
        return this.name + "\t" + this.area + "\t" + this.population + "\t" + this.distance;
    }

    //name getter
    public String getName() {
        return name;
    }
    //name setter
    public void setName(String name) {
        this.name = name;
    }
    //area getter
    public double getArea() {
        return area;
    }
    //area setter
    public void setArea(double area) {
        this.area = area;
    }
    //population getter
    public int getPopulation() {
        return population;
    }
    //population setter
    public void setPopulation(int population) {
        this.population = population;
    }
    //distance getter
    public double getDistance() {
        return distance;
    }
    //distance setter
    public void setDistance(double distance) {
        this.distance = distance;
    }
}
