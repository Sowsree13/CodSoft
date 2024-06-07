import java.util.Scanner;

class BankAccount{

    private String accountno;
    private String pin;
    private double balance;
    
    public BankAccount(String accountno , String pin, double initbalance){
        this.accountno= accountno;
        this.pin=pin;
        this.balance=initbalance;
    }
    public String getAccountNumber(){
        return accountno;
    }
    public boolean validatePin(String pin){
        return this.pin.equals(pin);
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance= balance;
    }
}
class Atm {
     private BankAccount ba;
     public Atm(BankAccount ba){
        this.ba=ba;
     }
     public void withdraw(double amount){
        if(amount<=0)System.out.println("Invalid Amount");
        else if(amount>ba.getBalance())
        System.out.println("Insufficent Balance!!!");
        else{
            ba.setBalance(ba.getBalance()-amount);
            System.out.println("\nAmount withdrawn successfully.....\nYour new Balance is "+ba.getBalance());
        }
     }
     public void deposit(double amount){
        if(amount<=0)
        System.out.println("Invalid amount!!!");
        else{
            ba.setBalance(ba.getBalance()+amount);
            System.out.println("\nAmount Deposited successfully.....\nYour new Balance is "+ ba.getBalance());
        }
     }
     public void balance(){
        System.out.println("Balance : "+ ba.getBalance());
     }
    }
public class ATMinterface {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BankAccount ba = new BankAccount("12345678", "1945", 1000);
        Atm atm = new Atm(ba);
        int service = 0;
        double amount = 0;
        String accountno;
        String pin;

        System.out.println("========================================");
        System.out.println("         Welcome To ATM Services");
        System.out.println("========================================");

        System.out.println("\n\nAccount Number : ");
        accountno = s.nextLine();
        System.out.println("\nSecurity Pin : ");
        pin = s.nextLine();
        if(!ba.getAccountNumber().equals(accountno) && !ba.validatePin(pin) ){
            System.out.println("Invalid Account Number or Pin. Access Denied!!");
            return;
        }
        while (true) {
            System.out.println("\n1.Withdraw amount");
            System.out.println("2.Deposit amount");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");
            System.out.println("\nSelect a service");
            service = s.nextInt();
            switch (service) {
                case 1:
                    System.out.println("Enter Amount for withdrawal : ");
                    amount = s.nextInt();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter Amount to deposit : ");
                    amount = s.nextInt();
                    atm.deposit(amount);
                    break;
                case 3:
                    atm.balance();
                    break;
                case 4:
                    System.out.println("Thank you....Visit Again....!");
                    return;
                    
                default:
                    System.out.println("Invalid Service");
                    break;
            }

        }
    }
}
