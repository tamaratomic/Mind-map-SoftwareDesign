package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.mapRepository.node.MapNodeComposite;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void deleteChild(MapTreeItem selectedItem) {
        if(selectedItem.getMapNode() instanceof ProjectExplorer) return;


        MapTreeItem p = (MapTreeItem) selectedItem.getParent();

        ((MapNodeComposite)p.getMapNode()).removeChild(selectedItem.getMapNode());
        p.remove(selectedItem);



        SwingUtilities.updateComponentTreeUI(treeView);



    }

    @Override
    public void renameNode(MapTreeItem selectedItem) {

    }


    private MapNode createChild(MapNode parent) {
        System.out.println("create chikld");
        if (parent instanceof ProjectExplorer) {
            return new Project("Project " + (((ProjectExplorer) parent).getChildren().stream().count()+1), parent);
        }else {
            if(parent instanceof Project){
                return  new MindMap("MM " + (((Project)parent).getChildren().stream().count()+1), parent);
            } else {
                if (parent instanceof MindMap) {
                    return new Element("Element " + (((MindMap) parent).getChildren().stream().count() + 1), parent);
                }
            }
        }
        return null;
    }
}
