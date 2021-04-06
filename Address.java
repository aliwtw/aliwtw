package DPIT121.Insurance_Policies1;

import java.io.Serializable;



public class Address implements Serializable
{
    //attributes
    private int streetNum;
    private String streetName;
    private String suburb;
    private String city;
    
    //constructors
    //default constructor
    public Address(){}
    //constructor with parameters
    public Address(int streetNum,String streetName,String suburb,String city) 
    {
        this.streetNum=streetNum;
        this.streetName=streetName;
        this.suburb=suburb;
        this.city=city;
    }
    
    //accessors
    public int getStreetNum()
    {
        return streetNum;
    }
    public String getStreetName()
    {
        return streetName;
    }
    public String getSuburb()
    {
        return suburb;
    }
    public String getCity()
    {
        return city;
    }
    
    //mutators
    public void setStreetNum(int streetNum)
    {
        this.streetNum=streetNum;
    }
    public void setStreetName(String streetName)
    {
        this.streetName=streetName;
    }
    public void setSuburb(String suburb)
    {
        this.suburb=suburb;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    
    //methods: print out address details
    public void printAdressDetails()
    {
        System.out.printf("%-15s%-15s%-15s%-15s%n",streetNum,streetName,suburb,city);
    }
    //return address details,convert object Address to String
    @Override
    public String toString()
    {
        return streetName+" No."+streetNum+","+suburb+","+city;
    }
    
    public String toDelimitedString()
    {
        return suburb+"|"+city+"|"+streetName+"|"+streetNum;
    }
}
