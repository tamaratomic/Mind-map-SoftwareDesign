package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public interface MapTree {


    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();
    void deleteChild(MapTreeItem selectedItem);
    void renameNode(MapTreeItem selectedItem);
}
