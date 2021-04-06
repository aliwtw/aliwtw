package DPIT121.Insurance_Policies1;



//this class is for test purpose only

import java.util.ArrayList;
import java.util.Scanner;

public class Test
{
    public static InsuranceCompany generateCompany()
    {
        //Test one: Create few users, several polices and one insuranceCompnay
        MyDate dateA = new MyDate(2012,9,23);
        MyDate dateA2 = new MyDate(2012,12,12);
        MyDate dateC = new MyDate(2020,1,1);
        MyDate dateC2 = new MyDate(2020,2,3);
        MyDate dateE = new MyDate(2017,3,1);
        MyDate dateS = new MyDate(2013,7,4);
        MyDate dateS2 = new MyDate(2014,9,23);
        MyDate dateS3 = new MyDate(2015,10,19);
        Car carA = new Car("AUDI-A3",1971,32000,CarType.Audi);
        Car carA2 = new Car("SRX",1999,35000,CarType.Cadillac);
        Car carC = new Car("Camry",2003,12000,CarType.Toyota);
        Car carC2 = new Car("AUDI-A1",2002,27000,CarType.Audi);
        Car carS = new Car("AUDI-A7",2009,37000,CarType.Audi);
        Car carS2 = new Car("Benz-CLS",1997,100000,CarType.Benz);
        Car carS3 = new Car("Benz-CLA",1990,60000,CarType.Benz);
        InsurancePolicy policyA = new ComprehensivePolicy("Jeff Bezos",carA,dateA,2,53);
        InsurancePolicy policyA2 = new ThirdPartyPolicy("Jeff Bezos",carA2,dateA2,1);
        InsurancePolicy policyA3 = new ComprehensivePolicy("Jeff Bezos",carA2,dateA,4,53);
        InsurancePolicy policyC = new ThirdPartyPolicy("Julian Assange",carC,dateC,3);
        InsurancePolicy policyC2 = new ThirdPartyPolicy("Julian Assange",carC2,dateC2,1);
        InsurancePolicy policyE = new ThirdPartyPolicy("QueenElizabeth",carC,dateE,3);
        InsurancePolicy policyE0 = new ComprehensivePolicy("QueenElizabeth",carA2,dateE,6,79);
        InsurancePolicy policyS = new ComprehensivePolicy("Donald Trump",carS,dateS2,2,73);
        InsurancePolicy policyS0 = new ComprehensivePolicy("Donald Trump",carS,dateS,7,73);
        InsurancePolicy policyS2 = new ComprehensivePolicy("Donald Trump",carS2,dateS2,3,73);
        InsurancePolicy policyS3 = new ThirdPartyPolicy("Donald Trump",carS3,dateS3,4);
        ArrayList<InsurancePolicy> policiesForA = new ArrayList<>();
        policiesForA.add(policyA);
        policiesForA.add(policyA2);
        policiesForA.add(policyA3);
        ArrayList<InsurancePolicy> policiesForC = new ArrayList<>();
        policiesForC.add(policyC);
        policiesForC.add(policyC2);
        ArrayList<InsurancePolicy> policiesForE = new ArrayList<>();
        policiesForE.add(policyE);
        policiesForE.add(policyE0);
        ArrayList<InsurancePolicy> policiesForS = new ArrayList<>();
        policiesForS.add(policyS);
        policiesForS.add(policyS0);
        policiesForS.add(policyS2);
        policiesForS.add(policyS3);
        Address addressA = new Address(7,"Lincoln St","Westfield","New York");
        Address addressC = new Address(55,"Woods St","Eastern Beach","Sydney");
        Address addressE = new Address(17,"Stones St","Trotwoods","London");
        Address addressS = new Address(21,"Washington St","Coastfield","Chicago");
        User userA = new User("Jeff",addressA,policiesForA);
        User userC = new User("Julian Assange",addressC,policiesForC);
        User userE = new User("QueenElizabeth",addressE,policiesForE);
        User userS = new User("Donald Trump",addressS,policiesForS);
        
                
        addPolicies(policiesForS, userA);  
        addPolicies(policiesForA, userA);  
                
                
        ArrayList<User> users = new ArrayList<>();
        users.add(userA);
        users.add(userC);
        users.add(userE);
        users.add(userS);
        InsuranceCompany insuranceCompany = new InsuranceCompany("SAFEDRIVE",users,"Bruce","batman",23);
        //Scanner input = new Scanner(System.in);
        
//        //Test two: Add few policies to a user, once not successful (duplicate policy ID) with proper prompting
//        UserInterface.addPolicies(insuranceCompany.addPolicy(userS.getUserID(),policyS2));
//        UserInterface.addPolicies(insuranceCompany.addPolicy(userS.getUserID(),policyS3));
//        System.out.println();
//        //Test three: For this user find a policy with the given ID and print it.
//        UserInterface.printPolicy(userS.findPolicy(1007),insuranceCompany);
//        System.out.println();
//        //Test four: For this user find a policy with the invalid ID and show an error message “Policy has not been found”  
//        UserInterface.findPolicies(userS,1013,insuranceCompany);
//        //Test five: For this user print all the policies
//        userS.printPolicies(insuranceCompany.getFlatRate());
//        System.out.println();
//        //Test six: For this user create a third party policy by calling createThirdPartyPolicy()  
//        UserInterface.addPolicies(userS.createThirdPartyPolicy(userS.getName(),carS2,dateS2,2));
//        System.out.println();
//        //Test seven: Print the total premiums for this user 
//        userS.printPremiums(insuranceCompany.getFlatRate());
//        System.out.println();
//        //Test eight: Ask user to enter a car model and store a list of all the policies owned by this user and 
//        //containing this car model by calling filterByCarModel() and then print this list by calling InsurancePolicy.printPolicies()
//        System.out.print("Please enter a car model:");
//        InsurancePolicy.printPolicies(userS.filterByCarModel(input.next()),insuranceCompany.getFlatRate());
//        System.out.println();
//        //Test nine: Login to the insuranceCompany once successful and once not successful with proper prompting
//        //correct login
//        UserInterface.checkNamePwd(insuranceCompany.validateAdmin("admin001","SecureSystem"));
//        //incorrect login
//        UserInterface.checkNamePwd(insuranceCompany.validateAdmin("Admin","123"));
//        System.out.println();
//        //Test ten: Add few users to the insuranceCompany by using 
//        //both versions of addUser() and at least once not successful with prompting
//        UserInterface.addUsers(insuranceCompany.addUser(userA));
//        UserInterface.addUsers(insuranceCompany.addUser("Scott Morrison",13,addressC));
//        UserInterface.addUsers(insuranceCompany.addUser("Scott Morrison",23,addressC));
//        System.out.println();
//        //Test 11: Add several polices to several users by calling addPolicy (int userID, InsurancePolicy policy), 
//        //at least once not successful with wrong userID and once with duplicate policy with prompting  
//        InsurancePolicy policyI2 = new ThirdPartyPolicy("Donald Trump",carC,dateC,5);
//        UserInterface.addPolicies(insuranceCompany.addPolicy(17, policyI2));
//        UserInterface.addPolicies(insuranceCompany.addPolicy(13, policyI2));
//        System.out.println();
//        //Test 12: Add several polices to several users by calling createThirdPartyPolicy() and createComprehensivePolicy() , 
//        //at least once not successful with wrong userID and once with duplicate policy ID with prompting  
//        UserInterface.addThirdPartyPolicy(insuranceCompany,19,carS, dateS, 2);
//        UserInterface.addComprehensivePolicy(insuranceCompany,20,carC, dateC, 5, 27);
//        UserInterface.addComprehensivePolicy(insuranceCompany,13,carS, dateS, 2, 73);
//        System.out.println();
//        //Test 13: Ask user to enter a userID and find a user with the given userID and print the user and all of his policies 
//        System.out.print("Please enter user id:");
//        UserInterface.printPoliciesForUser(input.nextInt(),insuranceCompany);
//        //Test 14: Ask user to enter a userID and policyID and find a policy with the given policyID for 
//        //that userID by calling findPolicy (int userID ,int policyID) and then print the policy
//        System.out.print("Please enter user id:");
//        int userId = input.nextInt();
//        System.out.print("Please enter policy id:");
//        UserInterface.printPolicy(insuranceCompany.findPolicy(userId,input.nextInt()),insuranceCompany);
//        //Test 15: Print all the users inside the insuranceCompany with a given discount by calling print (int discount)  
//        System.out.println("all the users with their discounted premiums are displayed below:");
//        insuranceCompany.print(0.95);
//        System.out.println();
//        //Test 16: Print the total premiums for a given user ID by calling insurancePolicy.calcTotalPremiums (int userID). 
//        System.out.println("The total premiums for "+insuranceCompany.findUser(11).getName()+" are:"+insuranceCompany.calcTotalPremiums(11));
//        System.out.println();
//        //Test 17: Print the total premiums for all users in the insurance company  
//        System.out.println("The total premiums for all the users are:"+insuranceCompany.calcTotalPremiums());
//        System.out.println();
//        //Test 18:Call allPolicies() for the insurance company and store 
//        //it in an ArrayList and print the list by using InsurancePolicy. printPolicies()  
//        InsurancePolicy.printPolicies(insuranceCompany.allPolicies(),insuranceCompany.getFlatRate());
//        //Test 19:For a given userID and expiry date call filterByExpiryDate (int userID, MyDate date), 
//        //store the filtered list and print the list by using InsurancePolicy.printPolicies()  
//        System.out.println("Filtered policies by date:");
//        MyDate testDate = new MyDate(2019,1,1);
//        InsurancePolicy.printPolicies(insuranceCompany.filterByExpiryDate(13,testDate),insuranceCompany.getFlatRate());
//        System.out.println();
//        //Test 20:For a given car model call insuranceCompany.filterByCarModel (String carModel) and print the filtered list  
//        UserInterface.printPoliciesCarModel(insuranceCompany,"SRX");
//        //Test 21:Ask user to enter a date (year, month, and day) and call filterByExpiryDate (MyDate date) and print the filtered list 
//        UserInterface.expiredPolicies(insuranceCompany);
//        //Test 22:Find a user with the given ID (valid) and save it in a user object. 
//        //Ask user to provide a new address and change the current address for the given user  
//        UserInterface.changeAddress(insuranceCompany.findUser(13));
//        
//        //Tests for data aggregation methods
//        //print out the report of list of cities & total premiums
//        UserInterface.reportPremiumsPerCity(insuranceCompany);
//        
//        //Tests for user control
//        //remove a policy from a given user
//        UserInterface.removePolicy(insuranceCompany.deletePolicy(userS.getUserID(),1008));
//        //remove a user from a given user id
//        UserInterface.removeUsers(insuranceCompany.deleteUser(12));
//        //amdin changes the password
//        UserInterface.changePwd(insuranceCompany,"123");
//        
//        //Tests for advanced data aggregation
//        //Generate the report of total/average premiums of car models for a specific user
//        UserInterface.printPremiumsPerCarModel(userS,insuranceCompany.getFlatRate());
//        //Generate the report of total/average premiums of car models across all the users
//        UserInterface.printPremiumsPerCarModelAllUsers(insuranceCompany);
//        //Generate the report of total/average premiums of two separate policies for a specific user (via car models)
//        UserInterface.printAveragePremiumsPerCarModel(userS,insuranceCompany.getFlatRate());
//        //Generate the report of total/average premiums of two separate policies across all the users (via car models)
//        UserInterface.printAveragePremiumsPerCarModelAllUsers(insuranceCompany);
        

        return insuranceCompany;
        
    }
    
    public static void addPolicies(ArrayList<InsurancePolicy> policies, User user)
    {
        for (InsurancePolicy policy : policies)
        {
            user.addPolicy(policy);
        }
    }
}
