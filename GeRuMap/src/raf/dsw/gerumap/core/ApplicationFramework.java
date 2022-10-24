package raf.dsw.gerumap.core;

public abstract class ApplicationFramework {

    protected Gui gui;

    public ApplicationFramework() {
    }

    public abstract void run();


    public void initialise(Gui gui){
        this.gui = gui;

    }

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }
}
