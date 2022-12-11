package raf.dsw.gerumap.state;

import raf.dsw.gerumap.state.concrete.*;

public class StateManager {

    private State currentState;
    private PojamState pojamState;
    private VezaState vezaStateState;
    private BrisanjeState brisanjeState;
    private SelectState selectState;

    private MoveElementState moveElementState;

    private PromenaPojmaState promenaPojmaState;



    public StateManager() {
        initStates();
    }

    private void initStates() {
        pojamState = new PojamState();
        vezaStateState = new VezaState();
        brisanjeState = new BrisanjeState();
        selectState = new SelectState();
        promenaPojmaState = new PromenaPojmaState();
        moveElementState = new MoveElementState();
        currentState = pojamState;
    }



    public State getCurrentState (){return currentState;}

    public void setPojamState() {
        currentState = pojamState;
    }

    public void setVezaState(){currentState = vezaStateState;}

    public void setBrisanjeState(){currentState = brisanjeState;}

    public void setSelectState(){currentState = selectState;}

    public void setPromenaPojmaState(){currentState = promenaPojmaState;}

    public void setMoveElementState(){currentState = moveElementState;}

}
