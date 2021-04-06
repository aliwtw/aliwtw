package DPIT121.Insurance_Policies1;



//this class is for counting the total numbers of thirdpary and comprehensive policies
public class Count 
{
    //attributes
    private int thirdPartyCount;
    private int comprehensiveCount;
    
    //constructors
    public Count(){}
    public Count(int thirdPartyCount,int comprehensiveCount)
    {
        this.thirdPartyCount=thirdPartyCount;
        this.comprehensiveCount=comprehensiveCount;
    }
    
    //accessors and mutators
    public int getThirdPartyCount()
    { 
        return thirdPartyCount;
    }
    public int getComprehensiveCount()
    {
        return comprehensiveCount;
    }
    public void setThirdPartyCount(int thirdPartyCount)
    {
        this.thirdPartyCount=thirdPartyCount;
    }
    public void setComprehensiveCount(int comprehensiveCount)
    {
        this.comprehensiveCount=comprehensiveCount;
    }
}
