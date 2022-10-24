package raf.dsw.gerumap.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction{

    public NewProjectAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/newProjectIcon.png"));
        putValue(NAME, "NewProject");
        putValue(SHORT_DESCRIPTION, "NewProject");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
