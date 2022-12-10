package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import java.util.List;

public interface MapTree {


    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent, int x, int y);
    MapTreeItem getSelectedNode();
    void deleteChild(MapTreeItem selectedItem);
    void renameNode(MapTreeItem selectedItem);
    void setSelectedNode();
    List<MapTreeItem> getItems();
    void refresh();
    MapTreeItem getItemByName(String name);


}
