package mdaefsm.state;
import exception.AccountException;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
public abstract class State {
    protected MdaEfsm model;

    protected OutputProcessor outputProcessor;

    public State(MdaEfsm model, OutputProcessor outputProcessor) {
        this.model = model;
        this.outputProcessor = outputProcessor;
    }

    private void invalidOperation() {
        System.out.println("Not a valid operation");
        throw new AccountException("Invalid Operation");
    }

    public void open() {
        invalidOperation();
    }

    public void login() {
        invalidOperation();
    }

    public void invalidLogin() {
        invalidOperation();
    }

    public void correctPinAboveMin() {
        invalidOperation();
    }

    public void correctPinBelowMin() {
        invalidOperation();
    }

    public void incorrectPin(int max) {
        invalidOperation();
    }

    public void aboveMinBalance() {
        invalidOperation();
    }

    public void belowMinBalance() {
        invalidOperation();
    }

    public void belowMinBalanceWithPenalty() {
        invalidOperation();
    }

    public void deposit() {
        invalidOperation();
    }

    public void withdraw() {
        invalidOperation();
    }

    public void balance() {
        invalidOperation();
    }

    public void lock() {
        invalidOperation();
    }

    public void incorrectLock() {
        invalidOperation();
    }

    public void unlock() {
        invalidOperation();
    }

    public void incorrectUnlock() {
        invalidOperation();
    }

    public void logout() {
        invalidOperation();
    }

    public void suspend() { invalidOperation(); }

    public void activate() { invalidOperation();}

    public void close() {invalidOperation();}

    public void nofunds() {invalidOperation();}

}
