package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.AuthorDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.mapRepository.node.MapNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AuthorAction extends AbstractGerumapAction{


    public AuthorAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/author.png"));
        putValue(NAME, "Author");
        putValue(SHORT_DESCRIPTION, "Author");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String project;

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();


        if(selected == null){
            System.out.println("selektujte projekat");
            return;
        }


        if(selected.getMapNode() instanceof Project){
            AuthorDialog authorDialog = new AuthorDialog(selected);

        }
        else{
            System.out.println("Samo projekat ima autora");
        }




    }
}
