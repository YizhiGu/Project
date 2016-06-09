package outputproc.action.impl;

import data.Account2Data;
import outputproc.action.Withdraw;
public class Withdraw2 extends Withdraw{
	private Account2Data data;

    public Withdraw2(Account2Data data) {
        this.data = data;
    }

    @Override
    public void makeWithdraw() {
        int w = data.getWithdraw();
        int b = data.getBalance();

        if (w > 0) {
            b = b - w;
            data.setBalance(b);
        }
    }
}
