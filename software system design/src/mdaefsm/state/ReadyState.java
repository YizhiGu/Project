package mdaefsm.state;

import constant_enum.StateEnum;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.*;

public class ReadyState extends State{
	public ReadyState(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    @Override
    public void deposit() {
        outputProcessor.makeDeposit();
    }

    @Override
    public void withdraw() {
        outputProcessor.makeWithdraw();
        model.changeState(S1);
    }

    @Override
    public void nofunds(){
        outputProcessor.displayNoFunds();
    }

    @Override
    public void balance() {
        outputProcessor.displayBalance();
    }

    @Override
    public void lock() {
        model.changeState(LOCKED);
    }

    @Override
    public void incorrectLock() {
        outputProcessor.displayIncorrectPin();
    }

    @Override
    public void logout() {
        System.out.println("Logged off");
        model.changeState(IDLE);
    }

    @Override
    public void suspend(){
        model.changeState(SUSPENDED);
        System.out.println("Account suspended!");
    }


    @Override
    public void aboveMinBalance() {

    }
}
