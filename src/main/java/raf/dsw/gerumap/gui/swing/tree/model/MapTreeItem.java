package raf.dsw.gerumap.gui.swing.tree.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.node.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;



@Getter
@Setter
public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem(MapNode nodeModel) {
        this.mapNode = nodeModel;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        this.mapNode.setName(name);
    }

    public void setAuthor(String name){
        if(mapNode instanceof Project){
            ((Project) mapNode).setAuthor(name);
        }
    }

    public String getAuthor (){
        if(mapNode instanceof Project){
            return ((Project) mapNode).getAuthor();
        }
        return null;
    }


}
