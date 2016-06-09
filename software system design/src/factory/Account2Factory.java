package factory;
import data.Account2Data;
import data.AccountData;
import inputproc.impl.Account2InputProcessor;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import outputproc.action.*;
import outputproc.action.impl.*;
public class Account2Factory extends AbstractAccountFactory{
    public AccountData createAccountData() {
        return new Account2Data();
    }

    public InputProcessor createInputProcessor(AccountData data, MdaEfsm mdaefsm) {
        return new Account2InputProcessor((Account2Data) data, mdaefsm);
    }

    public Balance createBalance(AccountData data) {
        return new Balance2((Account2Data) data);
    }

    public Deposit createDeposit (AccountData data) {
        return new Deposit2((Account2Data) data);
    }

    public Menu createMenu(AccountData data) {
        return new Menu2((Account2Data) data);
    }

    public Penalty createPenalty(AccountData data) {
        return new Penalty2((Account2Data) data);
    }

    public StoreData createStoreData(AccountData data) {
        return new StoreData2((Account2Data) data);
    }

    public TooManyAttempts createTooManyAttempts(AccountData data) {
        return new TooManyAttempts2((Account2Data) data);
    }

    public Withdraw createWithdraw(AccountData data) {
        return new Withdraw2((Account2Data) data);
    }
}
