package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public abstract class NodeFactory {

    public MapNode getNode(MapNode parent, int x, int y){

        MapNode n  = createNode(x, y);
        n.setParent(parent);


        return n;

    }


    public abstract MapNode createNode(int x, int y);
}
