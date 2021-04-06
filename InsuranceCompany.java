package DPIT121.Insurance_Policies1;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InsuranceCompany implements Serializable
{
    //attributes
    private String name;
    private ArrayList<User> users;
    private String adminUserName;
    private String adminPassword;
    private int flatRate;
    
    //constructors
    public InsuranceCompany(){} //default
    //constructor with parameters
    public InsuranceCompany(String name,ArrayList<User> users,String adminUserName,String adminPassword,int flatRate)
    {
        this.name=name;
        this.users=users;
        this.adminUserName=adminUserName;
        this.adminPassword=adminPassword;
        this.flatRate=flatRate;
    }
    
    public User validateUser(String username, String password)
    {
        for (User user : users)
        {
            if (user.validateUser(username, password))
            {
                return user;
            }
        }
        return null;
    }
    
    //accessors
    public String getName()
    {
        return name;
    }
    public ArrayList<User> getUsers()
    {
        return users;
    }
    public String getAdminUserName()
    {
        return adminUserName;
    }
    public String getAdminPassword()
    {
        return adminPassword;
    }
    public int getFlatRate()
    {
        return flatRate;
    }
    
    //mutators
    public void setAdminPassword(String adminPassword)
    {
        this.adminPassword=adminPassword;
    }
    public void setFlatRate(int flatRate)
    {
        this.flatRate=flatRate;
    }
    
    //methods
    //returns true if username and password matches the admin login details
    public boolean validateAdmin(String username, String password)
    {
        return adminUserName.equals(username)&&adminPassword.equals(password);
    }
    //adds the user to users list if userID is unique, if not returns false
    public boolean addUser(User user)
    {
        if(findUser(user.getUserID())==null)
        {
            users.add(user);
            return true;
        }
        return false;
    }
    //creates and adds the User to users list if userID is unique, if not returns false
    public boolean addUser(String name, int userID, Address address)
    {
        User user = new User(name,userID,address);
        return addUser(user);
    }
    //finds the user with the given ID or returns null if user does not exist
    public User findUser(int userID)
    {
        for(User user:users)
        {
            if(user.getUserID()==userID)
            {
                return user;
            }
        }
        return null;
    }
    //finds the user with the given userID and adds the policy to the user, 
    //unsuccessful if userID does not exist or policy is not unique
    public boolean addPolicy (int userID, InsurancePolicy policy)
    {
        User user = findUser(userID); 
        if(user!=null&&findPolicy(userID,policy.id)==null)
        {
            return user.addPolicy(policy);
        }
        return false;
    }
    // finds the insurance policy for the given userID and returns it. Returns null 
    // if userID does not exist or policyID does not exist for the given user 
    public InsurancePolicy findPolicy (int userID ,int policyID)
    {
        User user = findUser(userID); 
        if(user!=null)
        {
            return user.findPolicy(policyID);
        }
        return null;
    }
    // prints all the policies for the given userID
    public void printPolicies(int userID)
    {
        User user = findUser(userID); 
        if(user!=null)
        {
            user.printPolicies(flatRate);
        }
        else
        {
            System.out.println("This user does not exist,please try another user id later.");
        }
    }
    //prints all the users and for each user all the policies by calling User. 
    public void print()
    {
        users.forEach((user) -> user.print(flatRate));
    }
    //coverts the whole object to string (including all the users and their policies).
    @Override
    public String toString()
    {
        String details="CompanyName:"+name+"\n"+"All the users: \n";
        details = users.stream().map((user) -> user+"\n").reduce(details, String::concat);
        return details;
    }
    //prints all the users and for each user all the discounted premiums
    public void print(double discount)
    {
        for(User user:users)
        {
            user.print(flatRate);
            user.printPremiums(flatRate, discount);
        }
    }
    // finds the user with the given userID and calls the createThirdPartyPolicy for that user. 
    // Returns false if the user does not exist or if User.createThirdPartyPolicy() returns false 
    public boolean createThirdPartyPolicy(int userID, String name, Car car, MyDate expiryDate,int numberOfClaims)
    {
        User user = findUser(userID); 
        if(user!=null)
        {
            return user.createThirdPartyPolicy(name, car, expiryDate, numberOfClaims);
        }
        return false;
    }
    // finds the user with the given userID and calls the createComprehensivePolicy for that user. 
    // Returns false if the user does not exist or if User.createComprehensivePolicy() returns false  
    public boolean createComprehensivePolicy( int userID, String name, Car car, MyDate expiryDate, int numberOfClaims, int driverAge)
    {
        User user = findUser(userID); 
        if(user!=null)
        {
            return user.createComprehensivePolicy(name, car, expiryDate, numberOfClaims, driverAge);
        }
        return false;
    }
    // returns the total premiums for the given user
    public double calcTotalPremiums (int userID)
    {
        User user = findUser(userID); 
        if(user!=null)
        {
            return user.calcTotalPremiums(flatRate);
        }
        return -1;
    }
    
    // returns a list of all the policies in the company across all users
    public ArrayList<InsurancePolicy> allPolicies ()
    {
        ArrayList<InsurancePolicy> allpolicies = new ArrayList<>();
        users.forEach((user) -> {
            user.getPolicies()
            .forEach((policy) -> allpolicies.add(policy));
        });
        return allpolicies;
    }
    // calls filterByCarModel for the given user
    public ArrayList<InsurancePolicy> filterByCarModel (int userID, String carModel)
    {
        User user = findUser(userID);
        if(user!=null)
        {
            return user.filterByCarModel(carModel);
        }
        return null;
    }
    // calls filterByExpiryDate for the given user
    public ArrayList<InsurancePolicy> filterByExpiryDate (int userID, MyDate date) 
    {
        User user = findUser(userID);
        if(user!=null)
        {
            return user.filterByExpiryDate(date);
        }
        return null;
    }
    
    // filters all the policies in the company by ExpiryDate across all users
    public ArrayList<InsurancePolicy> filterByExpiryDate (MyDate date)
    {
        ArrayList<InsurancePolicy> filterbydatepolicies = new ArrayList<>();
        users.forEach((user) -> {
            user.filterByExpiryDate(date).forEach((policy) -> filterbydatepolicies.add(policy));
        });
        return filterbydatepolicies;
    }
    
    /*methods for data aggregation
    goes through all the users and populate a list of distinct city names for all users and returns it as a list.*/
    public ArrayList<String> populateDistinctCityNames()
    {
        ArrayList<String> cities = new ArrayList<>();
        for(User user:users)
        {   
            boolean isExist=false;
            String cityName=user.getCity();
            for(String city:cities)
            {
                if(cityName.equalsIgnoreCase(city))
                {
                    isExist=true;
                    break;
                }
            }
            if(!isExist==true)
            {
                cities.add(cityName);
            }
        }
        return cities;
    }
    //returns the total premiums for the given city across all users.
    public double getTotalPremiumForCity(String city)
    {
        double totalPremium=0;
        totalPremium = users.stream().filter((user) -> (user.getCity().equals(city))).map((user) -> user.calcTotalPremiums(flatRate)).reduce(totalPremium, (u1, u2) -> u1 + u2);
        return totalPremium;
    }
    //aggregates the total premiums for each city in the list and returns it as a double list with the same order as city names. 
    //This method calls getTotalPremiumForCity (String city)  
    public ArrayList<Double> getTotalPremiumPerCity(ArrayList<String> cities)
    {
        ArrayList<Double> totalPremiumAllCities=new ArrayList<>();
        cities.forEach((city) -> totalPremiumAllCities.add(getTotalPremiumForCity(city)));
        return totalPremiumAllCities;
    }
    //generates the report
    public void reportPremiumsPerCity(ArrayList<String> cities, ArrayList<Double> premiums)
    {
        System.out.printf("%-15s%-15s%n","City Name","Total Premium");
        for(int i=0;i<cities.size();i++)
        {
            System.out.printf("%-15s%-15s%n",cities.get(i),premiums.get(i));
        }
    }
    
    //methods for advanced data aggregation
    //remove a policy from a list of policies of a given user
    public boolean deletePolicy(int userId,int policyId)
    {
        User user = findUser(userId);
        if(user!=null)
        {
            return user.deletePolicy(policyId);
        }
        return false;
    }
    //method for removing a user
    public boolean deleteUser(int userId)
    {
        User user = findUser(userId);
        if(user!=null)
        {
            users.remove(user);
            return true;
        }
        return false;
    }
    //method for changing admin password
    public void changePassword(String newPwd)
    {
        this.adminPassword=newPwd;
    }
    
    //methods for advanced data aggregation
    //goes through all the users within the IsnuranceCompany and populates a list of distinct car models. 
    //You need to call the corresponding method inside the User and aggregate them for all the users  
    public ArrayList<String> populateDistinctCarModels() 
    { 
        ArrayList<String> carModelsAllUsers = new ArrayList<>();
        for(User user:users)
        {
           for(String carModel:user.populateDistinctCarModels())
           {
              boolean isExist=false;
              for(String carModelAllUser:carModelsAllUsers)
              {
                  if(carModelAllUser.equalsIgnoreCase(carModel))
                  {
                      isExist=true;
                      break;
                  }
              }
              if(!isExist)
              {
                  carModelsAllUsers.add(carModel);
              }
           }
        }
        return carModelsAllUsers;
    }
    //returns the count for each model across all the users.
    public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels) 
    {
        ArrayList<Integer> counts = new ArrayList<>();
        carModels.forEach((carModel) -> counts.add(filterByCarModel(carModel).size()));
        return counts;
    }
    //*optional: returns the count for each model across all the users. (including both policies)
    public ArrayList<Count> getTotalAverageCountPerCarModel (ArrayList<String> carModels) 
    {
        ArrayList<Count> counts = new ArrayList<>();
        carModels.forEach((carModel) -> {
            int thirdParty=0;
            int comprehensive=0;
            for(User user:users)
            {
                thirdParty+=user.getAverageCountForCarModel(carModel).getThirdPartyCount();
                comprehensive+=user.getAverageCountForCarModel(carModel).getComprehensiveCount();
            }
            counts.add(new Count(thirdParty,comprehensive));
        });
        return counts;
    }
    //the same as the previous one but for total premium  
    public ArrayList<Double> getTotalPremiumPerCarModel (ArrayList<String> carModels) 
    {
        ArrayList<Double> totalPremiums = new ArrayList<>();
        carModels.forEach((carModel) -> totalPremiums.add(InsurancePolicy.calcTotalPremiums(filterByCarModel(carModel),flatRate)));
        return totalPremiums;
    }
    //the same as the previous one but for total discounted premium  
    public ArrayList<Double> getTotalDiscountedPremiumPerCarModel (ArrayList<String> carModels,double discount) 
    {
        ArrayList<Double> totalDiscountedPremiums = new ArrayList<>();
        carModels.forEach((carModel) -> totalDiscountedPremiums.add(InsurancePolicy.calcTotalDiscountedPremiums(filterByCarModel(carModel), flatRate, discount)));
        return totalDiscountedPremiums;
    }
    //the same as the previous one but for third party premium  
    public ArrayList<Double> getTotalThirdPartyPremiumPerCarModel (ArrayList<String> carModels) 
    {
        ArrayList<Double> totalThirdPartyPremiums = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            double totalThirdPartyPermium=0;
            for(User user:users)
            {
                totalThirdPartyPermium+=user.getTotalThirdPartyPremiumForCarModel(carModel, flatRate);
            }
            totalThirdPartyPremiums.add(totalThirdPartyPermium);
        }
        return totalThirdPartyPremiums;
    }
    //the same as the previous one but for comprehensive premium  
    public ArrayList<Double> getTotalComprehensivePremiumPerCarModel (ArrayList<String> carModels) 
    {
        ArrayList<Double> totalComprehensivePremiums = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            double totalComprehensivePermium=0;
            for(User user:users)
            {
                totalComprehensivePermium+=user.getTotalComprehensivePremiumForCarModel(carModel, flatRate);
            }
            totalComprehensivePremiums.add(totalComprehensivePermium);
        }
        return totalComprehensivePremiums;
    }
    //to generate the same report as before but across all users in the system
    public static void reportPremiumsPerCarModel (ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> totalPremiums, ArrayList<Double> totalDiscountedPremiums)
    {
        User.reportPremiumsPerCarModel(carModels, counts, totalPremiums, totalDiscountedPremiums);
    }
    //*optional: to generate the same report as before but across all users in the system(including both policies) 
    public static void reportAveragePremiumsPerCarModel (ArrayList<String> carModels, ArrayList<Count> counts, ArrayList<Double> thirdPartyPremiums, ArrayList<Double> comprehensivePremiums)   
    {
        User.reportAveragePremiumsPerCarModel(carModels,counts,thirdPartyPremiums,comprehensivePremiums);
    }
    
    //serialization
    
    public void save() throws IOException
    {
        ObjectOutputStream outputSt = new ObjectOutputStream(Files.newOutputStream(Paths.get("companyFile")));
        outputSt.writeObject(this);
        outputSt.close();
    }
    
    public static InsuranceCompany load() throws IOException, ClassNotFoundException
    {
        ObjectInputStream inputSt = new ObjectInputStream(Files.newInputStream(Paths.get("companyFile")));
        InsuranceCompany company = (InsuranceCompany) inputSt.readObject();
        inputSt.close();
        return company;
    }
    
    //Lamda
    
    // returns the total premiums for all the users
    public double calcTotalPremiums ()
    {
//        double allUserTotalPremium=0;
//        for(User user:users)
//        {
//            allUserTotalPremium+=user.calcTotalPremiums(flatRate);
//        }
        
        
        return users.stream().map((u) -> u.calcTotalPremiums(flatRate)).reduce(0.0, (x,y) -> (x+y));  //it took me 10min to figure out why 0 was errot so shifted to 0.0
    }
    
    
    // filters all the policies in the company by carModel across all users
    public ArrayList<InsurancePolicy> filterByCarModel (String carModel)
    {
        ArrayList<InsurancePolicy> policies = new ArrayList<>();
//        for(User user:users)
//        {
//           for(InsurancePolicy policy:user.filterByCarModel(carModel))
//           {
//               filterbycarpolicies.add(policy);
//           }
//        }
        
        
       users.stream().map(u -> policies.addAll(u.getPolicies().stream().filter(p -> p.getCarModel().contains(carModel)).collect(Collectors.toList())));
       
       
       return policies;
    }
    
    public boolean saveTextFile (String fName) throws IOException 
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
            out.write (this.toDelimitedString ());
            for (User user : users)
            {
                out.write ("|"+user.getName()); //saving user ids so they can be accesed from different file
            }
            out.write ("\n"); //new line if there is another company in future
            User.saveTextFile(users, "users"+fName); //saving users in differnt file.
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
        return name+ "|" + adminUserName+ "|" + adminPassword+ "|" + flatRate;
    }
}
