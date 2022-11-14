package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.MapTreeImplementation;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class MainFrame extends JFrame implements ISubscriber {

    private static MainFrame instance;

    private JMenuBar menu;

    private JToolBar toolBar;

    private MapRepository mapRepository;

    private ActionManager actionManager;

    private MapTree mapTree;

    private JPanel desktop;



    private MainFrame() {

    }

    private void initialise() {
        System.out.println("initialise");
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        initialiseGUI();

    }

    private void initialiseGUI() {

        System.out.println("initialise gui");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar,BorderLayout.NORTH);

        desktop = new JPanel();



        System.out.println(AppCore.getInstance().getMapRepository().getProjectExplorer().getName());
        JTree projectExplorer = mapTree.generateTree(AppCore.getInstance().getMapRepository().getProjectExplorer());


        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);



    }

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public void setDesktop(MapTreeItem item) {
        this.desktop.removeAll();
        int high = desktop.getHeight();
        int width = desktop.getWidth();
         this.desktop.add(new ProjectPanel(item, high, width));
        System.out.println("pozvam ui");
        this.desktop.updateUI();
        System.out.println("pozvan ui");
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public MapRepository getMapRepository() {
        return mapRepository;
    }

    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    @Override
    public void update(Object notif) {

    }
}

