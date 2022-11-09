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


    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        deleteAction = new DeleteAction();

    }

//
//    public ExitAction getExitAction() {
//        return exitAction;
//    }
//
//    public void setExitAction(ExitAction exitAction) {
//        this.exitAction = exitAction;
//    }
//
//    public NewProjectAction getNewProjectAction() {
//        return newProjectAction;
//    }
//
//    public void setNewProjectAction(NewProjectAction newProjectAction) {
//        this.newProjectAction = newProjectAction;
//    }
//
//    public InfoAction getInfoAction() {
//        return infoAction;
//    }
//
//    public void setInfoAction(InfoAction infoAction) {
//        this.infoAction = infoAction;
//    }
}
