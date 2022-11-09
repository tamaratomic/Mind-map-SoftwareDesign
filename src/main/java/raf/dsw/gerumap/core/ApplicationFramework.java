package raf.dsw.gerumap.core;

public abstract class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;

    public ApplicationFramework() {
    }

    public abstract void run();


    public void initialise(Gui gui, MapRepository mapRepository){
        this.gui = gui;
        this.mapRepository = mapRepository;
    }

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
}
