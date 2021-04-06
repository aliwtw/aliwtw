package DPIT121.Insurance_Policies1;

import java.io.Serializable;



enum CarType{Benz,Jeep,Audi,Cadillac,Porsche,VOLVO,Toyota,Ford}
public class Car implements Serializable, Cloneable
{
    //attribues
    private String model;
    private int manufacturingYear;
    private double price;
    private CarType carType;
    
    //constructors
    //default constructor
    public Car(){}
    //constructors with parameters
    public Car(String model,int manufacturingYear,double price,CarType carType) 
    {
        this.model=model;
        this.manufacturingYear=manufacturingYear;
        this.price=price;
        this.carType=carType;
    }
    
    public Car clone() throws CloneNotSupportedException
    {
        
        return (Car) super.clone();
    }
    
    //accessors
    public String getModel()
    {
        return model;
    }
    public int getManufacturingYear()
    {
        return manufacturingYear;
    }
    public double getPrice()
    {
        return price;
    }
    public CarType getCarType()
    {
        return carType;
    }
    
    //mutators
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    //methods
    //print out car details
    public void printCarDetails()
    {
        System.out.printf("%-15s%-20s%-15s%-15s%n",model,manufacturingYear,price,carType);
    }
    //return carmodel details, convert an object to string
    @Override
    public String toString()
    {
        return "carModel:"+model+" manufacturingYear:"+manufacturingYear+" price:"+price+" carType:"+carType;
    }
    
        public String toDelimitedString()
    {
        return model+ "|" +carType+ "|" +manufacturingYear+ "|" +price;
    }
}
