package raf.dsw.gerumap.gui.swing.controller.state;

import raf.dsw.gerumap.gui.swing.controller.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ZoomInAction extends AbstractGerumapAction {

    public ZoomInAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/zoom_in.png"));
        putValue(NAME, "Zoom in");
        putValue(SHORT_DESCRIPTION, "Zoom in");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectPanel().getActivPanel().ZoomIn();

    }
}
