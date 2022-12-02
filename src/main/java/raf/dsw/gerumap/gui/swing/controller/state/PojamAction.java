package raf.dsw.gerumap.gui.swing.controller.state;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PojamAction extends AbstractGerumapAction {

    public PojamAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/elipse.png"));
        putValue(NAME, "P");
        putValue(SHORT_DESCRIPTION, "Pojam");
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectPanel().startPojamState();
    }
}
