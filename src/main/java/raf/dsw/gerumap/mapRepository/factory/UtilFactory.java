package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.mapRepository.node.MapNode;

public class UtilFactory {

    private static ProjectFactory pf = new ProjectFactory();
    private static MindMapFactory mmf = new MindMapFactory();
    private static ElementFactory ef = new ElementFactory();

    public static NodeFactory getFactory(MapNode node){

        if(node instanceof ProjectExplorer){
            return pf;
        }
        else if(node instanceof Project){

            return mmf;
        }
        else if(node instanceof MindMap){
            return ef;
        }

        return null;
    }



}
