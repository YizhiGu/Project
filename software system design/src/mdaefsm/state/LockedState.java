package mdaefsm.state;

import constant_enum.StateEnum;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.S1;
public class LockedState extends State {
    public LockedState(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    @Override
    public void unlock() {
        model.changeState(S1);
    }

    @Override
    public void incorrectUnlock() {
        outputProcessor.displayIncorrectPin();
    }
}
