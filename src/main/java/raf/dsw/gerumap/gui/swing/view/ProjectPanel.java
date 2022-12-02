package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.mapRepository.node.MapNodeComposite;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.state.StateManager;

import javax.swing.*;
import java.awt.*;

public class ProjectPanel extends JInternalFrame implements ISubscriber {


    private MapTreeItem mapTreeItem;
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JLabel name;
    private JLabel author;
    private StateManager stateManager;
    private StateToolbar stateToolbar;

    private Project project;


    public ProjectPanel(MapTreeItem item, int high, int width){


        mapTreeItem = item;
//        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
//        this.setLayout(layout);


        setPreferredSize(new Dimension(width,high));
        setResizable(true);


        stateManager = new StateManager();
        stateToolbar = new StateToolbar();
        this.add(stateToolbar, BorderLayout.EAST);
        MapNode node = item.getMapNode();

        this.name = new JLabel("Naziv: " + item.getMapNode().getName());
        this.author = new JLabel("Autor: " + ((Project)item.getMapNode()).getAuthor());

        setProject((Project) item.getMapNode());

        JPanel panel = new JPanel();
        panel.add(name, BorderLayout.PAGE_START);
        panel.add(author, BorderLayout.AFTER_LAST_LINE);
        this.add(panel);



      //  if (item.getMapNode() instanceof Project && !((Project) item.getMapNode()).getChildren().isEmpty()){
            createTabbedPane();
            addTabToTabbedPane((MapNodeComposite)node);
            this.add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel, tabbedPane));
        setVisible(true);
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    @Override




    public void setName(String name) {
        this.name.setText(name);
    }

    public void createTabbedPane(){
        tabbedPane = new JTabbedPaneButton();
        tabbedPane.setFocusable(true);
    }

    public void addTabToTabbedPane(MapNodeComposite project){
        for(MapNode child: project.getChildren()){
            tabbedPane.addTab(child.getName(), new MindMapPanel((MindMap) child, this));
        }
    }


    @Override
    public void update(Object notif) {

        if(notif instanceof MindMap && ((MapNode)notif).getParent().equals(mapTreeItem.getMapNode())){

           if(tabbedPane.getTabCount() == ((MapNodeComposite)mapTreeItem.getMapNode()).getChildren().size()){

               tabbedPane.remove(((MapNodeComposite) mapTreeItem.getMapNode()).getChildren().indexOf((MindMap) notif));
           }else{
               tabbedPane.addTab(((MindMap) notif).getName(), new MindMapPanel((MindMap)notif, this));
           }


        }
        if(notif instanceof String){
            String s =(String) notif;
            //ime ili nesto.auth

            if(s.contains(".")) {
                String[] podeljenString = s.split("\\.");
                setAuthor("Autor: " + podeljenString[0]);
                updateUI();
            }else{
                setName("Naziv " + s);
                updateUI();
            }
        }

        if(notif instanceof MapTreeItem && ((MapTreeItem)notif).equals(mapTreeItem)){
            this.removeAll();
            updateUI();
        }

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void startPojamState(){this.stateManager.setPojamState();}
    public void startVezaState(){this.stateManager.setVezaState();}
    public void startBrisanjeState(){this.stateManager.setBrisanjeState();}
    public void startSelectState(){this.stateManager.setSelectState();}


    public void misKliknut(int x, int y, MindMap mindMap){
        this.stateManager.getCurrentState().mousePressed(x,y,mindMap);
    }
    public void misPovucen(int x, int y, MindMap mindMap){
        this.stateManager.getCurrentState().mouseDragged(x,y,mindMap);
    }

    public void misOtpusten(int x, int y, MindMap mindMap){
        this.stateManager.getCurrentState().mouseReleased(x,y,mindMap);

    }



}
