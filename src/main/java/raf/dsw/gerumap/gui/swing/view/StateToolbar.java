package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class StateToolbar extends JToolBar {

    public StateToolbar(){
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getPojamAction());
        add(MainFrame.getInstance().getActionManager().getVezaAction());
        add(MainFrame.getInstance().getActionManager().getBrisanjeAction());
        add(MainFrame.getInstance().getActionManager().getSelectAction());

    }
}
