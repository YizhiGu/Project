package mdaefsm.state;

//import constant_enum.StateEnum;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

import static constant_enum.StateEnum.IDLE;


public class StartState extends State{
    public StartState(MdaEfsm model, OutputProcessor outputProcessor) {
        super(model, outputProcessor);
    }

    public void open() {
        outputProcessor.storeData();
        model.changeState(IDLE);
    }
}
