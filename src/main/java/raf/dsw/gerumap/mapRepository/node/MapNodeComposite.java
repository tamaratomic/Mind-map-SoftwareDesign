package raf.dsw.gerumap.mapRepository.node;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNodeComposite extends MapNode{

    List<MapNode> children;

    public MapNodeComposite(String name,MapNode parent) {
        super(name,parent);
        this.children = new ArrayList<MapNode>();
    }

    public abstract void addChild(MapNode child);

    public abstract void removeChild(int index);


    public MapNode getChildByName(String name){
        for(MapNode child: this.getChildren()){
            if(name.equals(child.getName())){
                return child;
            }
        }
        return null;
    }


    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }
}
