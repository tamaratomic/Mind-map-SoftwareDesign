package raf.dsw.gerumap;


import raf.dsw.gerumap.core.*;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.logger.ConsoleLogger;
import raf.dsw.gerumap.logger.FileLogger;
import raf.dsw.gerumap.mapRepository.MapRepositoryImpl;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImplementation;

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
        MapRepository mapRepository = new MapRepositoryImpl();
        Gui gui= new SwingGui(mapRepository);
        MessageGenerator messageGenerator = new MessageGeneratorImplementation();
        ApplicationFramework appCore= AppCore.getInstance();
       // Logger logger = new ConsoleLogger();
        Logger logger = new FileLogger();
        appCore.initialise(gui,mapRepository,messageGenerator, logger);
        appCore.run();
    }
}
