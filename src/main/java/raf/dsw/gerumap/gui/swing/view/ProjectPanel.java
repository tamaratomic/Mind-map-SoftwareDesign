package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.mapRepository.node.MapNodeComposite;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextLayout;

public class ProjectPanel extends JPanel {


    private MapTreeItem mapTreeItem;
    private JTabbedPane tabbedPane;
    private JPanel panel1;


    public ProjectPanel(MapTreeItem item, int high, int width){


//        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
//        this.setLayout(layout);

        System.out.println("project panel");
        setSize(width, high);

        MapNode node = item.getMapNode();

        JLabel name = new JLabel("Naziv: " + item.getMapNode().getName());
        JLabel author = new JLabel("Autor: " + ((Project)item.getMapNode()).getAuthor());


        JPanel panel = new JPanel();
        panel.add(name, BorderLayout.PAGE_START);
        panel.add(author, BorderLayout.AFTER_LAST_LINE);
        this.add(panel);



        if (item.getMapNode() instanceof Project && !((Project) item.getMapNode()).getChildren().isEmpty()){
            createTabbedPane();
            addTabToTabbedPane((MapNodeComposite)node);
            this.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel, tabbedPane));
        }

        setVisible(true);

    }




    public void createTabbedPane(){
        tabbedPane = new JTabbedPaneButton();
        tabbedPane.setFocusable(true);
    }

    public void addTabToTabbedPane(MapNodeComposite project){
        for(MapNode child: project.getChildren()){
            tabbedPane.addTab(child.getName(), new JPanel());
        }
    }


}
