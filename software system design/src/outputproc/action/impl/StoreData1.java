package outputproc.action.impl;

import data.Account1Data;
import outputproc.action.StoreData;
public class StoreData1 extends StoreData{
	private Account1Data data;

    public StoreData1(Account1Data data) {
        this.data = data;
    }

    @Override
    public void storeData() {
        //store card details
        data.setPin(data.getPinInput());
        data.setUserId(data.getUserIdInput());
        data.setBalance(data.getBalanceInput());
    }
}
