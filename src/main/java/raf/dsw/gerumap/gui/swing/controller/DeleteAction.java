package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractGerumapAction{


    public DeleteAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(MainFrame.getInstance().getMapTree().getSelectedNode() != null){
            MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().notifyObs(MainFrame.getInstance().getMapTree().getSelectedNode());
        }
        MainFrame.getInstance().getMapTree().deleteChild(MainFrame.getInstance().getMapTree().getSelectedNode());


    }
}
