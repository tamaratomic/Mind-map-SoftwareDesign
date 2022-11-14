package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;

    private MapRepository mapRepository;


    public SwingGui(MapRepository mapRepository) {
        this.mapRepository =mapRepository;
    }


    @Override
    public void start() {

        instance = MainFrame.getInstance();
        instance.setMapRepository(mapRepository);
        instance.setVisible(true);
    }
}
