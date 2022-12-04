package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public class PojamFactory extends NodeFactory{
    @Override
    public MapNode createNode(int x,int y) {
        return new PojamElement(x,y);
    }
}
