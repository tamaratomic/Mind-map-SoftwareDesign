package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.RenameDialog;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;
import raf.dsw.gerumap.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;

public class PojamState implements State {

    @Override
    public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent) {
      //  MainFrame.getInstance().getMapTree().addChild(M);
      //  MainFrame.getInstance().getMapTree().addChild(parent, x, y);
        PojamElement pojamElement = new PojamElement(x,y);
        RenameDialog rd = new RenameDialog(pojamElement);
        MainFrame.getInstance().getMapTree().refresh();
        rd.dispose();
        rd.setVisible(false);
        mindMap.addChild(pojamElement);
        mindMap.notifyObs(pojamElement, parent);
    }

    @Override
    public void mouseDragged(int x, int y, MindMap mindMap) {

    }

    @Override
    public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent) {

    }
}
