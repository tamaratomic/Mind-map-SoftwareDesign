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

    Point startnaTacka = new Point();

    private PojamElement element;
    private List<ElementPainter> painters = new ArrayList<>();

    private List<Element> selektovani = new ArrayList<>();

    private List<Point> startSelektovanih = new ArrayList<>();



    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {
        List<ISubscriber> listaSubova = mindMap.getSubscribers();
        startnaTacka = new Point(x,y);
        startSelektovanih.clear();

        for (ISubscriber subscriber : listaSubova) {

            if (subscriber instanceof MindMapPanel) {
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                selektovani = mindMapPanel.getSelectionModel().getSelected();
                painters = mindMapPanel.getPainters();


                for (int i = 0; i < selektovani.size(); i++) {
                    if(selektovani.get(i) instanceof PojamElement){
                        PojamElement elementSelektovani = (PojamElement) selektovani.get(i);

                        startSelektovanih.add(new Point(elementSelektovani.getWPosition(),elementSelektovani.getHPosition()));
                    }

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
        if(pogodjenPojam && (selektovani.size()==1)){

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

        else if(selektovani.size() > 1){
            int razlikaX =(int) (x- startnaTacka.getX());
            int razlikaY =(int) (y -startnaTacka.getY());


            for(int i = 0; i < selektovani.size(); i++){
                PojamElement pojamElement = (PojamElement) selektovani.get(i);
                pojamElement.setWPosition(startSelektovanih.get(i).x + razlikaX);
                pojamElement.setHPosition(startSelektovanih.get(i).y + razlikaY);
                mindMap.notifyObs(4,null);
            }

            for(ElementPainter painter:painters){
                if(painter instanceof VezaPainter){
                    VezaPainter vezaPainter = (VezaPainter) painter;
                    VezaElement vezaElement =(VezaElement) vezaPainter.getElement();

                    for(int i = 0; i < selektovani.size(); i++){

                        PojamElement pojamElement = (PojamElement) selektovani.get(i);

                        if(vezaElement.getOdPojma().equals(pojamElement)){
                            vezaElement.setStart(new Point(pojamElement.getWPosition() + (pojamElement.getXSize()/2),pojamElement.getHPosition() + (pojamElement.getYSize()/2)));
                        }
                        else if(vezaElement.getDoPojma().equals(pojamElement)){
                            vezaElement.setEnd(new Point(pojamElement.getWPosition() + (pojamElement.getXSize()/2),pojamElement.getHPosition() +(pojamElement.getYSize()/2)));
                        }
                        mindMap.notifyObs(4,null);
                    }

                }

            }

        }
    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent) {

    }
}
