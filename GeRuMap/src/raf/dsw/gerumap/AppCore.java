package raf.dsw.gerumap;


import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.SwingGui;

public class AppCore extends ApplicationFramework{

    private static AppCore instance;

    private AppCore(){

    }

    @Override
    public void run() {
        this.gui.start();
    }


    public static AppCore getInstance(){
        if(instance==null){
            instance = new AppCore();
        }
        return instance;
    }

    public static void main(String[] args) {
        Gui gui= new SwingGui();
        ApplicationFramework appCore= AppCore.getInstance();
        appCore.initialise(gui);
        appCore.run();
    }
}
