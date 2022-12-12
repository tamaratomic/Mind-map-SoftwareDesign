package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.gui.swing.view.RenameDialog;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.State;

import java.util.ArrayList;
import java.util.List;

public class PromenaPojmaState implements State {
    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {
        List<ISubscriber> listaSubova = mindMap.getSubscribers();

        for (ISubscriber subscriber : listaSubova) {

            if (subscriber instanceof MindMapPanel) {
                MindMapPanel mindMapPanel = (MindMapPanel) subscriber;

                List<Element> selektovani = mindMapPanel.getSelectionModel().getSelected();
                List<ElementPainter> painters = mindMapPanel.getPainters();

                List<ElementPainter> painteriZaPromenu = new ArrayList<>();

                for (int i = 0; i < selektovani.size(); i++) {


                    for (int j = 0; j < painters.size(); j++) {
                        if (painters.get(j).getElement() == selektovani.get(i)) {
                            painteriZaPromenu.add(painters.get(j));
                        }
                    }
                }

                RenameDialog rd = new RenameDialog(painteriZaPromenu);
                mindMap.notifyObs(5,null);
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
