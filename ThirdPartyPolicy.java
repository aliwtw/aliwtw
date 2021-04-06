package DPIT121.Insurance_Policies1;



public class ThirdPartyPolicy extends InsurancePolicy
{
    public ThirdPartyPolicy(){} //default
    //constructor with parameters
    public ThirdPartyPolicy(String policyHolderName,Car car,MyDate expiryDate,int numberOfClaims)
    {
        super(policyHolderName,car,expiryDate,numberOfClaims);
    }
    
    //methods
    //calculate premium
    @Override
    public double calcPremium(int flatRate)
    {
        return super.calcPremium(flatRate)+car.getPrice()/100;
    }
}
