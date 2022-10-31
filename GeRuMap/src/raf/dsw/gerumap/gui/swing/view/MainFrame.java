package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance;

    private JMenuBar menu;

    private JToolBar toolBar;

    private MapRepository mapRepository;

    private ActionManager actionManager;

    private MainFrame() {

    }

    private void initialise() {
        actionManager = new ActionManager();
        initialiseGUI();

    }

    private void initialiseGUI() {

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

        JPanel desktop = new JPanel();

        JScrollPane scroll = new JScrollPane();
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
}

