package raf.dsw.gerumap.mapRepository.node;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.observer.IPublisher;

@Getter
@Setter
public abstract class MapNode implements IPublisher{

    protected String name;
    protected MapNode parent;

    public MapNode(){

    }

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }


}
