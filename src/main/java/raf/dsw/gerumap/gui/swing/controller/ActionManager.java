package raf.dsw.gerumap.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.state.*;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private InfoAction infoAction;
    private DeleteAction deleteAction;
    private RenameAction renameAction;
    private AuthorAction authorAction;

    private PojamAction pojamAction;
    private BrisanjeAction brisanjeAction;
    private SelectAction selectAction;
    private VezaAction vezaAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;

    private MoveElementAction moveElementAction;

    private PromenaPojmaAction promenaPojmaAction;


    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        deleteAction = new DeleteAction();
        renameAction = new RenameAction();
        authorAction = new AuthorAction();

        pojamAction = new PojamAction();
        vezaAction = new VezaAction();
        brisanjeAction =  new BrisanjeAction();
        selectAction = new SelectAction();
        promenaPojmaAction = new PromenaPojmaAction();
        moveElementAction = new MoveElementAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();

    }


}
