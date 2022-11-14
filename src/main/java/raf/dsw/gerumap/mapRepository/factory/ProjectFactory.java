package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public class ProjectFactory extends NodeFactory{

    private Project project;


    public ProjectFactory(String name, MapNode parent, String author) {

        project.setName(name);
        project.setParent(parent);
    }

    @Override
    public MapNode createNode() {
        return new Project();
    }
}
