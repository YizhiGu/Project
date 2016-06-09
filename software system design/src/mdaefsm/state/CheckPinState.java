package mdaefsm.state;

import constant_enum.StateEnum;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.*;
public class CheckPinState extends State {
	public CheckPinState(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }
    @Override
    public void correctPinAboveMin() {
    	// entered the correct pin and above minimum balance  
        outputProcessor.displayMenu();

        //change state
        model.changeState(READY);
    }
    @Override
    public void correctPinBelowMin(){
        outputProcessor.displayMenu();
        //below minimum balance change state to overdrawn
        model.changeState(OVERDRAWN);
    }

    @Override
    public void incorrectPin(int max) {
        int attempts = model.getNumOfAttempts();
        if(attempts < max - 1) {
            model.incrementNumOfAttempts();
            outputProcessor.displayIncorrectPin();
        } else if(attempts == max - 1) {
            outputProcessor.displayTooManyAttempts();
            model.changeState(IDLE);
        }
    }

    @Override
    public void logout() {
        System.out.println("Logged off");
        model.changeState(IDLE);
    }
}
