package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ProjectPanel;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.node.MapNode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerController implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        if((MainFrame.getInstance().getMapTree().getSelectedNode()) == null){
            return;
        }

        if((MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project) && e.getClickCount() == 2) {



                // MainFrame.getInstance().update(null);



                MainFrame.getInstance().setDesktop(MainFrame.getInstance().getMapTree().getSelectedNode());
               // MainFrame.getInstance().update((Project) MainFrame.getInstance().getTree().getSelectedNode());


        }
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
