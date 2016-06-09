package factory;
import data.AccountData;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import outputproc.action.*;


public abstract class  AbstractAccountFactory {
    public abstract AccountData createAccountData();

    public abstract InputProcessor createInputProcessor(AccountData data, MdaEfsm mdaefsm);
/* create the output processor for Mdaefsm model*/
    public OutputProcessor createOutputProcessor(AccountData data) {
        final OutputProcessor op = new OutputProcessor();
        op.setStoreData(createStoreData(data));
        op.setTooManyAttemptsMsg(createTooManyAttempts(data));
        op.setMenu(createMenu(data));
        op.setDeposit(createDeposit(data));
        op.setBalance(createBalance(data));
        op.setWithdraw(createWithdraw(data));
        op.setPenalty(createPenalty(data));

        return op;
    }

    public abstract Balance createBalance(AccountData data);

    public abstract Deposit createDeposit(AccountData data);

    public abstract Menu createMenu(AccountData data);

    public abstract Penalty createPenalty(AccountData data);

    public abstract StoreData createStoreData(AccountData data);

    public abstract TooManyAttempts createTooManyAttempts(AccountData data);

    public abstract Withdraw createWithdraw(AccountData data);



}
