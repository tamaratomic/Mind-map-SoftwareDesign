package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public class ProjectFactory extends NodeFactory{



    @Override
    public MapNode createNode() {
        return new Project();
    }
}
