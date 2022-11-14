package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {


    private Object clickedOn =null;
    private JTextField edit=null;

    public MapTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }


    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        //kada se tri puta klikne da napravi polje za upis novog imena
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }



    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }



    public void actionPerformed(ActionEvent e){

        if (!(clickedOn instanceof MapTreeItem))
            return;

        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());

    }

}
