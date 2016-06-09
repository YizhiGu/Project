package mdaefsm.state;

import constant_enum.StateEnum;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.OVERDRAWN;
import static constant_enum.StateEnum.READY;


public class S1State extends State{
    public S1State(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    @Override
    public void aboveMinBalance() {
        model.changeState(READY);
    }

    @Override
    public void belowMinBalance() {
        model.changeState(OVERDRAWN);
    }

    @Override
    public void belowMinBalanceWithPenalty() {
        outputProcessor.chargePenalty();
        model.changeState(OVERDRAWN);
    }
}
