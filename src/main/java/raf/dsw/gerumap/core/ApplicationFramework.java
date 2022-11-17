package raf.dsw.gerumap.core;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected MessageGenerator messageGenerator;
  //  private static ApplicationFramework instance;

    public ApplicationFramework() {
    }

    public abstract void run();

//    public void run(){
//        this.gui.start();
//    }


    public void initialise(Gui gui, MapRepository mapRepository,MessageGenerator messageGenerator){
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.messageGenerator = messageGenerator;

        this.messageGenerator.addSubs(gui);
    }


//    public static ApplicationFramework getInstance(){
//        if(instance==null){
//            instance = new ApplicationFramework() {
//            };
//        }
//        return instance;
//    }

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }

    public void setMessageGenerator(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }
}
