package raf.dsw.gerumap.gui.swing.view;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar() {

        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(MainFrame.getInstance().getActionManager().getAuthorAction());
    }
}
