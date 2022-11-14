package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public abstract class NodeFactory {

    public MapNode getNode(MapTreeItem item){

        MapNode node = item.getMapNode();


        if(node instanceof Project){


        }


        return null;

    }


    public abstract MapNode createNode();
}
