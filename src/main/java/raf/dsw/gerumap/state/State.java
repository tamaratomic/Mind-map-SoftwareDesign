package raf.dsw.gerumap.state;

import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import java.awt.event.MouseEvent;

public interface State {


     public void mousePressed(int x, int y, MindMap mindMap);
     public void mouseDragged(int x, int y, MindMap mindMap);
     public void mouseReleased(int x, int y, MindMap mindMap);

}
