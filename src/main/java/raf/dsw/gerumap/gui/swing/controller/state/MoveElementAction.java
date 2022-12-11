package raf.dsw.gerumap.gui.swing.controller.state;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoveElementAction extends AbstractGerumapAction {

    public MoveElementAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/move.png"));
        putValue(NAME, "M");
        putValue(SHORT_DESCRIPTION, "Pomeranje elemenata");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectPanel().startMoveElementState();
    }
}
