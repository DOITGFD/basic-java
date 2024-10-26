class BankAccount{
    private int bal =0;
    public void deposit(int amt , String threadname){
        synchronized(this){
            bal += amt;
            System.out.println("Thread "+ threadname+": Deposited $"+amt);

        }
    }
    public void withdraw(int amt, String threadname){
        synchronized(this){
            if (bal >= amt){
                bal -= amt;
                System.out.println("Thread "+threadname+": Withdrawn $"+amt);

            }else{
                System.out.println("Thread "+threadname+": Insufficient balance");
            }
        }
    }
    public int getBalance(){
        return bal;
    }
}
class DepositThread extends Thread{
    private BankAccount acc;
    public DepositThread(BankAccount acc){
        this.acc = acc;
    }
    public void run(){
        acc.deposit(100, "Thread 1");
        acc.deposit(200, "Thread 1");
        acc.deposit(300, "Thread 1");
    }
}
class WithdrawThread extends Thread{
    private BankAccount acc;
    public WithdrawThread(BankAccount acc){
        this.acc = acc;
    }
    public void run(){
        acc.withdraw(50,"Thread 2");
        acc.withdraw(100, "Thread 2");
        acc.withdraw(150,"Thread 2");
    }
}
public class accountmanagement{
    public static void main(String[] args){
        BankAccount acc = new BankAccount();
        DepositThread depositThread = new DepositThread(acc);
        WithdrawThread withdrawThread  = new WithdrawThread(acc);

        
        withdrawThread.start();
        depositThread.start();

    }
}
