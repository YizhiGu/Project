package outputproc.action.impl;
import data.Account1Data;
import outputproc.action.Menu;

public class Menu1 extends Menu{
	private Account1Data data;

    public Menu1(Account1Data data) {
        this.data = data;
    }

    @Override
    public void displayMenu() {
        System.out.println("~~~TRANSACTION MENU~~~");
        System.out.println("Deposit    (Float supported)");
        System.out.println("Withdraw");
        System.out.println("Balance");
        System.out.println();
    }

}
