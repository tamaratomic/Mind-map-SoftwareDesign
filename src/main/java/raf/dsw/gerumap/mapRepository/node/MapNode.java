package raf.dsw.gerumap.mapRepository.node;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.observer.IPublisher;

import java.util.ArrayList;
import java.util.List;


public abstract class MapNode implements IPublisher{

    protected String name;
    protected MapNode parent;

    public MapNode(){

    }

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            AppCore.getInstance().getMessageGenerator().generateMessage(EventType.NAME_CANNOT_BE_EMPTY);
            return;
        }

        this.name = name;
        notifyObs(name, null);

    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }
}
