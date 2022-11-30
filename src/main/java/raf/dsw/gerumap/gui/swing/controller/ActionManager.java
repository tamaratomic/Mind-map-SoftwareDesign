package raf.dsw.gerumap.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.state.BrisanjeAction;
import raf.dsw.gerumap.gui.swing.controller.state.PojamAction;
import raf.dsw.gerumap.gui.swing.controller.state.SelectAction;
import raf.dsw.gerumap.gui.swing.controller.state.VezaAction;

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

    }


}
