package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.VezaElement;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public class VezaFactory extends NodeFactory{
    @Override
    public MapNode createNode(int x, int y) {
        return new VezaElement();
    }
}
