package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.mapRepository.implementation.VezaElement;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VezaState implements State {

    PojamElement odPojma;
    PojamElement doPojma;

    Point start;
    Point end;

     private List<VezaElement> listaVeza = new ArrayList<>();

     private  boolean postoji;

    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {
        List<ISubscriber> listaSubova =  mindMap.getSubscribers();
        odPojma = null;
        doPojma = null;
        postoji = false;


        for(ISubscriber subscriber:listaSubova){

            if(subscriber instanceof MindMapPanel){
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<ElementPainter> painters = mindMapPanel.getPainters();

                for(ElementPainter painter:painters){

                    if(painter instanceof PojamPainter){
                        PojamPainter pojamPainter = (PojamPainter) painter;

                        if(pojamPainter.elementAt(x, y)){

                            odPojma = (PojamElement) pojamPainter.getElement();
                            start = new Point(x,y);

                        }
                    }
                }
            }
        }


    }

    @Override
    public void mouseDragged(int x, int y, MindMap mindMap) {



        if (odPojma != null) {
            mindMap.notifyObs(start, new Point(x, y));
        }
    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent) {


        List<ISubscriber> listaSubova =  mindMap.getSubscribers();
        PojamPainter pojamPainter = null;

        for(ISubscriber subscriber:listaSubova){
            if(subscriber instanceof MindMapPanel){
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<ElementPainter> painters = mindMapPanel.getPainters();

                for(ElementPainter painter:painters){
                    if(painter instanceof PojamPainter){
                        pojamPainter = (PojamPainter) painter;

                        if(pojamPainter.elementAt(x, y)){
                            doPojma = (PojamElement) pojamPainter.getElement();
                            end = new Point(x,y);

                        }
                    }
                }
            }
        }






        if((odPojma != null) && (doPojma != null)) {
            for(VezaElement vezel:listaVeza){
                if(vezel.getOdPojma().equals(odPojma) && vezel.getDoPojma().equals(doPojma) || vezel.getOdPojma().equals(doPojma) && vezel.getDoPojma().equals(odPojma)){
                    postoji = true;
                }
            }
                if(!postoji) {
                    VezaElement vezaElement = new VezaElement(odPojma, doPojma, start, end);
                    listaVeza.add(vezaElement);
                    mindMap.addChild(vezaElement);
                    mindMap.notifyObs(vezaElement, parent);
                }

        }



    }


}
