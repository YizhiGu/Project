package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.Withdraw;
public class Withdraw1 extends Withdraw{
	private Account1Data data;

    public Withdraw1(Account1Data data) {
        this.data = data;
    }

    @Override
    public void makeWithdraw() {
        float w = data.getWithdraw();
        float b = data.getBalance();

        if (w > 0) {
            b = b - w;
            data.setBalance(b);
        }
    }
}
