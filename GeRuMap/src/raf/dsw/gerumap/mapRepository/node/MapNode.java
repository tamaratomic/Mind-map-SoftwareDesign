package raf.dsw.gerumap.mapRepository.node;

import raf.dsw.gerumap.observer.IPublisher;

public abstract class MapNode implements IPublisher{

    private String name;
    private MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }
}
