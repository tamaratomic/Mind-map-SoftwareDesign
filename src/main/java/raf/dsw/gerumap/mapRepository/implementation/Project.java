package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.mapRepository.node.MapNodeComposite;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Project extends MapNodeComposite {


    private String author;
   // private String path;

    List<ISubscriber> subscribers;


    public Project(){
        this.name = "Project" + new Random().nextInt(100);

    }

    public Project(String name, MapNode parent) {
       super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        MindMap mindMap = (MindMap) child;
       //moramo da imamo razlicita imena
        if(!this.getChildren().contains(mindMap)){

            this.getChildren().add(mindMap);
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if(child instanceof MindMap && this.getChildren().contains(child)){
            this.getChildren().remove(child);
        }
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        notifyObs(author + ".auth", null);
    }


    @Override
    public void addSubs(ISubscriber sub) {
        if (sub == null)
            return;
        if (this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if (this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubs(ISubscriber sub) {
        if (sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyObs(Object notif, Object notif2) {

        if (notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (ISubscriber listener : subscribers) {
            listener.update(notif, notif2);
        }

    }
}
