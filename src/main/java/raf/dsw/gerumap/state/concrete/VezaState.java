package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.mapRepository.implementation.VezaElement;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.State;

import java.awt.event.MouseEvent;
import java.util.List;

public class VezaState implements State {

    PojamElement odPojma;
    PojamElement doPojma;

    @Override
    public void mousePressed(int x, int y, MindMap mindMap) {
        List<ISubscriber> listaSubova =  mindMap.getSubscribers();

        for(ISubscriber subscriber:listaSubova){

            if(subscriber instanceof MindMapPanel){
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<ElementPainter> painters = mindMapPanel.getPainters();

                for(ElementPainter painter:painters){

                    if(painter instanceof PojamPainter){
                        PojamPainter pojamPainter = (PojamPainter) painter;

                        if(pojamPainter.elementAt(x, y)){

                            odPojma = (PojamElement) pojamPainter.getElement();
                            System.out.println("Prvi" + pojamPainter.getElement().getName());
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
    public void mouseReleased(int x, int y, MindMap mindMap) {

        List<ISubscriber> listaSubova =  mindMap.getSubscribers();

        for(ISubscriber subscriber:listaSubova){
            if(subscriber instanceof MindMapPanel){
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<ElementPainter> painters = mindMapPanel.getPainters();

                for(ElementPainter painter:painters){
                    if(painter instanceof PojamPainter){
                        PojamPainter pojamPainter = (PojamPainter) painter;

                        if(pojamPainter.elementAt(x, y)){
                            doPojma = (PojamElement) pojamPainter.getElement();
                            System.out.println("Drugi" + pojamPainter.getElement().getName());
                        }
                    }
                }
            }
        }




        VezaElement vezaElement = new VezaElement(odPojma,doPojma);
        mindMap.addChild(vezaElement);
        mindMap.notifyObs(vezaElement);

    }
}
