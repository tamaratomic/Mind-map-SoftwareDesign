package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;

public class MindMapFactory extends  NodeFactory{


    @Override
    public MapNode createNode(int x, int y) {
        return new MindMap();
    }
}
