package outputproc;
import outputproc.action.*;

public class OutputProcessor {
    private Balance balance;
    private Deposit deposit;
    private Menu menu;
    private Penalty penalty;
    private StoreData storeData;
    private TooManyAttempts tooManyAttempts;
    private Withdraw withdraw;

    public void displayBalance() {
        balance.displayBalance();
    }

    public void displayBelowMinBalance() {
        System.out.println("Below Minimum Balance.");

    }

    public void makeDeposit() {
        deposit.makeDeposit();
    }

    public void displayEnterPin() {
        System.out.println("ENTER PIN #");
    }

    public void displayMenu() {
        menu.displayMenu();
    }

    public void displayIncorrectId() {
        System.out.println("Incorrect ID! Please reenter.");
    }

    public void displayIncorrectPin() {
        System.out.println("Incorrect Pin! Please reenter");
    }

    public void chargePenalty() {
        penalty.chargePenalty();
    }

    public void storeData() {
        storeData.storeData();
    }

    public void displayTooManyAttempts() {
        tooManyAttempts.displayTooManyAttempts();
    }

    public void makeWithdraw() {
        withdraw.makeWithdraw();
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public void setStoreData(StoreData storeData) {
        this.storeData = storeData;
    }

    public void setTooManyAttemptsMsg(TooManyAttempts tooManyAttempts) {
        this.tooManyAttempts = tooManyAttempts;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

    public void displayNoFunds(){System.out.println("No funds.");}



}
