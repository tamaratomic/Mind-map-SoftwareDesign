package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Element extends MapNode {

    List<ISubscriber> subscribers;
    private int stroke;
    private Color color;


    public Element(){

    }

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
    public void notifyObs(Object notif, Object notif2) {

        if (notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (ISubscriber listener : subscribers) {
            listener.update(notif, notif2);
        }

    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
        notifyObs(stroke,null);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        notifyObs(color,null);
    }
}
