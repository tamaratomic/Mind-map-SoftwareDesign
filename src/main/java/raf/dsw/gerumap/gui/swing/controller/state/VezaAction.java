package raf.dsw.gerumap.gui.swing.controller.state;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class VezaAction extends AbstractGerumapAction {

    public VezaAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/link.png"));
        putValue(NAME, "V");
        putValue(SHORT_DESCRIPTION, "Veza");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectPanel().startVezaState();
    }
}
