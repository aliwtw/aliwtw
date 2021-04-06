package DPIT121.Insurance_Policies1;

import java.io.Serializable;



public class MyDate implements Serializable
{
    //attributes
    private int year;
    private int month;
    private int day;
    
    public MyDate clone() throws CloneNotSupportedException
    {
        
        return (MyDate) super.clone();
    }
    
    //constructors
    public MyDate(){} //default constructor
    public MyDate(int year,int month,int day) //constructor with parameters
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    
    //accessors
    public int getYear()
    {
        return year;
    }
    public int getMonth()
    {
        return month;
    }
    public int getDay()
    {
        return day;
    }
    
    //mutators
    public void setYear(int year)
    {
        this.year=year;
    }
    public void setMonth(int month)
    {
        this.month=month;
    }
    public void setDay(int day)
    {
        this.day=day;
    }
    
    //methods: print date details
    public void printDateDetails()
    {
        System.out.printf("%-2s/%-2s/%-4s%n",month,day,year);
    }
    //return date and convert the object to string
    @Override
    public String toString()
    {
        return month+"/"+day+"/"+year;
    }
    //separate a string into year,month and day;
    public void setDate(String date)
    {
        year = Integer.parseInt(date.substring(0,4));
        month = Integer.parseInt(date.substring(5,7));
        day = Integer.parseInt(date.substring(8,10));
    }
    //method for checking if it is expired or not;
    public boolean isExpire(MyDate date)
    {
        if(year<date.year)
        {
            return true;
        }
        else if(year==date.year&&month<date.month)
        {
            return true;
        }
        else if(year==date.year&&month==date.month&&day<date.day)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
     public String toDelimitedString()
    {
        return day+"|"+month+"|"+year;
    }
     
}
