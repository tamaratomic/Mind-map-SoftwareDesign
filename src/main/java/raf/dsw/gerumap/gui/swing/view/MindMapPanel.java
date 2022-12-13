package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.controller.MouseContoller;
import raf.dsw.gerumap.gui.swing.painter.ElementPainter;
import raf.dsw.gerumap.gui.swing.painter.PojamPainter;
import raf.dsw.gerumap.gui.swing.painter.VezaPainter;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.*;
import raf.dsw.gerumap.mapRepository.node.MapNode;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MindMapPanel extends JPanel implements ISubscriber {

    private MindMap mindMap;

    private MapSelectionModel selectionModel;
    private JPanel panCenter;

    private List<ElementPainter> painters;

    private MouseContoller mouseContoller = new MouseContoller(this);

    private ProjectPanel projectPanel;
    private MapTreeItem mapTreeItem;

    private Rectangle2D selectionRectangle = null;

    private AffineTransform transform = new AffineTransform();
    private double translateX = 0;
    private double translateY = 0;
    private double scaling = 1;
    final public static double scalingFactor = 1.2;
    final public static double translateFactor = 10;







    public MindMapPanel(MapTreeItem item, MindMap mindMap, ProjectPanel projectPanel){
        setMindMap(mindMap);
        setProjectPanel(projectPanel);

        mapTreeItem = item;
        this.selectionModel = new MapSelectionModel();

        this.panCenter = new JPanel();
        if(!mindMap.getSubscribers().contains(this)) {
            this.mindMap.addSubs(this);
        }
        this.selectionModel.addSubs(this);

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


        if(!mindMap.getChildren().isEmpty()){
            for(MapNode e : mindMap.getChildren()){
                if(e instanceof PojamElement){
                    painters.add(new PojamPainter((PojamElement)e));
                }else if(e instanceof VezaElement){
                    painters.add(new VezaPainter((VezaElement)e));
                }
                repaint();

            }
        }

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
        graphics2D.transform(transform);

//        if(zoom){
//
//            graphics2D.transform(transform);
//            zoom = false;
//        }


        for(ElementPainter painter:painters){
            painter.draw(graphics2D);
        }

        for(int i = 0; i < painters.size(); i++){
            if(painters.get(i).getElement() instanceof VezaElement){
                VezaElement vezaElement = (VezaElement) painters.get(i).getElement();
                if(vezaElement.getOdPojma() == null){
                    painters.remove(painters.get(i));
                    repaint();
                }
            }
        }


        paintSelectionHandles(graphics2D);
        paintLasso(graphics2D);
    }

    public List<ElementPainter> getPainters() {
        return painters;
    }

    public void setPainters(List<ElementPainter> painters) {
        this.painters = painters;
    }




    @Override
    public void update(Object notif, Object notif2) {
        if(notif instanceof String){
            String s = (String)notif;
            setName(s);
        }
        else if((notif instanceof PojamElement) && (notif2 instanceof MapTreeItem)){
            PojamElement element = (PojamElement) notif;
//            System.out.println(element.getName() + "       mindmappanel");
            painters.add(new PojamPainter(element));
            repaint();

        }
        else if(notif instanceof VezaElement){
            VezaElement element = (VezaElement) notif;
            painters.add(new VezaPainter(element));
            repaint();
        }
        else if((notif instanceof Point) && (notif2 instanceof Point)){
            Point start = (Point) notif;
            Point end = (Point) notif2;
            VezaPainter vezaPainter = new VezaPainter(new VezaElement(null,null,start,end));
            painters.add(vezaPainter);
            repaint();
        }
        else if((notif instanceof Element) && (notif2 instanceof String)){
            repaint();
        }
        else if(notif instanceof Integer){
            repaint();
        }
        else if(notif instanceof Color){
            repaint();
        }
        else if(notif instanceof Rectangle2D){
            repaint();
        }

    }



    public MapSelectionModel getSelectionModel() {
        return selectionModel;
    }

    public MouseContoller getMouseContoller() {
        return mouseContoller;
    }

    public void setMouseContoller(MouseContoller mouseContoller) {
        this.mouseContoller = mouseContoller;
    }

    public void setSelectionModel(MapSelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }

    public Rectangle2D getSelectionRectangle() {
        return selectionRectangle;
    }

    public void setSelectionRectangle(Rectangle2D selectionRectangle) {
        this.selectionRectangle = selectionRectangle;
        mindMap.notifyObs(selectionRectangle,null);
    }

    private void paintSelectionHandles(Graphics2D g2) {
        Iterator<Element> it=getSelectionModel().getSelectedListIterator();
        while(it.hasNext()) {
            Element element = it.next();
            PojamElement pojamElement = (PojamElement) element;
            if (element == null) return;
            // Iscrtavanje pravougaonika sa isprekidanom linijom
            g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0));
            g2.setPaint(Color.BLACK);

            g2.drawRect((int) pojamElement.getWPosition(), (int) pojamElement.getHPosition(),
                    (int) pojamElement.getXSize(), (int) pojamElement.getYSize());

            // 	Iscrtavanje hendlova
         /*   for (Handle e : Handle.values()) {
                paintSelectionHandle(g2, getHandlePoint(slot.getPosition(), slot.getSize(), e));
                // System.out.println(getHandlePoint(slot.getPosition(), slot.getSize(), e));
            }*/

        }

    }

    private void paintLasso(Graphics2D g2){
        if(getSelectionRectangle()!=null){
            Rectangle2D rec=getSelectionRectangle();
            g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0));
            g2.setPaint(Color.BLACK);

            g2.drawRect((int)  rec.getBounds2D().getX(), (int) rec.getBounds2D().getY(),
                    (int) rec.getBounds().getWidth(), (int) rec.getBounds().getHeight());
        }
    }

    private  double x = this.getX();
    private   double y = this.getY();
    public void setTransform() {

     //   System.out.println("u transofrmu");



        translateX = (scaling) * (translateX) + (1 - scaling) * x;
        translateY = (scaling) * (translateX) + (1 - scaling) * y;

        transform.translate(translateX, translateY);
        transform.scale(scaling, scaling);
        repaint();


    }


    private static int i = 0;
    private static int j = 0;
    public void ZoomIn(){
        double prethodni = scaling;
        double sadasnji = scaling*scalingFactor;
        scaling = sadasnji/prethodni;



        if(scaling > 5){
            scaling = 5;
            i++;
        }
        System.out.println(scaling + "    zoom in");
        if(scaling < 5){
            setTransform();
            i = 0;
        }else if(scaling == 5 && i == 1){
            setTransform();
        }
    }

    public void ZoomOut(){
        double prethodni = scaling;
        double sadasnji = scaling/scalingFactor;
        scaling = sadasnji/prethodni;



        if(scaling < 0.2){
            scaling = 0.2;
            j++;
        }

        System.out.println(scaling + "    zoom out");
        if(scaling > 0.2){
            setTransform();
            j = 0;
        }else if(scaling == 0.2 && j == 1){
            setTransform();
        }
    }




}
