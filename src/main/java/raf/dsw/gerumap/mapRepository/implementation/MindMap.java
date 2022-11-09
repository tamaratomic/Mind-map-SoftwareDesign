package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.mapRepository.node.MapNodeComposite;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class MindMap extends MapNodeComposite {

    private boolean isTemplate;

    List<ISubscriber> subscribers;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        Element element = (Element) child;
        if(!this.getChildren().contains(element)){
            this.getChildren().add(element);
        }
    }

    @Override
    public void removeChild(MapNode child) {

        if(child instanceof Element && this.getChildren().contains(child)){
            this.getChildren().remove(child);
        }


    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
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
    public void notifyObs(Object notif) {

        if (notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (ISubscriber listener : subscribers) {
            listener.update(notif);
        }

    }
}
