package raf.dsw.gerumap.state;

import raf.dsw.gerumap.state.concrete.BrisanjeState;
import raf.dsw.gerumap.state.concrete.PojamState;
import raf.dsw.gerumap.state.concrete.SelectState;
import raf.dsw.gerumap.state.concrete.VezaState;

public class StateManager {

    private State currentState;
    private PojamState pojamState;
    private VezaState vezaStateState;
    private BrisanjeState brisanjeState;
    private SelectState selectState;



    public StateManager() {
        initStates();
    }

    private void initStates() {
        pojamState = new PojamState();
        vezaStateState = new VezaState();
        brisanjeState = new BrisanjeState();
        selectState = new SelectState();
        currentState = pojamState;
    }



    public State getCurrentState (){return currentState;}

    public void setPojamState() {
        currentState = pojamState;
        System.out.println(currentState);
    }

    public void setVezaState(){currentState = vezaStateState;}

    public void setBrisanjeState(){currentState = brisanjeState;}

    public void setSelectState(){currentState = selectState;}

}
