package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;


public class Element extends MapNode {

    List<ISubscriber> subscribers;

    public Element(String name, MapNode parent) {
        super(name, parent);
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