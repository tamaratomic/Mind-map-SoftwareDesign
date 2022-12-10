package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.mapRepository.implementation.VezaElement;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class BrisanjeState implements State {
    @Override
    public void mousePressed(int x, int y, MindMap mindMap,  MapTreeItem parent) {


        List<ISubscriber> listaSubova = mindMap.getSubscribers();

        for (ISubscriber subscriber : listaSubova) {

            if (subscriber instanceof MindMapPanel) {
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<Element> selektovani = mindMapPanel.getSelectionModel().getSelected();
                List<ElementPainter> painters = mindMapPanel.getPainters();

                // painters.remove(selektovani.get(0));

                for (int i = 0; i < selektovani.size(); i++) {


                    for (int j = 0; j < painters.size(); j++) {
                        if (painters.get(j).getElement() == selektovani.get(i)) {
                         //  mindMap.getChildren().remove(painters.get(j).getElement());
                            MainFrame.getInstance().getMapTree().deleteChild(MainFrame.getInstance().getMapTree().getItemByName(painters.get(j).getElement().getName()));
                            painters.remove(j);

                        }
                    }
                  //mindMap.notifyObs(2,null);
                    mindMapPanel.getSelectionModel().removeElementFromList(selektovani.get(0));


                    List<ElementPainter> painteriDel = new ArrayList<>();
                    List<Element>elementiDel = new ArrayList<>();

                    for (int j = 0; j < painters.size(); j++) {

                        if(painters.get(j) instanceof VezaPainter){
                            VezaPainter vezaPainter = (VezaPainter) painters.get(j);
                            VezaElement vezaElement = (VezaElement)vezaPainter.getElement();


                            PojamElement odPojma = vezaElement.getOdPojma();
                            PojamElement doPojma = vezaElement.getDoPojma();


                            if(!(mindMap.getChildren().contains(odPojma) && mindMap.getChildren().contains(doPojma))){
                                painteriDel.add(vezaPainter);
                                elementiDel.add(vezaElement);

                            }
                        }
                    }
                    painters.removeAll(painteriDel);
                    MainFrame.getInstance().getMapTree().deleteChildren(elementiDel);
                   // mindMap.getChildren().removeAll(elementiDel);

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
