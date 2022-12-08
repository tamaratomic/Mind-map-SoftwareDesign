package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class SelectState implements State {
    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {



        List<ISubscriber> listaSubova =  mindMap.getSubscribers();

        for(ISubscriber subscriber:listaSubova){

            if(subscriber instanceof MindMapPanel){
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;



                mindMapPanel.getSelectionModel().removeAllFromSelectionList();

                List<ElementPainter> painters = mindMapPanel.getPainters();

                for(ElementPainter painter:painters){

                    if(painter instanceof PojamPainter){
                        PojamPainter pojamPainter = (PojamPainter) painter;

                        if(pojamPainter.elementAt(x, y)){
                            mindMapPanel.getSelectionModel().addToSelectionList(pojamPainter.getElement());

                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseDragged(int x, int y, MindMap mindMap) {

    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent) {

    }
}
