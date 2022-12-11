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

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.List;

public class SelectState implements State {

    private boolean lasso;

    private MindMapPanel mindMapPanel;

    private Dimension dimension;

    private Point pocetnaTacka = new Point();
    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {


        lasso = true;
        List<ISubscriber> listaSubova =  mindMap.getSubscribers();

        for(ISubscriber subscriber:listaSubova){

            if(subscriber instanceof MindMapPanel){
                mindMapPanel = (MindMapPanel) subscriber;



                mindMapPanel.getSelectionModel().removeAllFromSelectionList();

                List<ElementPainter> painters = mindMapPanel.getPainters();

                for(int i = 0; i < painters.size(); i++){

                    if(painters.get(i) instanceof PojamPainter){
                        PojamPainter pojamPainter = (PojamPainter) painters.get(i);

                        if(pojamPainter.elementAt(x, y)){
                            lasso = false;
                            mindMapPanel.getSelectionModel().addToSelectionList(pojamPainter.getElement());
                        }

                    }
                }
                if(lasso){
                   pocetnaTacka.setLocation(x,y);
                }
            }
        }
    }

    @Override
    public void mouseDragged(int x, int y, MindMap mindMap) {
        dimension = new Dimension((int)(calculate(pocetnaTacka,new Point2D.Double(x,pocetnaTacka.y))),(int)(calculate(pocetnaTacka,new Point2D.Double(pocetnaTacka.x,y))));
        mindMapPanel.setSelectionRectangle(new Rectangle(pocetnaTacka,dimension));
    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent) {

        List<ElementPainter> painters = mindMapPanel.getPainters();

        for(ElementPainter painter:painters){
            if(painter instanceof PojamPainter) {
                PojamPainter pojamPainter = (PojamPainter) painter;
                PojamElement pojamElement = (PojamElement) pojamPainter.getElement();

                if(mindMapPanel.getSelectionRectangle() == null){
                    return;
                }

                if (mindMapPanel.getSelectionRectangle().intersects(pojamElement.getWPosition(),pojamElement.getHPosition(),pojamElement.getXSize(),pojamElement.getYSize())){
                    mindMapPanel.getSelectionModel().addToSelectionList(pojamElement);
                }
            }
        }

        mindMapPanel.setSelectionRectangle(null);
        mindMap.notifyObs(new Rectangle(pocetnaTacka,dimension),null);
    }

    private double calculate(Point2D point1, Point2D point2){ return Point2D.distance(point1.getX(),point1.getY(),point2.getX(),point2.getY());}
}
