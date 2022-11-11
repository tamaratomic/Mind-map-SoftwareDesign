package raf.dsw.gerumap.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private InfoAction infoAction;
    private DeleteAction deleteAction;
    private RenameAction renameAction;
    private AuthorAction authorAction;


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

    }


}
