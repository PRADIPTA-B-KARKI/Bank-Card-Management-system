/**
 * This is a parent class Bank_Card which contains five instance variables, a constructor, multiple accessor and multiple mutator methods along with an instance method.
 * All the five instance variables have its own accessor method and mutator method as per requirement which is used to return and set the value of each instance variables.
 * This class's constructor which accepts four parameters is used for assigning the value of instance variables.
 * The instance method display() is used to display all the details of Bank account which are the value of five instance variables.
 *
 * @author (NP01NT4A220116, Pradipta Bahadur Karki)
 * @version (4.2.0)
 */ 
public class Bank_Card
{
    private int Card_Id;            // Declaring an instance variable Card_Id with int data type
    private String Client_Name;     // Declaring an instance variable Client_Name with String data type
    private String Issuer_Bank;     // Declaring an instance variable Issuer_Bank with String data type
    private String Bank_Account;    // Declaring an instance variable Bank_Account with String data type
    private double Balance_Amount;  // Declaring an instance variable Balance_Amount with double data type
    
    /*
       This is a constructor Bank_Card which accepts four parameters.
       This constructor assigns the value of instances variables that are declared.
     */
    
    public Bank_Card(int Card_Id, String Issuer_Bank, String Bank_Account, double Balance_Amount)
    {
      this.Card_Id = Card_Id;  
      this.Client_Name = Client_Name;
      this.Issuer_Bank = Issuer_Bank;
      this.Bank_Account = Bank_Account;
      this.Balance_Amount = Balance_Amount;
    }
    
    // <---------------Accessor Methods--------------->
    
    /*
       This is an accessor method with int return type.
       This accessor method returns the value of instance variable Card_Id.
    */
    public int getCard_Id()
    {
        return this.Card_Id;
    }
    
    /*
       This is an accessor method with String return type.
       This accessor method returns the value of instance variable Client_Name.
    */
    public String getClient_Name()
    {
        return this.Client_Name;
    }
    
    /*
       This is an accessor method with String return type.
       This accessor method returns the value of instance variable Issuer_Bank.
    */
    public String getIssuer_Bank()
    {
        return this.Issuer_Bank;
    }
    
    /*
       This is an accessor method with String return type.
       This accessor method returns the value of instance variable Bank_Account.
    */
    public String getBank_Account()
    {
        return this.Bank_Account;
    }
    
    /*
       This is an accessor method with double return type.
       This accessor method returns the value of instance variable Balance_Amount.
    */
    public double getBalance_Amount()
    {
        return this.Balance_Amount;
    }
   
    // <---------------Mutator Methods--------------->    
     
    /*
       This is a mutator method with one parameter in String data type.
       This mutator method sets the value of instance variable Client_Name.
    */
    public void setClient_Name(String Client_Name)
    {
        this.Client_Name = Client_Name;
    }
    
    /*
       This is a mutator method with one parameter in double data type.
       This mutator method sets the value of instance variable Balance_Amount.
    */
    public void setBalance_Amount(double Balance_Amount)
    {
        this.Balance_Amount = Balance_Amount;
    }
    
    // <---------------Instance Methods--------------->
    
    /*
       This is an instance method with void return type.
       This instance method displays the value of instances variables.
    */
    public void display()
    {
        if(Client_Name == "")
        {
            System.out.print("\nClient name is empty. Please enter a valid client name.");
        }
        else
        {
            System.out.println("\n Bank Account Details:");
            System.out.println();
            System.out.println("Card ID: " + Card_Id);
            System.out.println("Client Name: " + Client_Name);
            System.out.println("Issuer Bank: " + Issuer_Bank);
            System.out.println("Bank Account: " + Bank_Account);
            System.out.println("Balance Amount: " + Balance_Amount);
        }
    }
}