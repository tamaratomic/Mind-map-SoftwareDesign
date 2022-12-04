package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import java.awt.event.MouseEvent;

public interface State {


     public void mousePressed(int x, int y, MindMap mindMap, MapTreeItem parent);
     public void mouseDragged(int x, int y, MindMap mindMap);
     public void mouseReleased(int x, int y, MindMap mindMap, MapTreeItem parent);

}
