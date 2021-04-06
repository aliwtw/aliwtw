package DPIT121.Insurance_Policies1;


import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface 
{        

    //method for creating a car
    private static Car createCar(Scanner input)
    {
        System.out.print("Please enter car model:");
        String carModel = input.next();
        System.out.print("Please enter manufacturing year:");
        int manufacturingYear = input.nextInt();
        System.out.print("Please enter price:");
        double price = input.nextDouble();
        System.out.println("1> Benz\n2> Jeep\n3> Audi\n4> Cadillac\n5> Porsche\n6> VOLVO\n7> Toyota\n8> Ford");
        System.out.print("Please choose one car type:");
        CarType carType = CarType.values()[input.nextInt()];
        return new Car(carModel,manufacturingYear,price,carType);
    }
    //method for creating a date
    private static MyDate createDate(Scanner input)
    {
        MyDate date = new MyDate();
        System.out.print("Please enter a date(yyyy/mm/dd):");
        date.setDate(input.next());
        return date;
    }
    //method for creating an address
    private static void createAddress(Scanner input,User user)
    {
        System.out.print("Please provide your street number:");
        user.setStreetNum(input.nextInt());
        System.out.print("Please provide your street name:");
        user.setStreetName(input.next());
        System.out.print("Please provide your suburb:");
        user.setSuburb(input.next());
        System.out.print("Please provide your city:");
        user.setCity(input.next());
    }
    //this method is for removing a policy from a given user
    public static void removePolicy(boolean isSuccess)
    {
        if(isSuccess)
        {
            System.out.println("Congratulation, remove this policy successfully!");
        }
        else
        {
            System.err.println("Fail to remove policy. Please check whether this user or the policy does exist.");
        }
    }
    //add new policies to a specific user and print out proper prompt
    public static void addPolicies(boolean isSuccess)
    {
        if(isSuccess==true)
        {
            System.out.println("Congratulation, add new policy successfully!");
        }
        else 
        {
            System.err.println("Fail to add new policy, probably due to this policy already exists or the user does not exist");
        }
    }
    //find policy for a specific user and print out proper prompt
    public static void findPolicies(User user,int policyID,InsuranceCompany insuranceCompany)
    {
        InsurancePolicy policy = user.findPolicy(policyID);
        if(policy!=null)
        {
            System.out.println("There is one policy that matches your search:");
            printPolicy(policy,insuranceCompany);
        }
        else
        {
            System.err.println("\nPolicy has not been found\n");
        }
    }
    //methods for finding a user and print out all his policies
    public static void printPoliciesForUser(int userId,InsuranceCompany insuranceCompany)
    {
        User user = insuranceCompany.findUser(userId);
        if(user!=null)
        {
            user.print(insuranceCompany.getFlatRate());
        }
        else
        {
            System.err.println("This user does not exist\n");
        }
    }
    //print out a specific policy
    public static void printPolicy(InsurancePolicy policy,InsuranceCompany insuranceCompany)
    {
        System.out.printf("%-10s%-20s%-20s%-15s%-15s%-15s%-15s","id","Policy Holder Name","Number of Claims","Car Model","Expire Date","Premium","Driver Age");
        if(policy!=null)
        {
            policy.print(insuranceCompany.getFlatRate());
            System.out.printf("%n%n");
        }
        else
        {
            System.err.println("This policy does not exist\n");
        }
        
    }
    //check if username and password are valid then print out proper prompt
    public static void checkNamePwd(boolean isValid)
    {
        if(isValid==true)
        {
            System.out.println("Login successfully!");
        }
        else
        {
            System.err.println("Invalid admin name or password");
        }
    }
    //method for changing the password(admin)
    public static void changePwd(InsuranceCompany insuranceCompany, String password)
    {
        insuranceCompany.changePassword(password);
        System.out.println("Change password successfully!\n");
    }
    //remove a user
    public static void removeUsers(boolean isSuccess)
    {
        if(isSuccess==true)
        {
            System.out.println("Remove this user successfully!");
        }
        else
        {
            System.err.println("This user does not exist, please try another user id");
        }
    }
    //add new user to the insurance company and print out the correct prompt
    public static void addUsers(boolean isSuccess)
    {
        if(isSuccess==true)
        {
            System.out.println("Congratulation, add new user successfully!");
        }
        else
        {
            System.err.println("Fail to add new user, probably due to this user id already exists");
        }
    }
    //method for adding a user
    public static void addUser(InsuranceCompany insuranceCompany)
    {
        Scanner input = new Scanner(System.in);
        User user = new User();
        System.out.print("Please provide user name:");
        user.setName(input.next());
        System.out.println("---Please provide address---");
        createAddress(input,user);
        System.out.println("Add user successfully!");
    }
    //method to find user and policy
    public static boolean findUsersPolicies(InsuranceCompany insuranceCompany,User user)
    {
        if(user==null)
        {
            System.err.println("This user does not exist");
            return false;
        }
        else
        {
            return true;
        }
    }
    //method to add third-party policy with proper prompt
    public static void addThirdPartyPolicy(InsuranceCompany insuranceCompany,int userId,Car car,MyDate date,int numOfClaims)
    {
        User user = insuranceCompany.findUser(userId);
        if(findUsersPolicies(insuranceCompany,user)==true)
        {
            insuranceCompany.createComprehensivePolicy(userId,user.getName(),car,date,numOfClaims,userId);
            System.out.println("Add new third party policy to this user successfully!");
        }
        else
        {
            System.err.println("Fail to add new third party policy, please try again later");
        }
    }
    //method to add comprehensive policy with proper prompt
    public static void addComprehensivePolicy(InsuranceCompany insuranceCompany,int userId,Car car,MyDate date,int numOfClaims,int age)
    {
        User user = insuranceCompany.findUser(userId);
        if(findUsersPolicies(insuranceCompany,user)==true)
        {
            insuranceCompany.createComprehensivePolicy(userId,user.getName(),car,date,numOfClaims,age);
            System.out.println("Add new comprehensive policy to this user successfully!");
        }
        else
        {
            System.err.println("Fail to add new comprehensive policy, please try again later");
        }
    }
    //For a given car model print the policy list
    public static void printPoliciesCarModel(InsuranceCompany insuranceCompany,String carModel)
    {
        System.out.println("All the polices that contain "+carModel+" are displayed below:");
        InsurancePolicy.printPolicies(insuranceCompany.filterByCarModel(carModel),insuranceCompany.getFlatRate());
        System.out.println();
    }
    //Provide a date and check the expired policies
    public static void expiredPolicies(InsuranceCompany insuranceCompany)
    {
        Scanner input = new Scanner(System.in);
        MyDate date = new MyDate();
        System.out.print("Please enter a date(yyyy/mm/dd):");
        date.setDate(input.next());
        System.out.println("The expired policies are displayed below:");
        InsurancePolicy.printPolicies(insuranceCompany.filterByExpiryDate(date),insuranceCompany.getFlatRate());
        System.out.println();
    }
    //method for changing address
    public static void changeAddress(User user)
    {
        if(user!=null)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("***Update your address***");
            createAddress(input,user);
            System.out.println("Your address has been updated successfully!");
            System.out.println();
        }
        else
        {
            System.err.println("Error: Cannot find the user");
        }
    }
    //Generate the report of premiums per city
    public static void reportPremiumsPerCity(InsuranceCompany insuranceCompany)
    {
        ArrayList<String> cities = insuranceCompany.populateDistinctCityNames();
        insuranceCompany.reportPremiumsPerCity(cities,insuranceCompany.getTotalPremiumPerCity(cities));
        System.out.println();
    }
    //this method for printing total premiums and average premiums per carModel for one user
    public static void printPremiumsPerCarModel(User user,int flatRate)
    {
        if(user!=null)
        {
            System.out.println("----Report of the Total Premiums Per Car Model For "+user.getName()+"----");
            ArrayList<String> carModels = user.populateDistinctCarModels();
            ArrayList<Integer> counts = user.getTotalCountPerCarModel(carModels);
            ArrayList<Double> totalPremiums = user.getTotalPremiumPerCarModel(carModels,flatRate);
            ArrayList<Double> totalDiscountedPremiums = user.getTotalDiscountedPremiumPerCarModel(carModels,flatRate,0.92);
            User.reportPremiumsPerCarModel(carModels, counts, totalPremiums, totalDiscountedPremiums);
            System.out.println();
        }
        else
        {
            System.err.println("This user doesn't exist, please try another one");
        }
    }
    //this method for printing total premiums and average premiums per carModel for all the users
    public static void printPremiumsPerCarModelAllUsers(InsuranceCompany insuranceCompany)
    {
        System.out.println("----Report of the Total Premiums Per Car Model For All Users----");
        ArrayList<String> carModelsAllUsers = insuranceCompany.populateDistinctCarModels();
        ArrayList<Integer> counts = insuranceCompany.getTotalCountPerCarModel(carModelsAllUsers);
        ArrayList<Double> totalPremiums = insuranceCompany.getTotalPremiumPerCarModel(carModelsAllUsers);
        ArrayList<Double> totalDiscountedPremiums = insuranceCompany.getTotalDiscountedPremiumPerCarModel(carModelsAllUsers,0.95);
        InsuranceCompany.reportPremiumsPerCarModel(carModelsAllUsers, counts, totalPremiums, totalDiscountedPremiums);
        System.out.println();
    }
    //*optional: this method for printing total premiums and average premiums(including both policies) per carModel for one user
    public static void printAveragePremiumsPerCarModel(User user,int flatRate)
    {
        System.out.println("----Report of the Total Premiums Per Type of Policy Per Car Model For "+user.getName()+"----");
        ArrayList<String> carModels = user.populateDistinctCarModels();
        ArrayList<Count> counts = user.getAverageCountPerCarModel(carModels);
        ArrayList<Double> thirdPartyPremiums = user.getTotalThirdPartyPremiumPerCarModel(carModels,flatRate);
        ArrayList<Double> comprehensivePremiums = user.getTotalComprehensivePremiumPerCarModel(carModels,flatRate);
        User.reportAveragePremiumsPerCarModel(carModels,counts,thirdPartyPremiums,comprehensivePremiums);
        System.out.println();
    }
    //*optional: this method for printing total premiums and average premiums(including both policies) per carModel for all the users
    public static void printAveragePremiumsPerCarModelAllUsers(InsuranceCompany insuranceCompany)
    {
        System.out.println("----Report of the Total Premiums Per Type of Policy Per Car Model For All Users----");
        ArrayList<String> carModelsAllUsers = insuranceCompany.populateDistinctCarModels();
        ArrayList<Count> countsAllUsers = insuranceCompany.getTotalAverageCountPerCarModel(carModelsAllUsers);
        ArrayList<Double> thirdPartyPremiumsAllUsers = insuranceCompany.getTotalThirdPartyPremiumPerCarModel(carModelsAllUsers);
        ArrayList<Double> comprehensivePremiumsAllUsers = insuranceCompany.getTotalComprehensivePremiumPerCarModel(carModelsAllUsers);
        InsuranceCompany.reportAveragePremiumsPerCarModel(carModelsAllUsers,countsAllUsers,thirdPartyPremiumsAllUsers,comprehensivePremiumsAllUsers);
        System.out.println();
    }
}
