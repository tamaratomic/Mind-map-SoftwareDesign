package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MindMapPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseContoller extends MouseAdapter implements MouseListener {

    MindMapPanel mindMapPanel;

    public MouseContoller(MindMapPanel mindMapPanel) {
        this.mindMapPanel = mindMapPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mindMapPanel.getProjectPanel().misKliknut(e.getX(),e.getY(), mindMapPanel.getMindMap());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
