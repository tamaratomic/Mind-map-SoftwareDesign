package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public class ElementFactory extends NodeFactory{
    @Override
    public MapNode createNode() {
        return new Element();
    }
}
