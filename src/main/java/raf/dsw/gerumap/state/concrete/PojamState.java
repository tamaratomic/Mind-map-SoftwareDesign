package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class PojamState implements State {

    @Override
    public void mousePressed(int x, int y, MindMap mindMap) {
        PojamElement pojamElement = new PojamElement(x,y);
        mindMap.addChild(pojamElement);
        mindMap.notifyObs(pojamElement);
    }

    @Override
    public void mouseDragged(int x, int y, MindMap mindMap) {

    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap) {

    }
}
