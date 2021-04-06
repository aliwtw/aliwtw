package DPIT121.Insurance_Policies1;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable, Comparable<User>
{
    //attributes
    private String name;
    private String password;
    private int userID;
    private Address address;
    private ArrayList<InsurancePolicy> policies;
    private static int baseId = 0;
    
    //constructors
    public User() //default
    {
        setUserId();
    }
    {
        setUserId();
        policies=new ArrayList<>();
        address = new Address();
        password = "123";
    }
    //constructor with all the parameters
    public User(String name,Address address,ArrayList<InsurancePolicy> policies) 
    {
        this.name=name;
        setUserId();
        this.address=address;
        this.policies=policies;
         password = "123";
    }
    //constructor with three parameters
    public User(String name,int userId,Address address) 
    {
        this.name=name;
        this.userID=userId;
        this.address=address;
        policies=new ArrayList<>();
         password = "123";
    }
    
    public boolean validateUser(String username, String password)
    {
        if (username.equals(this.name) && password.equals(this.password))
        {
            return true;
        }
        return false;
    }
    
    //accessors
    public String getName()
    {
        return name;
    }
    public int getUserID()
    {
        return userID;
    }
    public Address getAddress()
    {
        return address;
    }
    public ArrayList<InsurancePolicy> getPolicies()
    {
        return policies;
    }


    public String getPass()
    {
        return password;
    }
    //mutators
    public void setName(String name)
    {
        this.name=name;
    }
    public void setAddress(Address address)
    {
        this.address=address;
    }
    
    //others methods for accessing attributes from related classes
    public void setStreetNum(int streetNum)
    {
        address.setStreetNum(streetNum);
    }
    public void setStreetName(String streetName)
    {
        address.setStreetName(streetName);
    }
    public void setSuburb(String suburb)
    {
        address.setSuburb(suburb);
    }
    public void setCity(String city)
    {
        address.setCity(city);
    }
    
    //methods
    //adds a policy, successful if policyID is unique
    public boolean addPolicy (InsurancePolicy policy)
    {
        if(findPolicy(policy.id)==null)
        {
            policies.add(policy);
            return true;
        }
        return false;
    }
    //finds the policy and returns it. Returns null if policyID does not exist;
    public InsurancePolicy findPolicy (int policyID)
    {
        for(InsurancePolicy existPolicy:policies)
        {
            if(policyID==existPolicy.id)
            {
                return existPolicy; 
            }
        }
        return null;
    }
    // prints all the information for this user including the policies
    public void print(int flatRate)
    {
        System.out.println("---------------------------------------------------------------");
        System.out.println("---Details of user "+name+"---");
        System.out.printf("%-15s%-10s%-35s%n","Name","User ID","Address");
        System.out.printf("%-15s%-10s%-35s%n",name,userID,address);
        printPolicies(flatRate);
        System.out.println("---------------------------------------------------------------");
    }
    // converts the user and his policies to String 
    @Override
    public String toString()
    {
        String details="username:"+name+" userid:"+userID+" address:"+address+"\n"+"policies: \n";
        for(InsurancePolicy policy:policies)
        {
            details+=policy+"\n";
        }
        return details;
    }
    // prints all the premiums this user owns by calling the corresponding static method inside InsurancePolicy
    public void printPremiums(int flatRate)
    {
        System.out.println("---All the premiums "+name+" owns---");
        System.out.printf("%-15s%n","Premiums");
        for(InsurancePolicy policy:policies)
        {
            policy.printPremium(flatRate);
            System.out.printf("%n");
        }
        System.out.println("The total premium "+name+" owns is: "+InsurancePolicy.calcTotalPremiums(policies, flatRate)+"\n");
    }
    // prints the discounted premiums for all the premiums this user owns by calling 
    // the corresponding static method inside InsurancePolicy
    public void printPremiums(int flatRate,double discount)
    {
        System.out.println("---All the discounted premiums "+name+" owns---");
        System.out.printf("%-20s%n","DiscPremiums");
        for(InsurancePolicy policy:policies)
        {
            policy.printDiscountedPremium(flatRate, discount);
            System.out.printf("%n");
        }
        System.out.println("The total discounted premium this user owns is: "+InsurancePolicy.calcTotalDiscountedPremiums(policies, flatRate, discount)+"\n---------------------------------------------------------------\n");
    }
    
    // creates a third party policy and adds it to the list of polices, returns false if the id is not unique 
    public boolean createThirdPartyPolicy(String name, Car car, MyDate expiryDate, int numberOfClaims) 
    {
          ThirdPartyPolicy thirdpartypolicy = new ThirdPartyPolicy(name,car,expiryDate,numberOfClaims);
          return addPolicy(thirdpartypolicy);
    }
    // creates a comprehensive policy and adds it to the list of polices, returns false if the id is not unique 
    public boolean createComprehensivePolicy(String name, Car car, MyDate expiryDate, int numberOfClaims, int driverAge) 
    {
         ComprehensivePolicy comprehensivepolicy = new ComprehensivePolicy(name,car,expiryDate,numberOfClaims,driverAge);
         return addPolicy(comprehensivepolicy);
    }
    // returns the total premiums for this user by calling the corresponding static method inside InsurancePolicy   
    public double calcTotalPremiums (int flatRate)
    {
        return InsurancePolicy.calcTotalPremiums(policies, flatRate);
    }
    // filters the policies and returns a list of policies with the car model containing the given 
    // car model by calling the corresponding static method inside InsurancePolicy  
    public ArrayList<InsurancePolicy> filterByCarModel (String carModel)
    {
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }
    // filters the policies and returns a list of policies with the expiry date before the given 
    // date by calling the corresponding static method inside InsurancePolicy  
    public ArrayList<InsurancePolicy> filterByExpiryDate (MyDate date) 
    {
        return InsurancePolicy.filterByExpiryDate(policies, date);
    }
    //get the city name of the user's address line
    public String getCity()
    {
        return address.getCity();
    }
    
    //methods for advanced user control
    //remove a policy from a list of policies
    public boolean deletePolicy(int PolicyId)
    {
        InsurancePolicy policy = findPolicy(PolicyId);
        if(policy!=null)
        {
            policies.remove(policy);
            return true;
        }
        return false;
    }
    //automatically generate user id(incrementally)
    private void setUserId()
    {
        this.userID=baseId;
        baseId++;
    }
    
    //methods for advanced data aggregation
    //goes through all the policies for a user and populates a list of distinct car model names  
    public ArrayList<String> populateDistinctCarModels()
    {
        ArrayList<String> carModels = new ArrayList<String>();
        for(InsurancePolicy policy:policies)
        {
           boolean isExist=false;
           for(String carModel:carModels)
           {
               if(carModel.equalsIgnoreCase(policy.getCarModel()))
               {
                   isExist=true;
                   break;
               }
           }
           if(!isExist)
           {
               carModels.add(policy.getCarModel());
           }
        }
        return carModels;
    }
    //get total premiums for the given carModel
    public double getTotalPremiumForCarModel(String carModel,int flatRate)
    {
        return InsurancePolicy.calcTotalPremiums (filterByCarModel(carModel),flatRate);
    }
    //get total discounted premiums for the given carModel
    public double getTotalDiscountedPremiumForCarModel(String carModel,int flatRate,double discount)
    {
        return InsurancePolicy.calcTotalDiscountedPremiums(filterByCarModel(carModel),flatRate,discount);
    }
    //returns the number of policies this user owns for the given carModel
    public int getTotalCountForCarModel(String carModel) 
    {
        return filterByCarModel(carModel).size();
    }
    //*optional: returns the number of two different policies this user owns for the given carModel
    public Count getAverageCountForCarModel(String carModel)
    {
        
        int thirdParyPolicy=0;
        int comprehensivePolicy=0;
        for(InsurancePolicy policy:filterByCarModel(carModel))
        {
            if(policy instanceof ThirdPartyPolicy)
            {
                thirdParyPolicy++;
            }
            if(policy instanceof ComprehensivePolicy)
            {
                comprehensivePolicy++;
            }
        }
        return new Count(thirdParyPolicy,comprehensivePolicy);
    }
    //returns the total third party premiums for the given carModel across all the policies this user owns  
    public double getTotalThirdPartyPremiumForCarModel(String carModel,int flatRate) 
    {
        double totalThirdPartyPermiums=0;
        for(InsurancePolicy policy:filterByCarModel(carModel))
        {
            if(policy instanceof ThirdPartyPolicy)
            {
                totalThirdPartyPermiums+=policy.calcPremium(flatRate);
            }
        }
        return totalThirdPartyPermiums;
    }
    //returns the total comprehensive premiums for the given carModel across all the policies this user owns.
    public double getTotalComprehensivePremiumForCarModel(String carModel,int flatRate) 
    {
        double totalComprehensivePermiums=0;
        for(InsurancePolicy policy:filterByCarModel(carModel))
        {
            if(policy instanceof ComprehensivePolicy)
            {
                totalComprehensivePermiums+=policy.calcPremium(flatRate);
            }
        }
        return totalComprehensivePermiums;
    }
    //returns the total count for each model in the carModels as a list of integers.
    public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels)
    {
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for(String carModel:carModels)
        {
            counts.add(getTotalCountForCarModel(carModel));
        }
        return counts;
    }
    //*optional: returns the total count for each model in the carModels as a list of integers (across both policies)
    public ArrayList<Count> getAverageCountPerCarModel (ArrayList<String> carModels) 
    {
        ArrayList<Count> counts = new ArrayList<Count>();
        for(String carModel:carModels)
        {
            counts.add(getAverageCountForCarModel(carModel));
        }
        return counts;
    } 
    //returns the TotalPremium for each model in the carModels as a list of doubles.
    public ArrayList<Double> getTotalPremiumPerCarModel (ArrayList<String> carModels,int flatRate)
    {
        ArrayList<Double> totalPremiums = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            totalPremiums.add(getTotalPremiumForCarModel(carModel,flatRate));
        }
        return totalPremiums;
    }
     //returns the TotalDiscountedPremium for each model in the carModels as a list of doubles.
    public ArrayList<Double> getTotalDiscountedPremiumPerCarModel (ArrayList<String> carModels,int flatRate,double discount)
    {
        ArrayList<Double> totalDiscountedPremiums = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            totalDiscountedPremiums.add(getTotalDiscountedPremiumForCarModel(carModel,flatRate,discount));
        }
        return totalDiscountedPremiums;
    }
    //returns the TotalThirdPartyPremium for each model in the carModels as a list of doubles. 
    //call getTotalThirdPartyPremiumForCarModel(String carModel) in a loop for each carModel in the list.  
    public ArrayList<Double> getTotalThirdPartyPremiumPerCarModel (ArrayList<String> carModels,int flatRate)
    {
        ArrayList<Double> totalThirdPartyPremiums = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            totalThirdPartyPremiums.add(getTotalThirdPartyPremiumForCarModel(carModel,flatRate));
        }
        return totalThirdPartyPremiums;
    }
    //the same as the previous one but for comprehensive premium  
    public ArrayList<Double> getTotalComprehensivePremiumPerCarModel (ArrayList<String> carModels,int flatRate) 
    {
        ArrayList<Double> totalComprehensivePremiums = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            totalComprehensivePremiums.add(getTotalComprehensivePremiumForCarModel(carModel,flatRate));
        }
        return totalComprehensivePremiums;
    }
    //generates the report
    public static void reportPremiumsPerCarModel (ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> totalPremiums, ArrayList<Double> totalDiscountedPremiums)
    {
        System.out.printf("%-15s%-30s%-30s%-30s%-30s%n","Car Model","Total Premium","Average Premium","Total Discounted Premium","Average Discounted Premium");
        for(int i=0;i<carModels.size();i++)
        {
            double totalPremium = totalPremiums.get(i);
            double totalDiscountedPremium = totalDiscountedPremiums.get(i);
            System.out.printf("%-15s%-30s%-30s%-30s%-30s%n",carModels.get(i),totalPremium,totalPremium/counts.get(i),totalDiscountedPremium,totalDiscountedPremium/counts.get(i));
        }
        System.out.println("------------------------------------");
    }
    //*optional: generates the report (including the average for both policies)
    public static void reportAveragePremiumsPerCarModel (ArrayList<String> carModels, ArrayList<Count> counts, ArrayList<Double> thirdPartyPremiums, ArrayList<Double> comprehensivePremiums)
    {
        System.out.printf("%-15s%-30s%-30s%-30s%-30s%n","Car Model","Total ThirdParty Premium","Average ThirdParty Premium","Total Comprehensive Premium","Average Comprehensive Premium");
        for(int i=0;i<carModels.size();i++)
        {
            double thirdPartyPremium = thirdPartyPremiums.get(i);
            double comprehensivePremium = comprehensivePremiums.get(i);
            System.out.printf("%-15s%-30s%-30s%-30s%-30s%n",carModels.get(i),thirdPartyPremium,(int)(thirdPartyPremium/counts.get(i).getThirdPartyCount()),comprehensivePremium,(int)(comprehensivePremium/counts.get(i).getComprehensiveCount()));
        }
        System.out.println("------------------------------------");
    }
    
    public void setPass(String password)
    {
        this.password=password;
    }
    
        public int compareTo(User user) // based on premium
    {
          
        String user1 = name;
        String user2 = user.getName();
        
        return user1.compareTo(user2);
    }
        
    public int compareTo1(User user) // based on premium
    {
          
        double user1 = this.calcTotalPremiums(1);
        double user2 = user.calcTotalPremiums(1);
        
        return Double.compare(user1,user2);
    }
        
    //filing
        public String toDelimitedString()
    {
       String value = "";
       value = userID +"|"+ name+"|"+address.toDelimitedString();
       for (InsurancePolicy policy : policies)
       {
           value += ("|" + policy.toDelimitedString());
       }
       return value;
    }
    
    public static boolean saveTextFile (ArrayList<User> users, String fName) throws IOException 
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
            for (User user : users)
            {
                out.write (user.toDelimitedString () + "\n");
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
        
    //Lambda
    
    //prints all the policies for this user by calling the corresponding static method inside InsurancePolicy
    public void printPolicies(int flatRate)
    {
        System.out.println("---All the policies "+name+" owns---");
        InsurancePolicy.printPolicies(policies,flatRate);
        
        //already done in insurance policies but if we want it here than
        
        //policies.forEach((x) -> x.print(flatRate));
        System.out.println("--------------------------------");
    }
}
