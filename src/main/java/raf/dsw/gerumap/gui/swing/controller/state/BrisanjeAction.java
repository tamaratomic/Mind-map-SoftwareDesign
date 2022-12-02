package raf.dsw.gerumap.gui.swing.controller.state;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BrisanjeAction extends AbstractGerumapAction {

    public BrisanjeAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/remove.png"));
        putValue(NAME, "B");
        putValue(SHORT_DESCRIPTION, "Brisanje");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectPanel().startBrisanjeState();
    }
}
