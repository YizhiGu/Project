package mdaefsm.state;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.CLOSED;
import static constant_enum.StateEnum.READY;

public class Suspended extends State{
    public Suspended(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    @Override
    public void balance() {
        outputProcessor.displayBalance();
    }

    @Override
    public void close () {
        model.changeState(CLOSED);
        System.out.println("Account closed!");
    }

    @Override
    public void activate () {
        model.changeState(READY);
    }

}
