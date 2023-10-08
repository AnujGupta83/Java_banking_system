import java.util.*;
interface accounts{
    public void get_data();
    public void deposit_amount();
    public void display();
}
class maintain_acc implements accounts{
    String acc_holder_name;
    double acc_bal;
    int acc_no;
    double with;
    double dep;
    Scanner input = new Scanner(System.in); 
    maintain_acc()
    {
        acc_bal = 0;
        System.out.println("the account balance is-->"+acc_bal);
    }
    public void get_data()
    {
        System.out.println("Enter the first name:");
        acc_holder_name = input.nextLine();
        System.out.println("Enter the 6 digit bank account number:");
        acc_no= input.nextInt();
        System.out.println("Enter the initial account balance");
        acc_bal=input.nextDouble();
    }
    public void deposit_amount()
    {
        System.out.println("enter the amout u want to deposit in account");
        dep=input.nextInt();
        acc_bal= acc_bal+dep;
    }
    public void withdraaw_amount() throws error_withdrawl {
        System.out.println("Enter the amount u want to withdraw");
        with=input.nextDouble();
        if(acc_bal < with)
            throw new error_withdrawl();
        else{
            acc_bal=acc_bal-with;
        }
        System.out.println("transaction complete");
    }
    public void display()
    {
        System.out.println("STATEMENT DETAILS");
        System.out.println("ACCOUNT NUMBER--"+acc_no);
        System.out.println("ACCOUNT HOLDER--"+acc_holder_name);
        System.out.println("|||||BALANCE DETAILS|||||");
        System.out.println("DEPOSITED AMOUNT-->"+dep);
        System.out.println("WITHDRAWL AMOUNT-->"+with);
        System.out.println("ACCOUNT FINAL BALANCE-->"+acc_bal);
    }
}
class error_withdrawl extends Exception {
	error_withdrawl() {
        System.out.println("Amount withdrawn was more than available balance" );
	}
}
class loan_acc extends maintain_acc
{
    double loan_amount;
    double repayment;
    double re;
    double int_rate;
    int time;
    String id;
    int motive;
    loan_acc(){
        super();
    }
    public void get_data()
    {
        System.out.println("NAME:");
        acc_holder_name = input.nextLine();
        System.out.println("BANK ACCCOUNT NUMBER(LOAN ID):");
        acc_no= input.nextInt();
    }
    void get_loan_data()
    {
        System.out.println("Please provide the details for::::");
        System.out.println("VERIFICATION ID AND NUMBER-");
        id=input.nextLine();
        get_data();
        System.out.println("Enter the motive for the loan--");
        System.out.println("for house loan press 1\nfor education loan press 2");
        System.out.println("for personal loan press 3");
        motive=input.nextInt();
        if(motive==1)
        {
            System.out.println("The interest rate for house loan is-->");
            int_rate = 7.0;
            System.out.println(int_rate);
        }
        else if(motive==2)
        {
            System.out.println("The interest rate for education loan is-->");
            int_rate = 5.0;
            System.out.println(int_rate);
        }
        else if(motive==3)
        {
            System.out.println("The interest rate for personal loan is-->");
            int_rate = 11.0;
            System.out.println(int_rate);
        }
        else{
            System.out.println("wrong choice!!");
        }
        System.out.println("LOAN AMOUNT::");
        loan_amount=input.nextDouble();
        System.out.println("TIME DURATION::");
        time=input.nextInt();
        System.out.println("AMOUNT TO BE REPAYED AFTER "+time+" YEARS IS");
        repayment=loan_amount+(loan_amount*int_rate*time)/100;
        System.out.println(repayment);
    }
    public void deposit_amount()
    {
        System.out.println("enter the amount to want to pay back::");
        re=input.nextInt();
        repayment= repayment-re;
    }
    public void display()
    {
        System.out.println("STATEMENT DETAILS");
        System.out.println("ACCOUNT NUMBER--"+acc_no);
        System.out.println("ACCOUNT HOLDER--"+acc_holder_name);
        System.out.println("|||||BALANCE DETAILS|||||");
        System.out.println("PAYED AMOUNT -->"+re);
        System.out.println("LOAN AMOUNT LEFT-->"+repayment);
    }
}
class credit_card extends maintain_acc
{
    int card_id;
    int card_type;
    double card_rate;
    double card_limit;
    double charges;
    double total_charges;
    double monthly_bill;
    double pay_monthly;
    void get_card_data()
    {
       get_data();
       System.out.println("Enter your credit card number");
       card_id=input.nextInt();
       System.out.println("Enter the card type");
       System.out.println("Press 1 for simple card");
       System.out.println("press 2 for gold card");
       System.out.println("press 3 for platinum card");
       card_type=input.nextInt();
       if(card_type==1)
        {
            card_rate = 100;
            card_limit=100000;
            System.out.println("The monthly limit for simple card is -->"+card_limit+" and the card rate is Rs.");
            System.out.println(card_rate);;
        }
        else if(card_type==2)
        {   
            card_rate = 200;
            card_limit=200000;
            System.out.println("The monthly limit for gold card is -->"+card_limit+" and the card rate is Rs.");
            System.out.println(card_rate);
        }
        else if(card_type==3)
        {
            card_rate = 400;
            card_limit=400000;
            System.out.println("The monthly limit for platinum card is -->"+card_limit+" and the card rate is Rs.");
            System.out.println(card_rate);
        }
        else{
            System.out.println("wrong choice!!");
        }
        System.out.println();
    }
    public void amount_spent()
    {
        System.out.println("enter the amount to be used");
        charges=input.nextDouble();
        total_charges+=charges;
        if((total_charges+card_rate)>=card_limit)
        {
            System.out.println("Limit reached payment declined");
        }
    }
    public void display()
    {
        System.out.println("MONTHLY STATEMENT DETAILS");
        System.out.println("ACCOUNT NUMBER--"+card_id);
        System.out.println("ACCOUNT HOLDER--"+acc_holder_name);
        System.out.println("the monthly bill to be paid is");
        monthly_bill=total_charges+card_rate;
        System.out.println(monthly_bill);
    }
    public void pay_bill()
    {
        total_charges=0;
        System.out.println("montly bill paid ");
        System.out.println("total dues ="+total_charges);
    }
}
public class activity_4 {
    public static void main(String[] args) {
        System.out.println("\n!!!!!ACCOUNT STATUS MENU!!!!!\n");
        System.out.println("PROVIDE UR CHOICE\n");
        System.out.println("Press 1 if u want to access simple account");
        System.out.println("Press 2 if u want to access loan account");
        System.out.println("press 3 if u want to access credit card");
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("enter choice::::::");
        choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println("You have logged in to your SAVINGS ACCOUNT \n");
                maintain_acc A1 = new maintain_acc();
                A1.get_data();
                int choice2=0;
                while(choice2 !=4)
                {
                    System.out.println("\npress 1 to deposit \npress 2 to withdraw\npress 3 to display");
                    System.out.println("press 4 to exit\n\n");
                    System.out.println("enter the choice");
                    choice2=input.nextInt();
                    System.out.println("\n");
                    switch(choice2)
                    {
                        case 1:
                            A1.deposit_amount();
                            break;
                        case 2:
                            try {
                                A1.withdraaw_amount();
                            } catch (error_withdrawl e){
                                System.out.println("An Error occured!!!exited");
                                System.exit(0);
                            }
                            break;
                        case 3:
                            A1.display();
                            break;
                        case 4:
                            System.out.println("logged out successfull");
                    };
                }
                break;               
            case 2:
                System.out.println("\nYou have logged in to your LOAN ACCOUNT");
                loan_acc L1=new loan_acc();
                L1.get_loan_data();
                
                int choice3=0;
                while(choice3 !=3)
                {
                    System.out.println("If you wish to repay an installment press 1");
                    System.out.println("If you want to display press 2");
                    System.out.println("for exit press 3");
                    System.out.println("enter choice--");
                    choice3=input.nextInt();
                    switch(choice3)
                    {
                        case 1:
                            L1.deposit_amount();
                            break;
                        case 2:
                            L1.display();
                            break;
                    };
                }
            break;
            case 3:
                System.out.println("you are logged in to credit card portal");
                credit_card C1=new credit_card();
                C1.get_card_data();
                int choice4=0;
                while(choice4 !=4)
                {
                    System.out.println("press 1 for pay money /spend amount");
                    System.out.println("press 2 for monthly bill receipt");
                    System.out.println("press 3 to pay monthly bill");
                    choice4=input.nextInt();
                    switch(choice4)
                    {
                        case 1:
                            C1.amount_spent();
                            break;
                        case 2:
                            C1.display();
                            break;
                        case 3:
                            C1.pay_bill();
                            System.out.println("thnks for paying");
                            System.exit(0);
                            break;
                    };
                }
        }
        input.close();
    }
    
}
