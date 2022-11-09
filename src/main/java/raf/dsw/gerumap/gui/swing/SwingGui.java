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

        System.out.println("pre instance");
        instance = MainFrame.getInstance();
        System.out.println("uzeta instanca");
        instance.setMapRepository(mapRepository);
        System.out.println("postavljen maprepo");
        instance.setVisible(true);
    }
}
