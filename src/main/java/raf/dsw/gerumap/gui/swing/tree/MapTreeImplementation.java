package raf.dsw.gerumap.gui.swing.tree;

import lombok.Getter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MindMapPanel;
import raf.dsw.gerumap.mapRepository.factory.NodeFactory;
import raf.dsw.gerumap.mapRepository.factory.ProjectFactory;
import raf.dsw.gerumap.mapRepository.factory.UtilFactory;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.mapRepository.node.MapNodeComposite;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.lang.model.type.ErrorType;
import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MapTreeImplementation implements MapTree, ISubscriber {

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;
    private List<MapTreeItem> items;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        items = new ArrayList<>();
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent, int x, int y) {


        if(parent == null){
            AppCore.getInstance().getMessageGenerator().generateMessage(EventType.NOTHING_SELECTED);
            return;
        }

        if (!(parent.getMapNode() instanceof MapNodeComposite)){
            return;
        }


        MapNode child = createChild(parent.getMapNode(), x, y);
        if(child instanceof MindMap){
            child.addSubs(this);
        }
        MapTreeItem newChild = new MapTreeItem(child);
        parent.add(newChild);
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        items.add(newChild);
        SwingUtilities.updateComponentTreeUI(treeView);
        parent.getMapNode().notifyObs(child, null);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void deleteChild(MapTreeItem selectedItem) {




        if(selectedItem == null){

            AppCore.getInstance().getMessageGenerator().generateMessage(EventType.NOTHING_SELECTED);
            return;
        }

        if(selectedItem.getMapNode() instanceof ProjectExplorer){
            AppCore.getInstance().getMessageGenerator().generateMessage(EventType.PROJECT_EXPLORER_CANNOT_BE_DELETED);
            return;
        }


        MapTreeItem p = (MapTreeItem) selectedItem.getParent();


        if(p == null){
            AppCore.getInstance().getMessageGenerator().generateMessage(EventType.NOTHING_SELECTED);
            return;
        }

        p.getMapNode().notifyObs(selectedItem.getMapNode(), null);
        ((MapNodeComposite)p.getMapNode()).removeChild(selectedItem.getMapNode());
        p.remove(selectedItem);
        items.remove(selectedItem);
        setSelectedNode();


        SwingUtilities.updateComponentTreeUI(treeView);



    }

    @Override
    public void renameNode(MapTreeItem selectedItem) {

    }

    @Override
    public void setSelectedNode() {
        treeView.setSelectionPaths(null);
    }

    @Override
    public List<MapTreeItem> getItems() {
        return items;
    }

    @Override
    public void refresh() {

        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getItemByName(String name) {
        for(MapTreeItem item: items){
            if(item.getMapNode().getName().equalsIgnoreCase(name)){
                return item;
            }
        }


        return null;
    }

    @Override
    public void deleteChildren(List<Element> children) {

        if(children.isEmpty()){
            System.out.println("children is empty");
            return;
        }

        int m = -1;
        for(int i = 0; i < children.size(); i++){
            if(!(children.get(i) == null)){
                m = i;
                break;
            }
        }
      //  System.out.println(((MapTreeItem) getItemByName(children.get(m).getName())).getMapNode().getName());

        MapTreeItem p = (MapTreeItem) getItemByName(children.get(m).getName()).getParent();
    //    System.out.println("parent    " + p.getMapNode().getName());


        if(p == null){
            System.out.println("parent is null");
//            System.out.println(children.get(m) + "   " + m);
            //AppCore.getInstance().getMessageGenerator().generateMessage(EventType.NOTHING_SELECTED);
            return;
        }
      //  System.out.println("parent  " + p.getMapNode().getName());

        for(Element e : children) {
            MapTreeItem selectedItem = getItemByName(e.getName());
            ((MapNodeComposite) p.getMapNode()).removeChild(selectedItem.getMapNode());
            p.remove(selectedItem);
            items.remove(selectedItem);
          //  setSelectedNode();
        }

        SwingUtilities.updateComponentTreeUI(treeView);


    }



    private MapNode createChild(MapNode parent, int x, int y) {

        //poziva fabr



        NodeFactory nf = UtilFactory.getFactory(parent);
        MapNode n = nf.getNode(parent, x, y);

        return n;
    }

    @Override
    public void update(Object child, Object parent) {
        if((!(parent instanceof Point)) && !(parent == null) && !(parent instanceof Integer)) {
            MapTreeItem parentItem = (MapTreeItem) parent;
            MapTreeItem newChild = new MapTreeItem((MapNode) child);
            parentItem.add(newChild);
            items.add(newChild);
            treeView.expandPath(treeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(treeView);
        }
    }



}
