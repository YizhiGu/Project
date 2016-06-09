package mdaefsm.state;
import constant_enum.StateEnum;
import exception.AccountException;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.*;

public class OverdrawnState extends State {
	public OverdrawnState(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    @Override
    public void deposit() {
        outputProcessor.makeDeposit();
        model.changeState(S1);
    }

    @Override
    public void withdraw() {
        outputProcessor.displayNoFunds();
        throw new AccountException("displayBelowMinBalance");
    }

    @Override
    public void balance() {
        outputProcessor.displayBalance();
    }

    @Override
    public void incorrectLock() {
        outputProcessor.displayIncorrectPin();
    }

    @Override
    public void logout() {
        System.out.println("Logged off");
        model.changeState(IDLE); }

    @Override
    public void lock() {
        model.changeState(LOCKED);
    }
}
