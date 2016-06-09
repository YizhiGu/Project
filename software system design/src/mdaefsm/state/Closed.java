package mdaefsm.state;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;


public class Closed extends State {
	public Closed (MdaEfsm model, OutputProcessor outputProcessor){
        super(model, outputProcessor);
        close();
    }
  @Override
  public void close(){
      this.model = null;
      this.outputProcessor = null;
  }


}
