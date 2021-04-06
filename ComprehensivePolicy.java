package DPIT121.Insurance_Policies1;



public class ComprehensivePolicy extends InsurancePolicy
{
    //its own attributes
    protected int driverAge;
    public ComprehensivePolicy(){} //default
    //constructor with parameters
    public ComprehensivePolicy(String policyHolderName,Car car,MyDate expiryDate,int numberOfClaims, int driverAge)
    {
        super(policyHolderName,car,expiryDate,numberOfClaims);
        this.driverAge=driverAge;
    }
    
    //methods
    //calculate premium
    @Override
    public double calcPremium(int flatRate)
    {
        double premium=super.calcPremium(flatRate)+car.getPrice()/50;
        if(driverAge<30)
        {
            return premium+(30-driverAge)*50;
        }
        return premium;
    }
    //override print and toString
    //print out details
    @Override
    public void print(int flatRate)
    {
        super.print(flatRate);
        System.out.printf("%-15s",driverAge);
    }
    //convert object to String
    @Override
    public String toString()
    {
        return super.toString()+" Driver Age:"+driverAge;
    }
}
