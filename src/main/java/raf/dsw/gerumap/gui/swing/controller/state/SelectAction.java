package raf.dsw.gerumap.gui.swing.controller.state;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SelectAction extends AbstractGerumapAction {

    public SelectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "S");
        putValue(SHORT_DESCRIPTION, "Select");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectPanel().startSelectState();
    }
}
