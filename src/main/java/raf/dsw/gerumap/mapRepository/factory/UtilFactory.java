package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.mapRepository.implementation.*;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.messageGenerator.EventType;

public class UtilFactory {

    private static ProjectFactory pef = new ProjectFactory();
    private static MindMapFactory mmf = new MindMapFactory();
    private static PojamFactory epf = new PojamFactory();
    private static VezaFactory vf = new VezaFactory();

    public static NodeFactory getFactory(MapNode node){

        if(node instanceof ProjectExplorer){
            return pef;
        }
         if(node instanceof Project){

            return mmf;
        }
        else if(node instanceof MindMap){
            return epf;
        }else if(node instanceof PojamElement){
            return epf;
        }else if(node instanceof VezaElement){
            return vf;
        }


        return null;
    }



}
