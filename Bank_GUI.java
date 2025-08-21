//importing all needed methods from different classes
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * This is a public class Bank_GUI which implements ActionListener and contains multiple instance method.
 * This class imports JFrame, JPanel, JLabel, JButton, JTextField, JComboBox, BorderFactory and JOptionPane from javax.swing package as well as Color, Font, event.ActionListener,
 * event.ActionEvent from java.awt package and ArrayList from java.util package
 * This class is used for making a graphics user interface of Bank_Card, Debit_Card and Credit_Card classes.
 * @author (Pradipta Bahadur Karki)
 * @version (4.2.0)
 */
public class Bank_GUI implements ActionListener
{
    //INSTANCE VARIABLES FOR BANK_GUI:
    
    //Declaring instance variables of JFrame types
    private JFrame BC_Frame,DC_Frame,CC_Frame;
    
    //Declaring instance variables of JPanel types
    private JPanel BC_Panel1,BC_Panel2,DC_Panel,CC_Panel;
    
    //Declaring instance variables of JLabel types
    private JLabel BC_Title,BC_Heading,DC_Title,BC_Message,DC_CardId, DC_BalanceAmount,DC_BankAccount, DC_IssuerBank,DC_ClientName,DC_PinNumber,DC_WithdrawalAmount,DC_DateOfWithdrawal,
                   CC_Title,CC_CardId,CC_BalanceAmount,CC_BankAccount,CC_IssuerBank,CC_ClientName,CC_CvcNumber,CC_InterestRate,CC_ExpirationDate,CC_CreditLimit,CC_GracePeriod;
                   
    //Declaring instance variables  of JButton types               
    private JButton BC_HomeButton,BC_DebitButton,BC_CreditButton,BC_DebitCardButton,BC_CreditCardButton,DC_HomeButton,DC_DebitButton,DC_CreditButton,DC_AddDebitCardButton,
                    DC_WithdrawButton,DC_DisplayButton,DC_ClearButton,CC_HomeButton,CC_DebitButton,CC_CreditButton,CC_AddCreditCardButton,CC_CancelCreditCardButton,CC_DisplayButton,
                    CC_ClearButton,CC_SetCreditLimitButton;
 
    //Declaring instance variables of JTextField types
    private JTextField DC_CardIdText,DC_BalanceAmountText,DC_BankAccountText,DC_IssuerBankText,DC_ClientNameText,DC_PinNumberText,DC_WithdrawalAmountText,CC_CardIdText,
                       CC_BalanceAmountText,CC_BankAccountText,CC_IssuerBankText,CC_ClientNameText,CC_CvcNumberText,CC_InterestRateText,CC_CreditLimitText,CC_GracePeriodText;
     
    //Declaring instance variables of JComboBox types                   
    private JComboBox DC_DayCombobox,DC_MonthCombobox,DC_YearCombobox,CC_DayCombobox,CC_MonthCombobox,CC_YearCombobox;
    
    //Declaring and Initializing Font and Color for whole GUI
    //Fonts:
    Font Title_Font = new Font("SERIF",Font.BOLD,35);
    Font Body_Font = new Font("TimesRoman",Font.PLAIN,25);
    
    //Colors:
    Color Navbar_Color = new Color(255,255,255);
    Color Border_Color = new Color (128,128,128);
    Color Bg_Color = new Color(255, 241, 90);
    Color Button_Color1 = new Color(124, 255, 98);
    Color Button_Color2 = new Color(0, 237, 241);
    Color Button_Color3 = new Color(192, 139, 255);
    Color Cb_Color = new Color(52, 178, 235);
    
    
    //Creating ArrayList of Bank_Card type
    ArrayList <Bank_Card> Bank_Array = new ArrayList <Bank_Card>();
    
    
    /*
     * This method is the main method of the class Bank_GUI. (String [] args) is the parameter passed to it. This method helps us to call the BC_Frame method directly
     * without creating its instance.
     */
    public static void  main(String[] args)
    {
        Bank_GUI menu = new Bank_GUI();
        menu.home();
    }
    
    /*
     * This method actionPerformed () is responsible for event handling process of our GUI. It contains conditional statements which contains all the 
     * actions to be performed when different buttons are pressed. 
     */
    public void actionPerformed(ActionEvent e)
    {

        // button functions for home GUI
        
        //action event for BC_HomeButton button
        if (e.getSource() == BC_HomeButton)
        {
            BC_Frame.dispose();
            this.home();
        }
        
        //action event for BC_DebitButton button
        if (e.getSource() == BC_DebitButton)
        {
            BC_Frame.dispose();
            this.debit_card();
        }
        
        //action event for BC_CreditButton button
        if (e.getSource() == BC_CreditButton)
        {
            BC_Frame.dispose();
            this.credit_card();
        }
        
        //action event for BC_DebitCardButton button
        if (e.getSource() == BC_DebitCardButton)
        {
            BC_Frame.dispose();
            this.debit_card();
        }
        
        //action event for BC_CreditCardButton button
        if (e.getSource() == BC_CreditCardButton)
        {
            BC_Frame.dispose();
            this.credit_card();
        }
        
        // button functions for debit_card GUI
        
        //action event for DC_HomeButton button
        if (e.getSource() == DC_HomeButton)
        {
            DC_Frame.dispose();
            this.home();
        }
       
        //action event for DC_DebitButton button
        if (e.getSource() == DC_DebitButton)
        {
            DC_Frame.dispose();
            this.debit_card();
        }
        
        //action event for DC_CreditButton button
        if (e.getSource() == DC_CreditButton)
        {
            DC_Frame.dispose();
            this.credit_card();
        }
        
        //action event for DC_AddDebitCardButton button
        if (e.getSource() == DC_AddDebitCardButton)
        {
            if(DC_CardIdText.getText().isEmpty() || DC_BalanceAmountText.getText().isEmpty() || DC_BankAccountText.getText().isEmpty()  ||
            DC_IssuerBankText.getText().isEmpty() || DC_ClientNameText.getText().isEmpty() || DC_PinNumberText.getText().isEmpty() )
            {   
                JOptionPane.showMessageDialog(null,"Card Details are empty !!!\n" + "Please enter card details","Empty card details", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    //Converting textfields by required data types:
            
                    int Id = Integer.valueOf(DC_CardIdText.getText());
                    String Client = DC_ClientNameText.getText();
                    String Bank = DC_IssuerBankText.getText();
                    String Account = DC_BankAccountText.getText();
                    double Balance = Double.valueOf( DC_BalanceAmountText.getText() );
                    int Pin = Integer.valueOf(DC_PinNumberText.getText());
            
                    String Value = "\n Card Id: "+Id+"\n Client Name: " + Client + "\n Issuer Bank: " + Bank + "\n Balance Account: " +
                                    Account + "\n Bank Amount: " + Balance +"\n Pin Number: " + Pin ; 
                    
                    // Checking whether the Card Id is unique or not in Bank_Array ArrayList 
                    boolean unique = true;
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if( Bank_Obj instanceof Debit_Card)
                        {
                            Debit_Card Debit_Obj = (Debit_Card) Bank_Obj;
                            
                            if( Debit_Obj.getCard_Id() == Id)
                            {
                                unique = false;
                            }
                        }
                    }
                    if (unique == true)
                    {
                        Debit_Card Debit = new Debit_Card(Id, Client, Bank, Account, Balance, Pin);
                        Bank_Array.add(Debit);
                                             
                        JOptionPane.showMessageDialog(null,"Card Details are successfully added." + Value,"Successfully Debit Card Added",JOptionPane.PLAIN_MESSAGE);
    
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Debit Card details already exists!!! \n"+"Please enter new details","Card Details already in database",JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
                catch(NumberFormatException E)
                {
                    JOptionPane.showMessageDialog(null,"Debit Card details are invalid !!! \n" + "Please enter valid details","Add valid details",JOptionPane.WARNING_MESSAGE);
                }
            }     
        }
        
        //action event for DC_WithdrawButton button
        if (e.getSource() == DC_WithdrawButton)
        {
            if(DC_CardIdText.getText().isEmpty() || DC_PinNumberText.getText().isEmpty() || DC_WithdrawalAmountText.getText().isEmpty())
            {   
                JOptionPane.showMessageDialog(null,"Card Details are empty !!!\n" + "Please enter card details","Empty card details", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    //Converting textfields by required data types:
                    
                    int Id = Integer.valueOf(DC_CardIdText.getText());
                    int Pin = Integer.valueOf(DC_PinNumberText.getText());
                    int Withdraw = Integer.valueOf(DC_WithdrawalAmountText.getText());
                    String Day = DC_DayCombobox.getSelectedItem().toString(); 
                    String Month = DC_MonthCombobox.getSelectedItem().toString(); 
                    String Year = DC_YearCombobox.getSelectedItem().toString(); 
                    String Date = Day + "/" + Month +"/"+ Year;
                    
                    boolean id = false;
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if(Bank_Obj instanceof Debit_Card && Bank_Obj.getCard_Id() == Id)
                        {
                            id = true;
                            Debit_Card Debit_Obj = (Debit_Card) Bank_Obj;
                            if (Debit_Obj.getPin_Number()== Pin )
                            {
                                if (Debit_Obj.getBalance_Amount() >= Withdraw)
                                {
                                    Debit_Obj.withdraw(Withdraw, Date, Pin);
                                    String message = "\nYou have succssfully withdrawn\n" +  "\tRS " + Withdraw + "\n Remaining Balance: RS" + Debit_Obj.getBalance_Amount() 
                                                        + "\n Date of Withdrawal: "+ Date;
                                    JOptionPane.showMessageDialog(null,"Card ID:"+Id+message,"Withdrawn Successfully",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Insufficient Balance\n" + "You can only remove RS " + Debit_Obj.getBalance_Amount(),"Insfficient Balance",JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            else
                            {
                               JOptionPane.showMessageDialog(null,"Wrong PIN number\n" + "Please enter correct PIN","Incorrect PIN number",JOptionPane.WARNING_MESSAGE);
                            }
    
                        }
                    }
                    if (id == false)
                    {
                        JOptionPane.showMessageDialog(null,"Card ID"+Id+" doesn't exist\n" + "Please enter correct Card ID","Incorrect Card ID",JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(NumberFormatException E)
                {
                     JOptionPane.showMessageDialog(null,"Debit Card details are invalid !!! \n" + "Please enter valid details","Add valid details",JOptionPane.WARNING_MESSAGE);
                }                
            }
        }    

        //action event for DC_DisplayButton button
        if (e.getSource() == DC_DisplayButton)
        {
            if(DC_CardIdText.getText().isEmpty() )
            {   
                JOptionPane.showMessageDialog(null,"Card ID is empty !!!\n" + "Please enter Card ID","Empty Card ID", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    //Convert textfields by required data types:
                        
                    int Id = Integer.valueOf(DC_CardIdText.getText());
                    
                    boolean id = false;
                    
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if( Bank_Obj instanceof Debit_Card && Bank_Obj.getCard_Id() == Id)
                        {
                            id = true;
                            Debit_Card Debit_Obj = (Debit_Card) Bank_Obj;       
                            
                            Debit_Obj.display();
                            String display;
                            
                            if(Debit_Obj.getHas_Withdrawn()== true)
                            {
                                display = "\n Card Id: "+Debit_Obj.getCard_Id()+"\n Client Name: " + Debit_Obj.getClient_Name() +
                                       "\n Issuer Bank: " + Debit_Obj.getIssuer_Bank() + "\n Balance Amount: " +  Debit_Obj.getBalance_Amount()
                                       + "\n Bank Account: " + Debit_Obj.getBank_Account() +"\n Pin Number: " + Debit_Obj.getPin_Number() 
                                       + "\n Withdrawal Amount: " + Debit_Obj.getWithdrawal_Amount() +
                                       "\nDate of Withdrawal: " + Debit_Obj.getDate_Of_Withdrawal(); 
                            }
                            else
                            {
                                  display = "\n Card Id: "+Debit_Obj.getCard_Id()+"\n Client Name: " + Debit_Obj.getClient_Name() +
                                       "\n Issuer Bank: " + Debit_Obj.getIssuer_Bank() + "\n Balance Amount: " +  Debit_Obj.getBalance_Amount()
                                       + "\n Bank Account: " + Debit_Obj.getBank_Account() +"\n Pin Number: " + Debit_Obj.getPin_Number() ;
                            }
                            
                             JOptionPane.showMessageDialog(null,"See your details:"+ display, "Your details",JOptionPane.INFORMATION_MESSAGE);
                        }   
                    }
                    if (id == false)
                    {
                        JOptionPane.showMessageDialog(null,"Card ID"+Id+" doesn't exist\n" + "Please enter correct Card ID","Incorrect Card ID",JOptionPane.WARNING_MESSAGE);
                    }                    
                }
                catch(NumberFormatException E)
                {
                     JOptionPane.showMessageDialog(null,"Card ID is invalid !!! \n" + "Please enter valid Card ID","Add valid details",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        //action event for DC_ClearButton button
        if (e.getSource() == DC_ClearButton)
        {
            DC_CardIdText.setText("");
            DC_BalanceAmountText.setText("");
            DC_BankAccountText.setText("");
            DC_IssuerBankText.setText("");
            DC_ClientNameText.setText("");
            DC_PinNumberText.setText("");
            DC_WithdrawalAmountText.setText("");
            DC_DayCombobox.setSelectedIndex(0);
            DC_MonthCombobox.setSelectedIndex(0);
            DC_YearCombobox.setSelectedIndex(0);
        }
        
        // button functions for credit_card GUI
        
        //action event for CC_HomeButton button
        if (e.getSource() == CC_HomeButton)
        {
            CC_Frame.dispose();
            this.home();
        }
        
        //action event for CC_DebitButton button
        if (e.getSource() == CC_DebitButton)
        {
            CC_Frame.dispose();
            this.debit_card();
        }
        
        //action event for CC_CreditButton button
        if (e.getSource() == CC_CreditButton)
        {
            CC_Frame.dispose();
            this.credit_card();
        }
        
        //action event for CC_AddCreditCardButton button
        if (e.getSource() == CC_AddCreditCardButton)
        {
            if(CC_CardIdText.getText().isEmpty() || CC_BalanceAmountText.getText().isEmpty() || CC_BankAccountText.getText().isEmpty()  || CC_IssuerBankText.getText().isEmpty() ||
             CC_ClientNameText.getText().isEmpty() || CC_CvcNumberText.getText().isEmpty() || CC_InterestRateText.getText().isEmpty())
            {   
                JOptionPane.showMessageDialog(null,"Card Details are empty !!!\n" + "Please enter card details","Empty card details", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    //Convert textfields by required data types:  
                    int Id = Integer.valueOf(CC_CardIdText.getText());
                    String Client = CC_ClientNameText.getText();
                    String Bank = CC_IssuerBankText.getText();
                    String Account = CC_BankAccountText.getText();
                    double Balance = Double.valueOf( CC_BalanceAmountText.getText() );
                    int Cvc = Integer.valueOf(CC_CvcNumberText.getText());
                    int Interest = Integer.valueOf(CC_InterestRateText.getText());
                    String Day = CC_DayCombobox.getSelectedItem().toString(); 
                    String Month = CC_MonthCombobox.getSelectedItem().toString(); 
                    String Year = CC_YearCombobox.getSelectedItem().toString(); 
                    String Date = Day + "/" + Month +"/"+ Year;
            
                    String Value = "\n Card Id: "+Id+"\n Client Name: " + Client+ "\n Issuer Bank: " + Bank + "\n Bank Account: " +
                                    Account + "\n Balance Amount: " + Balance +"\n Cvc Number: " + Cvc + "\n Interest Rate: " + Interest
                                     + "\n Expiration Date: " + Date; 
                    
                    // Checking whether the Card Id is unique or not in Bank_Array ArrayList 
                    boolean unique = true;
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if( Bank_Obj instanceof Credit_Card)
                        {
                            Credit_Card Credit_Obj = (Credit_Card) Bank_Obj;
                            
                            if( Credit_Obj.getCard_Id() == Id)
                            {
                                unique = false;
                            }
                        }
                    }
                    if (unique == true)
                    {
                        Credit_Card Credit = new Credit_Card(Id, Client, Bank, Account, Balance, Cvc, Interest, Date);
                        Bank_Array.add(Credit);
                                             
                        JOptionPane.showMessageDialog(null,"Card Details are successfully added." + Value,"Successfully Credit Card Added",JOptionPane.PLAIN_MESSAGE);
    
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Credit Card details already exists!!! \n"+"Please enter new details","Card Details already in database",JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
                catch(NumberFormatException E)
                {
                    JOptionPane.showMessageDialog(null,"Credit Card details are invalid !!! \n" + "Please enter valid details","Add valid details",JOptionPane.WARNING_MESSAGE);
                }
            }
                
        }
           
        //action event for CC_SetCreditCardButton button
        if (e.getSource() == CC_SetCreditLimitButton)
        {
            if(CC_CardIdText.getText().isEmpty() || CC_GracePeriodText.getText().isEmpty() || CC_CreditLimitText.getText().isEmpty())
            {   
                JOptionPane.showMessageDialog(null,"Card Details are empty !!!\n" + "Please enter card details","Empty card details", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
    
                    //Convert textfields by required data types:
                    
                    int Id = Integer.valueOf(CC_CardIdText.getText());
                    double Credit = Double.valueOf( CC_CreditLimitText.getText() );
                    int Grace = Integer.valueOf( CC_GracePeriodText.getText() );
                     
                    boolean id = false;
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if(Bank_Obj instanceof Credit_Card && Bank_Obj.getCard_Id() == Id )
                        {
                            id = true;
                            Credit_Card Credit_Obj = (Credit_Card) Bank_Obj;
                            if (Credit_Obj.getIs_Granted() == false)
                            {
                                if (Credit <= 2.5 * Credit_Obj.getBalance_Amount())
                                {
                                    Credit_Obj.setCredit_Limit(Credit, Grace);
                                    JOptionPane.showMessageDialog(null,"You have successfully set credit limit of Card ID: "+Id+ " to\n" +  "\tRS " + Credit,"Credit Limit set successfully",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Insufficient Balance\n" + "You can only set credit limit up to RS " + (2.5* Credit_Obj.getBalance_Amount()),"Insfficient Balance",JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Your Credit limit for Card ID "+ Id +" is already set. \n","Credit already set",JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                        }
                    }
                    if (id == false)
                    {
                        JOptionPane.showMessageDialog(null,"Card ID " +Id+" doesn't exist\n" + "Please enter correct Card ID","Incorrect Card ID",JOptionPane.WARNING_MESSAGE);
                    }
                }                
                catch(NumberFormatException E)
                {
                   JOptionPane.showMessageDialog(null,"Card details are invalid !!! \n" + "Please enter valid Card details","Add valid credentials",JOptionPane.WARNING_MESSAGE);
                }             
            }
        }
        
        //action event for CC_CancelCreditLimitButton button
        if (e.getSource() == CC_CancelCreditCardButton)
        {
            if(CC_CardIdText.getText().isEmpty() )
            {   
                JOptionPane.showMessageDialog(null,"Card ID is empty !!!\n" + "Please enter Card ID","Empty Card ID", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    //Convert textfields by required data types:
                        
                    int Id = Integer.valueOf(CC_CardIdText.getText());
                    
                    boolean id = false;
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if( Bank_Obj instanceof Credit_Card && Bank_Obj.getCard_Id() == Id)
                        {
                            id = true;
                            Credit_Card Credit_Obj = (Credit_Card) Bank_Obj;  
                            
                            if( Credit_Obj.getIs_Granted() == true)
                            {
                                Credit_Obj.cancelCredit_Card();
                            
                                JOptionPane.showMessageDialog(null,"You have successfully cancelled your Credit Card of Card ID:" + Id, "Cancelled Successfully",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Your Credit Card is already cancelled. \n","Card Cancelled Already",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }   
                    }
                    if (id == false)
                    {
                        JOptionPane.showMessageDialog(null,"Card ID "+ Id+" doesn't exist\n" + "Please enter correct Card ID","Incorrect Card ID",JOptionPane.WARNING_MESSAGE);
                    }                    
                }
                catch(NumberFormatException E)
                {
                     JOptionPane.showMessageDialog(null,"Card ID is invalid !!! \n" + "Please enter valid Card ID","Add valid Card ID",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        //action event for CC_DisplayButton button
        if (e.getSource() == CC_DisplayButton)
        {
            if(CC_CardIdText.getText().isEmpty() )
            {   
                JOptionPane.showMessageDialog(null,"Card ID is empty !!!\n" + "Please enter Card ID","Empty Card ID", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try{
                    //Convert textfields by required data types:
                        
                    int Id = Integer.valueOf(CC_CardIdText.getText());
                    
                    boolean id = false;
                    for(Bank_Card Bank_Obj : Bank_Array)
                    {
                        if( Bank_Obj instanceof Credit_Card && Bank_Obj.getCard_Id() == Id)
                        {
                            id = true;
                            Credit_Card Credit_Obj = (Credit_Card) Bank_Obj;       
                            
                            Credit_Obj.display();
                            String display;
                            //new
                            if(Credit_Obj.getIs_Granted() == true)

                            {
                                display = "\n Card Id: "+Credit_Obj.getCard_Id()+"\n Client Name: " + Credit_Obj.getClient_Name() +
                                       "\n Issuer Bank: " + Credit_Obj.getIssuer_Bank() + "\n Balance Amount: " +  Credit_Obj.getBalance_Amount()
                                       + "\n Bank Account: " + Credit_Obj.getBank_Account() +"\n Cvc Number: " + Credit_Obj.getCvc_Number() 
                                       + "\n Interest Rate: " + Credit_Obj.getInterest_Rate() + "\nExpiration Date: " + Credit_Obj.getExpiration_Date()
                                       + "\n Credit Limit: " + Credit_Obj.getCredit_Limit() + "\n Grace Period: " + Credit_Obj.getGrace_Period(); 
                            }
                            else
                            {
                                 display = "\n Card Id: "+Credit_Obj.getCard_Id()+"\n Client Name: " + Credit_Obj.getClient_Name() +
                                       "\n Issuer Bank: " + Credit_Obj.getIssuer_Bank() + "\n Balance Amount: " +  Credit_Obj.getBalance_Amount()
                                       + "\n Bank Account: " + Credit_Obj.getBank_Account() +"\n Cvc Number: " + Credit_Obj.getCvc_Number() 
                                       + "\n Interest Rate" + Credit_Obj.getInterest_Rate() + "\nExpiration Date" + Credit_Obj.getExpiration_Date();
                            }
                            JOptionPane.showMessageDialog(null,"See your details:" + display, "Your details",JOptionPane.INFORMATION_MESSAGE);
                        }   
                    }
                    if (id == false)
                    {
                        JOptionPane.showMessageDialog(null,"Card ID "+Id+" doesn't exist\n" + "Please enter correct Card ID","Incorrect Card ID",JOptionPane.WARNING_MESSAGE);
                    }                    
                }
                catch(NumberFormatException E)
                {
                     JOptionPane.showMessageDialog(null,"Credit Card ID is invalid!!! \n" + "Please enter valid Card ID","Add valid Card ID",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        //action event for CC_ClearButton button
        if (e.getSource() == CC_ClearButton)
        {
            CC_CardIdText.setText("");
            CC_BalanceAmountText.setText("");
            CC_BankAccountText.setText("");
            CC_IssuerBankText.setText("");
            CC_ClientNameText.setText("");
            CC_CvcNumberText.setText("");
            CC_InterestRateText.setText("");
            CC_CreditLimitText.setText("");
            CC_GracePeriodText.setText("");
            CC_DayCombobox.setSelectedIndex(0);
            CC_MonthCombobox.setSelectedIndex(0);
            CC_YearCombobox.setSelectedIndex(0);
        }
    }

    
    //METHOD FOR home GUI
    public void home()
    {
        //JFrame of home() method
        BC_Frame = new JFrame("Siddartha Bank Home");
        BC_Frame.setBounds(300,50,1000,700);
        BC_Frame.setResizable(false);
        BC_Frame.setLayout(null);
        
        //JPanel1 of BC_Frame
        BC_Panel1 = new JPanel();
        BC_Panel1.setBounds(0,0,990,690);
        BC_Panel1.setBackground(Bg_Color);
        BC_Panel1.setLayout(null);
        
        //JPanel2 of BC_Frame
        BC_Panel2 = new JPanel();
        BC_Panel2.setBounds(100,150,800,430);
        BC_Panel2.setBackground(Cb_Color);
        BC_Panel2.setLayout(null);
        
        // JButton of BC_Home
        BC_HomeButton = new JButton("Home");
        BC_HomeButton.setBounds(2,0,325,50);
        BC_HomeButton.setFont(Body_Font);
        BC_HomeButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        BC_HomeButton.addActionListener(this);
        
        // JButton of BC_Debit
        BC_DebitButton = new JButton("Debit");
        BC_DebitButton.setBounds(329,0,327,50);
        BC_DebitButton.setFont(Body_Font);
        BC_DebitButton.setBackground(Navbar_Color);
        BC_DebitButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        BC_DebitButton.addActionListener(this);
        
        // JButton of  BC_Credit
        BC_CreditButton = new JButton("Credit");
        BC_CreditButton.setBounds(658,0,327,50);
        BC_CreditButton.setFont(Body_Font);
        BC_CreditButton.setBackground(Navbar_Color);
        BC_CreditButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        BC_CreditButton.addActionListener(this);
        
        //JLabel  of title 
        BC_Title = new JLabel("Bank");
        BC_Title.setBounds(420,70,250,40);
        BC_Title.setFont(new Font("SERIF",Font.BOLD,50));
        
        //JLabel of heading
        BC_Heading = new JLabel("Home");
        BC_Heading.setBounds(330,50,250,40);
        BC_Heading.setFont(new Font("SERIF",Font.BOLD,50));
        
        // JButton of BC_DebitCardButton
        BC_DebitCardButton = new JButton("Debit Card");
        BC_DebitCardButton.setBounds(230,140,350,100);
        BC_DebitCardButton.setFont(new Font("TimesRoman",Font.PLAIN,45));
        BC_DebitCardButton.setBackground(Button_Color1);
        BC_DebitCardButton.addActionListener(this);
        
        // JButton of BC_CreditCardButton
        BC_CreditCardButton = new JButton("Credit Card");
        BC_CreditCardButton.setBounds(230,290,350,100);
        BC_CreditCardButton.setFont(new Font("TimesRoman",Font.PLAIN,45));
        BC_CreditCardButton.setBackground(Button_Color1);
        BC_CreditCardButton.addActionListener(this);
        
        //JLabel of thank you message
        BC_Message = new JLabel("Thank you for using!!!");
        BC_Message.setBounds(380,590,300,40);
        BC_Message.setFont(new Font("SERIF",Font.BOLD,30));
        
        // adding everything in panels and frame
        BC_Panel1.add(BC_Message);
        BC_Panel2.add(BC_CreditCardButton);
        BC_Panel2.add(BC_DebitCardButton);
        BC_Panel2.add(BC_Heading);
        BC_Panel1.add(BC_Title);
        BC_Panel1.add(BC_CreditButton);
        BC_Panel1.add(BC_DebitButton);
        BC_Panel1.add(BC_HomeButton);
        BC_Panel1.add(BC_Panel2);
        BC_Frame.add(BC_Panel1);
        BC_Frame.setVisible(true);
    }
    
    //METHOD FOR DEBIT CARD GUI
    public void debit_card()
    {
        //JFrame of debit_card() method
        DC_Frame = new JFrame("Siddartha Bank Debit Card");
        DC_Frame.setBounds(300,50,1000,700);
        DC_Frame.setResizable(false);
        DC_Frame.setLayout(null);
        
        //JPanel of DC_Frame
        DC_Panel = new JPanel();
        DC_Panel.setBounds(0,0,990,690);
        DC_Panel.setBackground(Bg_Color);
        DC_Panel.setLayout(null);
        
        // JButton of DC_Home
        DC_HomeButton = new JButton("Home");
        DC_HomeButton.setBounds(2,0,325,50);
        DC_HomeButton.setFont(Body_Font);
        DC_HomeButton.setBackground(Navbar_Color);
        DC_HomeButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        DC_HomeButton.addActionListener(this);
        
        // JButton of DC_Debit
        DC_DebitButton = new JButton("Debit");
        DC_DebitButton.setBounds(329,0,327,50);
        DC_DebitButton.setFont(Body_Font);
        DC_DebitButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        DC_DebitButton.addActionListener(this);
        
        // JButton of DC_Credit
        DC_CreditButton = new JButton("Credit");
        DC_CreditButton.setBounds(658,0,327,50);
        DC_CreditButton.setFont(Body_Font);
        DC_CreditButton.setBackground(Navbar_Color);
        DC_CreditButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        DC_CreditButton.addActionListener(this);
        
        //JLabel  of title 
        DC_Title = new JLabel("Debit Card");
        DC_Title.setBounds(400,70,200,40);
        DC_Title.setFont(Title_Font);
        
        //JLabel of DC_CardId
        DC_CardId = new JLabel("Card ID :");
        DC_CardId.setBounds(30,130,200,30);
        DC_CardId.setFont(Body_Font);
        
        //JTextField of DC_CardId
        DC_CardIdText = new JTextField();
        DC_CardIdText.setBounds(240,130,200,35);
        DC_CardIdText.setFont(Body_Font);
        
        //JLabel of DC_BalanceAmount
        DC_BalanceAmount = new JLabel("Balance Amount :");
        DC_BalanceAmount.setBounds(30,200,200,30);
        DC_BalanceAmount.setFont(Body_Font);
        
        //JTextField of DC_BalanceAmount
        DC_BalanceAmountText = new JTextField();
        DC_BalanceAmountText.setBounds(240,200,200,35);
        DC_BalanceAmountText.setFont(Body_Font);
        
        //JLabel of DC_BankAccount
        DC_BankAccount = new JLabel("Bank Account:");
        DC_BankAccount.setBounds(30,270,200,30);
        DC_BankAccount.setFont(Body_Font);
        
        //JTextField of DC_BankAccount
        DC_BankAccountText = new JTextField();
        DC_BankAccountText.setBounds(240,270,200,35);
        DC_BankAccountText.setFont(Body_Font);
        
        //JLabel of DC_IssuerBank
        DC_IssuerBank = new JLabel("Issuer Bank:");
        DC_IssuerBank.setBounds(510,130,200,30);
        DC_IssuerBank.setFont(Body_Font);
        
        //JTextField of DC_IssuerBank
        DC_IssuerBankText = new JTextField();
        DC_IssuerBankText.setBounds(720,130,200,35);
        DC_IssuerBankText.setFont(Body_Font);
        
        //JLabel of DC_ClientName
        DC_ClientName = new JLabel("Client Name : ");
        DC_ClientName.setBounds(510,200,200,30);
        DC_ClientName.setFont(Body_Font);
        
        //JTextField of DC_ClientName
        DC_ClientNameText = new JTextField();
        DC_ClientNameText.setBounds(720,200,200,35);
        DC_ClientNameText.setFont(Body_Font);
        
        //JLabel of DC_PinNumber
        DC_PinNumber = new JLabel("PIN Number : ");
        DC_PinNumber.setBounds(510,270,200,30);
        DC_PinNumber.setFont(Body_Font);
        
        //JTextField of DC_PinNumber
        DC_PinNumberText = new JTextField();
        DC_PinNumberText.setBounds(720,270,200,35);
        DC_PinNumberText.setFont(Body_Font);
        
        // JButton of add Debit_Card
        DC_AddDebitCardButton = new JButton("Add Debit Card");
        DC_AddDebitCardButton.setBounds(610,340,250,30);
        DC_AddDebitCardButton.setFont(Body_Font);
        DC_AddDebitCardButton.setBackground(Button_Color1);
        DC_AddDebitCardButton.addActionListener(this);
        
        //JLabel of DC_WithdrawalAmount
        DC_WithdrawalAmount = new JLabel("Withdrawal Amount : ");
        DC_WithdrawalAmount.setBounds(30,430,300,30);
        DC_WithdrawalAmount.setFont(Body_Font);
        
        //JTextField of DC_WithdrawalAmount
        DC_WithdrawalAmountText = new JTextField();
        DC_WithdrawalAmountText.setBounds(340,430,200,35);
        DC_WithdrawalAmountText.setFont(Body_Font);
        
        //JLabel of DateofWithdrawal
        DC_DateOfWithdrawal = new JLabel("Date of Withdrawal : ");
        DC_DateOfWithdrawal.setBounds(30,500,300,30);
        DC_DateOfWithdrawal.setFont(Body_Font);
        
        //JComboBox of DateofWithdrawal
        //Combobox for days
        Integer[] days = new Integer[32];
        for(int i = 0; i<32; i++)
        {
           days[i] = i+1;           
        }
       
        DC_DayCombobox = new <Integer> JComboBox(days);
        DC_DayCombobox.setBounds(340, 500, 100, 35);
        DC_DayCombobox.setFont(Body_Font);
        DC_DayCombobox.setBackground(Cb_Color);
        
        //Combobox for months
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        DC_MonthCombobox = new JComboBox(months);
        DC_MonthCombobox.setBounds(460, 500, 100, 35);
        DC_MonthCombobox.setFont(Body_Font);
        DC_MonthCombobox.setBackground(Cb_Color);
       
        //combobox for years
        Integer[] years = new Integer[100];
        int yr = 2023;
        for(int i = 0; i<100; i++)
        {
           years[i]= yr ;
           yr--;
        }
       
        DC_YearCombobox = new <Integer> JComboBox(years);
        DC_YearCombobox.setBounds(580, 500, 100, 35);
        DC_YearCombobox.setFont(Body_Font);
        DC_YearCombobox.setBackground(Cb_Color);
        
        // JButton of Withdraw
        DC_WithdrawButton = new JButton("Withdraw");
        DC_WithdrawButton.setBounds(100, 600, 200, 30);
        DC_WithdrawButton.setFont(Body_Font);
        DC_WithdrawButton.setBackground(Button_Color1);
        DC_WithdrawButton.addActionListener(this);
        
        // JButton of display
        DC_DisplayButton = new JButton("Display");
        DC_DisplayButton.setBounds(400, 600, 200, 30);
        DC_DisplayButton.setFont(Body_Font);
        DC_DisplayButton.setBackground(Button_Color2);
        DC_DisplayButton.addActionListener(this);
        
        // JButton of Clear
        DC_ClearButton = new JButton("Clear");
        DC_ClearButton.setBounds(700, 600, 200, 30);
        DC_ClearButton.setFont(Body_Font);
        DC_ClearButton.setBackground(Button_Color3);
        DC_ClearButton.addActionListener(this);
        
        // adding everything in panels and frame
        DC_Panel.add(DC_ClearButton);
        DC_Panel.add(DC_DisplayButton);
        DC_Panel.add(DC_WithdrawButton);
        DC_Panel.add(DC_DayCombobox);
        DC_Panel.add(DC_MonthCombobox);
        DC_Panel.add(DC_YearCombobox);
        DC_Panel.add(DC_DateOfWithdrawal);
        DC_Panel.add(DC_WithdrawalAmountText);
        DC_Panel.add(DC_WithdrawalAmount);
        DC_Panel.add(DC_AddDebitCardButton);
        DC_Panel.add(DC_PinNumberText);
        DC_Panel.add(DC_PinNumber);
        DC_Panel.add(DC_ClientNameText);
        DC_Panel.add(DC_ClientName);
        DC_Panel.add(DC_IssuerBankText);
        DC_Panel.add(DC_IssuerBank);
        DC_Panel.add(DC_BankAccountText);
        DC_Panel.add(DC_BankAccount);
        DC_Panel.add(DC_BalanceAmountText);
        DC_Panel.add(DC_BalanceAmount);
        DC_Panel.add(DC_CardIdText);
        DC_Panel.add(DC_CardId);
        DC_Panel.add(DC_Title);
        DC_Panel.add(DC_CreditButton);
        DC_Panel.add(DC_DebitButton);
        DC_Panel.add(DC_HomeButton);
        DC_Frame.add(DC_Panel);
        DC_Frame.setVisible(true);
    }
   
    //METHOD FOR CREDIT CARD GUI
    public void credit_card()
    {
        //JFrame
        CC_Frame = new JFrame("Siddartha Bank Credit Card");
        CC_Frame.setBounds(300,50,1000,700);
        CC_Frame.setResizable(false);
        CC_Frame.setLayout(null);
        
        //JPanel
        CC_Panel = new JPanel();
        CC_Panel.setBounds(0,0,1000,690);
        CC_Panel.setBackground(Bg_Color);
        CC_Panel.setLayout(null);
        
        // JButton of CC_Home
        CC_HomeButton = new JButton("Home");
        CC_HomeButton.setBounds(2,0,327,50);
        CC_HomeButton.setFont(Body_Font);
        CC_HomeButton.setBackground(Navbar_Color);
        CC_HomeButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        CC_HomeButton.addActionListener(this);
        
        // JButton of CC_Debit
        CC_DebitButton = new JButton("Debit");
        CC_DebitButton.setBounds(329,0,327,50);
        CC_DebitButton.setFont(Body_Font);
        CC_DebitButton.setBackground(Navbar_Color);
        CC_DebitButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        CC_DebitButton.addActionListener(this);
        
        // JButton of CC_Credit
        CC_CreditButton = new JButton("Credit");
        CC_CreditButton.setBounds(658,0,327,50);
        CC_CreditButton.setFont(Body_Font);
        CC_CreditButton.setBorder((BorderFactory.createLineBorder(Border_Color,4)));
        CC_CreditButton.addActionListener(this);
        
        //JLabel  of title 
        CC_Title = new JLabel("Credit Card");
        CC_Title.setBounds(400,70,200,40);
        CC_Title.setFont(Title_Font);
       
        //JLabel of CC_CardId
        CC_CardId = new JLabel("Card ID :");
        CC_CardId.setBounds(30,130,200,30);
        CC_CardId.setFont(Body_Font);
        
        //JTextField of CC_CardId
        CC_CardIdText = new JTextField();
        CC_CardIdText.setBounds(240,130,200,35);
        CC_CardIdText.setFont(Body_Font);
        
        //JLabel of CC_BalanceAmount
        CC_BalanceAmount = new JLabel("Balance Amount :");
        CC_BalanceAmount.setBounds(30,180,200,30);
        CC_BalanceAmount.setFont(Body_Font);
        
        //JTextField of CC_BalanceAmount
        CC_BalanceAmountText = new JTextField();
        CC_BalanceAmountText.setBounds(240,180,200,35);
        CC_BalanceAmountText.setFont(Body_Font);
        
        //JLabel of CC_BankAccount
        CC_BankAccount = new JLabel("Bank Account:");
        CC_BankAccount.setBounds(30,230,200,30);
        CC_BankAccount.setFont(Body_Font);
        
        //JTextField of CC_BankAccount
        CC_BankAccountText = new JTextField();
        CC_BankAccountText.setBounds(240,230,200,35);
        CC_BankAccountText.setFont(Body_Font);
        
        //JLabel of CC_IssuerBank
        CC_IssuerBank = new JLabel("Issuer Bank:");
        CC_IssuerBank.setBounds(510,130,200,30);
        CC_IssuerBank.setFont(Body_Font);
        
        //JTextField of CC_IssuerBank
        CC_IssuerBankText = new JTextField();
        CC_IssuerBankText.setBounds(720,130,200,35);
        CC_IssuerBankText.setFont(Body_Font);
        
        //JLabel of CC_ClientName
        CC_ClientName = new JLabel("Client Name : ");
        CC_ClientName.setBounds(510,180,200,30);
        CC_ClientName.setFont(Body_Font);
        
        //JTextField of CC_ClientName
        CC_ClientNameText = new JTextField();
        CC_ClientNameText.setBounds(720,180,200,35);
        CC_ClientNameText.setFont(Body_Font);
        
        //JLabel of CC_CvcNumber
        CC_CvcNumber = new JLabel("CVC Number : ");
        CC_CvcNumber.setBounds(510,230,200,30);
        CC_CvcNumber.setFont(Body_Font);
        
        //JTextField of CC_CvcNumber
        CC_CvcNumberText = new JTextField();
        CC_CvcNumberText.setBounds(720,230,200,35);
        CC_CvcNumberText.setFont(Body_Font);
        
        //JLabel of CC_InterestRate
        CC_InterestRate = new JLabel("Interest Rate : ");
        CC_InterestRate.setBounds(30,280,200,30);
        CC_InterestRate.setFont(Body_Font);
       
        //JTextField of CC_InterestRate
        CC_InterestRateText = new JTextField();
        CC_InterestRateText.setBounds(240,280,200,35);
        CC_InterestRateText.setFont(Body_Font);
        
        //JLabel of CC_ExpirationDate
        CC_ExpirationDate = new JLabel("Expiration Date : ");
        CC_ExpirationDate.setBounds(30,350,300,30);
        CC_ExpirationDate.setFont(Body_Font);
        
        //JComboBox of CC_ExpirationDate
        //Combobox for days
        Integer[] days = new Integer[32];
        for(int i = 0; i<32; i++)
        {
           days[i] = i+1;           
        }
       
        CC_DayCombobox = new <Integer> JComboBox(days);
        CC_DayCombobox.setBounds(340, 350, 100, 35);
        CC_DayCombobox.setFont(Body_Font);
        CC_DayCombobox.setBackground(Cb_Color);
        
        //Combobox for months
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        CC_MonthCombobox = new JComboBox(months);
        CC_MonthCombobox.setBounds(460, 350, 100, 35);
        CC_MonthCombobox.setFont(Body_Font);
        CC_MonthCombobox.setBackground(Cb_Color);
       
        //combobox for years
        Integer[] years = new Integer[100];
        int yr = 2023;
        for(int i = 0; i<100; i++)
        {
           years[i]= yr ;
           yr++;
        }
       
        CC_YearCombobox = new <Integer> JComboBox(years);
        CC_YearCombobox.setBounds(580, 350, 100, 35);
        CC_YearCombobox.setFont(Body_Font);
        CC_YearCombobox.setBackground(Cb_Color);
        
        // JButton of CC_AddCreditCardButton
        CC_AddCreditCardButton = new JButton("Add Credit Card");
        CC_AddCreditCardButton.setBounds(150,430,250,30);
        CC_AddCreditCardButton.setFont(Body_Font);
        CC_AddCreditCardButton.setBackground(Button_Color1);
        CC_AddCreditCardButton.addActionListener(this);
        
        // JButton of CC_CancelCreditCardButton
        CC_CancelCreditCardButton = new JButton("Cancel Credit Card");
        CC_CancelCreditCardButton.setBounds(595,430,250,30);
        CC_CancelCreditCardButton.setFont(Body_Font);
        CC_CancelCreditCardButton.setBackground(Button_Color3);
        CC_CancelCreditCardButton.addActionListener(this);
        
        
        //JLabel of CC_CreditLimit
        CC_CreditLimit = new JLabel("Credit Limit : ");
        CC_CreditLimit.setBounds(30,510,200,30);
        CC_CreditLimit.setFont(Body_Font);
       
        //JTextField of CC_CreditLimitText
        CC_CreditLimitText = new JTextField();
        CC_CreditLimitText.setBounds(240,510,200,35);
        CC_CreditLimitText.setFont(Body_Font);
        
        //JLabel of CC_GracePeriod
        CC_GracePeriod = new JLabel("Grace Period : ");
        CC_GracePeriod.setBounds(510,510,200,30);
        CC_GracePeriod.setFont(Body_Font);
       
        //JTextField of CC_GracePeriodText
        CC_GracePeriodText = new JTextField();
        CC_GracePeriodText.setBounds(720,510,200,35);
        CC_GracePeriodText.setFont(Body_Font);
        
        // JButton of CC_SetCreditLimitButton
        CC_SetCreditLimitButton = new JButton("Set Credit Limit");
        CC_SetCreditLimitButton.setBounds(100, 600, 250, 30);
        CC_SetCreditLimitButton.setFont(Body_Font);
        CC_SetCreditLimitButton.setBackground(Button_Color1);
        CC_SetCreditLimitButton.addActionListener(this);
        
        // JButton of display
        CC_DisplayButton = new JButton("Display");
        CC_DisplayButton.setBounds(420, 600, 200, 30);
        CC_DisplayButton.setFont(Body_Font);
        CC_DisplayButton.setBackground(Button_Color2);
        CC_DisplayButton.addActionListener(this);
        
        // JButton of Clear
        CC_ClearButton = new JButton("Clear");
        CC_ClearButton.setBounds(700, 600, 200, 30);
        CC_ClearButton.setFont(Body_Font);
        CC_ClearButton.setBackground(Button_Color3);
        CC_ClearButton.addActionListener(this);
        
        // adding everything in panels and frame
        CC_Panel.add(CC_ClearButton);
        CC_Panel.add(CC_DisplayButton);
        CC_Panel.add(CC_SetCreditLimitButton);
        CC_Panel.add(CC_DayCombobox);
        CC_Panel.add(CC_MonthCombobox);
        CC_Panel.add(CC_YearCombobox);
        CC_Panel.add(CC_ExpirationDate);
        CC_Panel.add(CC_GracePeriodText);
        CC_Panel.add(CC_GracePeriod);
        CC_Panel.add(CC_CreditLimitText);
        CC_Panel.add(CC_CreditLimit);
        CC_Panel.add(CC_InterestRateText);
        CC_Panel.add(CC_InterestRate);
        CC_Panel.add(CC_CancelCreditCardButton);
        CC_Panel.add(CC_AddCreditCardButton);
        CC_Panel.add(CC_CvcNumberText);
        CC_Panel.add(CC_CvcNumber);
        CC_Panel.add(CC_ClientNameText);
        CC_Panel.add(CC_ClientName);
        CC_Panel.add(CC_IssuerBankText);
        CC_Panel.add(CC_IssuerBank);
        CC_Panel.add(CC_BankAccountText);
        CC_Panel.add(CC_BankAccount);
        CC_Panel.add(CC_BalanceAmountText);
        CC_Panel.add(CC_BalanceAmount);
        CC_Panel.add(CC_CardIdText);
        CC_Panel.add(CC_CardId);
        CC_Panel.add(CC_Title);
        CC_Panel.add(CC_CreditButton);
        CC_Panel.add(CC_DebitButton);
        CC_Panel.add(CC_HomeButton);
        CC_Frame.add(CC_Panel);
        CC_Frame.setVisible(true);
    }
}
