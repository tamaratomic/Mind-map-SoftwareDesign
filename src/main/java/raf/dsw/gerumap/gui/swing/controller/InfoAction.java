package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.AboutDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractGerumapAction{

    public InfoAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/infoIcon.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutDialog aDialog = new AboutDialog();
        aDialog.setVisible(true);
    }
}
