package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;


    public SwingGui() {

    }


    @Override
    public void start() {

        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
