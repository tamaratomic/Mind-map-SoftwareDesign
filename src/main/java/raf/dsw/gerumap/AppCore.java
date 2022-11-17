package raf.dsw.gerumap;


import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.mapRepository.MapRepositoryImpl;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImplementation;

public class AppCore extends ApplicationFramework{

    private static AppCore instance;

    private AppCore(){

    }

    @Override
    public void run() {
        System.out.println("u ranu");
        this.gui.start();
    }


    public static AppCore getInstance(){
        if(instance==null){
            instance = new AppCore();
        }
        return instance;
    }

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepositoryImpl();
        Gui gui= new SwingGui(mapRepository);
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        ApplicationFramework appCore= AppCore.getInstance();
        appCore.initialise(gui,mapRepository,messageGenerator);
        appCore.run();
    }
}
