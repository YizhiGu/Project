package mdaefsm.state;

import constant_enum.StateEnum;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.CHECK_PIN;

public class IdleState extends State {
	public IdleState(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    @Override
    public void login() {
        //Set number of attempts to 0
    	model.resetNumOfAttempts();

        //Go to next step
        outputProcessor.displayEnterPin();

        //change state
        model.changeState(CHECK_PIN);
    }

    @Override
    public void invalidLogin() {
        outputProcessor.displayIncorrectId();
    }

}
