package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapSelectionModel extends DefaultSingleSelectionModel implements IPublisher {

    List<Element> selected = new ArrayList<>();
    private List<ISubscriber> subscribers;


    public void addToSelectionList(Element element) {
        if(!isElementSelected(element)) {
            selected.add(element);
            notifyObs(element, "selekcija");
        }
    }

    public boolean isElementSelected(Element element){
        return selected.contains(element);

    }

    public Iterator<Element> getSelectedListIterator(){
        return selected.iterator();
    }


    public void removeAllFromSelectionList() {
        selected.clear();
        notifyObs(new Element(), "selekcija");
    }

    public void removeElementFromList(Element element){
        selected.remove(element);
        notifyObs(new Element(), "selekcija");
    }

    public void removeAllElementsFromList(List<Element> elements){
        selected.removeAll(elements);
        notifyObs(new Element(), "selekcija");
    }

    public List<Element> getSelected() {
        return selected;
    }

    public void setSelected(List<Element> selected) {
        this.selected = selected;
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
