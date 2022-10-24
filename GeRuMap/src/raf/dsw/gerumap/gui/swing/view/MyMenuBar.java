package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        fileMenu.setMnemonic(KeyEvent.VK_F);

        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());

        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());


        this.add(fileMenu);
        this.add(helpMenu);
    }
}
