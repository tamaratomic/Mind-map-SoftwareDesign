package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.mapRepository.implementation.VezaElement;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveElementState implements State {

    boolean pogodjenPojam = false;

    private PojamElement element;
    private List<ElementPainter> painters = new ArrayList<>();

    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {
        List<ISubscriber> listaSubova = mindMap.getSubscribers();

        for (ISubscriber subscriber : listaSubova) {

            if (subscriber instanceof MindMapPanel) {
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<Element> selektovani = mindMapPanel.getSelectionModel().getSelected();
                painters = mindMapPanel.getPainters();


                for (int i = 0; i < selektovani.size(); i++) {


                    for (int j = 0; j < painters.size(); j++) {
                        if (painters.get(j).getElement() == selektovani.get(i)) {

                            PojamPainter painter  = (PojamPainter) painters.get(j);

                            if(painter.elementAt(x, y)){
                                pogodjenPojam = true;
                                element = (PojamElement) painter.getElement();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseDragged(int x, int y, MindMap mindMap) {
        if(pogodjenPojam){

            for(ElementPainter painter:painters){
                if(painter instanceof VezaPainter){
                    VezaPainter vezaPainter = (VezaPainter) painter;
                    VezaElement vezaElement =(VezaElement) vezaPainter.getElement();

                    if(vezaElement.getOdPojma().equals(element)){
                        vezaElement.setStart(new Point(x + (element.getXSize()/2),y + (element.getYSize()/2)));
                    }
                    else if(vezaElement.getDoPojma().equals(element)){
                        vezaElement.setEnd(new Point(x + (element.getXSize()/2),y +(element.getYSize()/2)));
                    }
                }
            }

            element.setWPosition(x);
            element.setHPosition(y);
            mindMap.notifyObs(4,null);
        }
    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent) {

    }
}
