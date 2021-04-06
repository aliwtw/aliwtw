package DPIT121.Insurance_Policies1;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InsurancePolicy implements Serializable,Comparable<InsurancePolicy>, Cloneable
{
    //attributes
    protected String policyHolderName;
    protected int id;
    protected Car car;
    protected MyDate expiryDate;
    protected int numberOfClaims;
    private static int baseId = 0;
    
    //constructors
    public InsurancePolicy(){} //default
    //constructor with parameters
    public InsurancePolicy(String policyHolderName,Car car,MyDate expiryDate,int numberOfClaims) 
    {
        this.policyHolderName=policyHolderName;
        id=baseId++;
        this.car=car;
        this.expiryDate=expiryDate;
        this.numberOfClaims=numberOfClaims;
    }
    
    
     public InsurancePolicy clone() throws CloneNotSupportedException
    {
        InsurancePolicy policy = (InsurancePolicy) super.clone();
        policy.expiryDate = expiryDate.clone();
        policy.car = car.clone();
        return policy;
    }
    
    public double calcPremium(int flatRate)
    {
        return numberOfClaims*200+flatRate;
    }
    //calculate premium with discount rate
    public double calcDiscountedPremium(int flatRate,double discount)  
    {
        return calcPremium(flatRate)*discount;
    }
    //prints all the information including the premium 
    public void print(int flatRate)
    {
        System.out.printf("%n%-10s%-20s%-20s%-15s%-15s%-15s",id,policyHolderName,numberOfClaims,car,expiryDate,calcPremium(flatRate));
    }
    //converts the object to string
    @Override
    public String toString()
    {
        return "id:"+id+" PolicyHolder Name:"+policyHolderName+" Number of Claims:"+numberOfClaims+" Car :"+car+" Expire Date:"+expiryDate+"\n";
    }
    //prints only the calculated premium with user friendly prompts
    public void printPremium(int flatRate)
    {
        System.out.printf("%-15s",calcPremium(flatRate));
    }
    //prints only the calculated discount premium with user friendly prompts
    public void printDiscountedPremium(int flatRate,double discount)
    {
        System.out.printf("%-20s",calcDiscountedPremium(flatRate,discount));
    }
    
    //returns the total premium of policies
    public static double calcTotalPremiums (ArrayList<InsurancePolicy> policies, int flatRate)
    {
        double totalPremium=0;
        for(InsurancePolicy policy:policies)
        {
            totalPremium+=policy.calcPremium(flatRate);
        }
        return totalPremium;
    }
    //returns the total amount of discount premium
    public static double calcTotalDiscountedPremiums (ArrayList<InsurancePolicy> policies, int flatRate, double discount)
    {
        double totalDiscountPremium=0;
        totalDiscountPremium = policies.stream().map((policy) -> policy.calcDiscountedPremium(flatRate, discount)).reduce(totalDiscountPremium, (p1, _p2) -> p1 + _p2);
        return totalDiscountPremium;
    }
    //filter insurance policies by car model
    public static ArrayList<InsurancePolicy> filterByCarModel (ArrayList<InsurancePolicy> policies, String carModel)
    {
        ArrayList<InsurancePolicy> filterByCarPolicies = new ArrayList<>();
        policies.stream().filter((policy) -> (policy.car.getModel().contains(carModel))).forEachOrdered((policy) -> {
            filterByCarPolicies.add(policy);
        });
        return filterByCarPolicies;
    }
    //filter insurance policies by expire date

    
    public String getCarModel()
    {
        return car.getModel();
    }
    
    public void carPriceRise(double risePercent)
    {
        car.setPrice(risePercent*car.getPrice());
    }
    
    public void update(Car car,MyDate expiryDate,int numberOfClaims)
    {
        this.car=car;
        this.expiryDate=expiryDate;
        this.numberOfClaims=numberOfClaims;
    }
    
    public int compareTo(InsurancePolicy policy) // based on premium
    {
          
        String policy1 = car.getModel();
        String policy2 = policy.car.getModel();
        
        return policy1.compareTo(policy2);
    }
    
    //filling
    
    public static boolean saveTextFile (ArrayList<InsurancePolicy> policies, String fName) throws IOException 
    {
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter (new FileWriter (fName));
        }
        catch(IOException ex)
        {
            System.err.println("error in create/open the file ");
            return false;
        }
        try
        {
            for (InsurancePolicy policy : policies)
            {
                out.write (policy.toDelimitedString () + "\n");
            }
        }
        catch(Exception ex)
        {
            System.err.println("error in add object to the file ");
            System.exit(1);
        }
        try
        {
            out.close();
        }
        catch(IOException ex)
        {
            System.err.println("error in close the file ");
            return false;
        }
        return true;
    }
    
    public String toDelimitedString()
    {
        return id+ "|" + numberOfClaims + "|" +car.toDelimitedString()+ "|" +expiryDate.toDelimitedString();
    }
    
    //Lambda
    
    public static ArrayList<InsurancePolicy> filterByExpiryDate (ArrayList<InsurancePolicy> policies, MyDate date)
    {
//        ArrayList<InsurancePolicy> filterByDatePolicies = new ArrayList<InsurancePolicy>();
//        for(InsurancePolicy policy:policies)
//        {
//            if(policy.expiryDate.isExpire(date))
//            {
//                filterByDatePolicies.add(policy);
//            }
//        }
        
        
    return (ArrayList<InsurancePolicy>) policies.stream().filter((x) -> (x.expiryDate.isExpire(date)) ).collect(Collectors.toList());
    
    // (ArrayList<InsurancePolicy>) policies.stream().filter((x) -> (x.expiryDate.isExpire(date)) ).map(x -> policies.add(x)); maping could also be used
    }
    
    //prints a list of policies
    public static void printPolicies(ArrayList<InsurancePolicy> policies,int flatRate)
    {
        System.out.printf("%-10s%-20s%-20s%-15s%-15s%-15s%-15s","id","Policy Holder Name","Number of Claims","Car Model","Expire Date","Premium","Driver Age");
//        for(InsurancePolicy policy:policies)
//        {
//            policy.print(flatRate);
//        }
//        
        policies.forEach((x) -> x.print(flatRate));
        System.out.printf("%n%n");
    }
    
    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent)
    {
//        for(InsurancePolicy policy : policies)
//        {
//            policy.carPriceRise(risePercent);
//        }
        
        policies.stream().forEach(p -> p.carPriceRise(risePercent));
    }
    
        public static ArrayList< InsurancePolicy > shallowCopy(ArrayList< InsurancePolicy> policies)
    {
//        ArrayList< InsurancePolicy > shallowCopy = new ArrayList<>();
//        for (InsurancePolicy policy : policies)
//        {
//            shallowCopy.add(policy);
//        }
        
        return (ArrayList< InsurancePolicy >) policies.stream().collect(Collectors.toList());
    }
    
    public static ArrayList< InsurancePolicy> deepCopy(ArrayList< InsurancePolicy> policies) throws CloneNotSupportedException
    {
        ArrayList< InsurancePolicy > deepCopy = new ArrayList<>();
//        for (InsurancePolicy policy : policies)
//        {
//            deepCopy.add(policy.clone());
//        }
        
        policies.stream().forEach(p -> {
            try {
                deepCopy.add(p.clone());
            } catch (Exception e) {
                //not sure what to return
            }
        });
        
        return deepCopy;
    }
    
    
}
