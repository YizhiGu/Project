package outputproc.action.impl;
import data.Account1Data;
import outputproc.action.Balance;
public class Balance1 extends Balance {
	private Account1Data data;

    public Balance1(Account1Data data) {
        this.data = data;
    }

    @Override
    public void displayBalance() {
        float balance = data.getBalance();
        System.out.println("Balance amount = $" + balance);
        System.out.println();
    }
}
