package mdaefsm;
import constant_enum.StateEnum;
import mdaefsm.state.*;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.*;
public class MdaEfsm {
	 /*Contains the states of MDA-EFSM*/
    private State states[];

    /*Current state of the MDA-EFSM Model*/
    private State currentState;

    private OutputProcessor outputProcessor;

    private int numOfAttempts;
    /*Pass the pointer of Output Processor to the Mda-Efsm model*/
    public MdaEfsm(OutputProcessor op) {
        outputProcessor = op;
        initializeStates();
    }
    /* Initial the whole Model*/
    public void initializeStates() {
        states = new State[StateEnum.getTotalStates()];
        states[START.getId()] = new StartState(this, outputProcessor);
        states[IDLE.getId()] = new IdleState(this, outputProcessor);
        states[CHECK_PIN.getId()] = new CheckPinState(this, outputProcessor);
        states[READY.getId()] = new ReadyState(this, outputProcessor);
        states[S1.getId()] = new S1State(this, outputProcessor);
        states[LOCKED.getId()] = new LockedState(this, outputProcessor);
        states[OVERDRAWN.getId()] = new OverdrawnState(this, outputProcessor);
        states[SUSPENDED.getId()] = new Suspended(this,outputProcessor);
        states[CLOSED.getId()] = new Closed(this,outputProcessor);
        changeState(START);
    }
    //Change the current state to the target state//
    public void changeState(StateEnum stateEnum) {
        if (stateEnum != null) {
            currentState = states[stateEnum.getId()];
        }
    }

    public int getNumOfAttempts() {
        return numOfAttempts;
    }

    public void resetNumOfAttempts() {
        this.numOfAttempts = 0;
    }

    public void incrementNumOfAttempts() {
        this.numOfAttempts++;
    }

    public void open() {
        currentState.open();
    }

    public void login() {
        currentState.login();
    }

    public void invalidLogin() {
        currentState.invalidLogin();
    }


    public void incorrectPin(int max) {
        currentState.incorrectPin(max);
    }

    public void aboveMinBalance() {
        currentState.aboveMinBalance();
    }

    public void belowMinBalance() {
        currentState.belowMinBalance();
    }

    public void belowMinBalanceWithPenalty() {
        currentState.belowMinBalanceWithPenalty();
    }

    public void deposit() {
        currentState.deposit();
    }

    public void withdraw() {
        currentState.withdraw();
    }

    public void balance() {
        currentState.balance();
    }

    public void lock() {
        currentState.lock();
    }

    public void correctPinAboveMin() {currentState.correctPinAboveMin();}

    public void correctPinBelowMin() {currentState.correctPinBelowMin();}

    public void incorrectLock() {
        currentState.incorrectLock();
    }

    public void unlock() {
        currentState.unlock();
    }

    public void incorrectUnlock() {
        currentState.incorrectUnlock();
    }

    public void logout() {
        currentState.logout();
    }

    public void suspend() { currentState.suspend(); }

    public void activate() { currentState.activate(); }

    public void close() { currentState.close(); }

    public void nofunds() {currentState.nofunds();}
}
