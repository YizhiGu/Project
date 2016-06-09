package outputproc.action.impl;
import data.Account1Data;
import outputproc.action.Deposit;

public class Deposit1 extends Deposit{
	private Account1Data data;

    public Deposit1(Account1Data data) {
        this.data = data;
    }

    @Override
    public void makeDeposit() {
        float d = data.getDeposit();
        if (d > 0) {
            float b = data.getBalance();
            b=b+d;
            data.setBalance(b);
        }
    }
}
