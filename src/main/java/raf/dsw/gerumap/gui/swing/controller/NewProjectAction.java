package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction{

    public NewProjectAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/newProjectIcon.png"));
        putValue(NAME, "NewProject");
        putValue(SHORT_DESCRIPTION, "NewProject");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected.getMapNode() instanceof MindMap){
            System.out.println("NE MOZETE DA SE DODA ELEMNT IZ OVOG TOOLBARA");
        }else{
            MainFrame.getInstance().getMapTree().addChild(selected, 0, 0);
        }


    }
}
