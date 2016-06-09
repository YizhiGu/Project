package outputproc.action.impl;
import data.Account2Data;
import outputproc.action.Menu;

public class Menu2 extends Menu{
	private Account2Data data;

    public Menu2(Account2Data data) {
        this.data = data;
    }

    @Override
    public void displayMenu() {
        System.out.println("~~~TRANSACTION MENU~~~");
        System.out.println("Deposit    (Integer Only");
        System.out.println("Withdraw");
        System.out.println("Balance");
        System.out.println();
    }

}
