package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.MouseContoller;
import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.painter.VezaPainter;
import raf.dsw.gerumap.mapRepository.implementation.*;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MindMapPanel extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private JPanel panCenter;

    private List<ElementPainter> painters;

    private MouseContoller mouseContoller = new MouseContoller(this);

    private ProjectPanel projectPanel;

    public MindMapPanel(MindMap mindMap, ProjectPanel projectPanel){
        setMindMap(mindMap);
        setProjectPanel(projectPanel);

        this.panCenter = new JPanel();
        this.mindMap.addSubs(this);

        this.painters = new ArrayList<>();

        TitledBorder title = BorderFactory.createTitledBorder(mindMap.getName());
        title.setTitlePosition(TitledBorder.TOP);
        title.setTitleJustification(2);
        setBorder(title);

        this.setLayout(new BorderLayout());
        this.panCenter.setBackground(Color.WHITE);
        add(this.panCenter);


        setSize(400,400);
        setVisible(true);
        panCenter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panCenter.setBackground(Color.WHITE);

        panCenter.addMouseListener(mouseContoller);
        panCenter.addMouseMotionListener(mouseContoller);

    }

    public MindMap getMindMap() {
        return mindMap;
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
    }


    public ProjectPanel getProjectPanel() {
        return projectPanel;
    }

    public void setProjectPanel(ProjectPanel projectPanel) {
        this.projectPanel = projectPanel;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        graphics2D.setStroke(new BasicStroke());

        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
       /* Iterator<Element> it = mindMap.get().getSlotIterator();
        while (it.hasNext()){



            Slot slot =it.next();
            if(slot==null)continue;
            else {
                ElementPainter painter = slot.getSlotPainter();
                painter.paint(graphics2D, slot);
            }

        }*/

        for(ElementPainter painter:painters){
            painter.draw(graphics2D);
        }
        System.out.println("Repaint");
    }

    public List<ElementPainter> getPainters() {
        return painters;
    }

    public void setPainters(List<ElementPainter> painters) {
        this.painters = painters;
    }

    @Override
    public void update(Object notif) {
        if(notif instanceof String){
            String s = (String)notif;
            setName(s);
        }
        else if(notif instanceof PojamElement){
            PojamElement element = (PojamElement) notif;
            painters.add(new PojamPainter(element));
            repaint();
        }
        else if(notif instanceof VezaElement){
            VezaElement element = (VezaElement) notif;
            painters.add(new VezaPainter(element));
            repaint();
        }
    }
}
