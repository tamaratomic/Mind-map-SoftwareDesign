package raf.dsw.gerumap.gui.swing.painter;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.RenameDialog;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PojamPainter extends ElementPainter{

    protected Stroke stroke = new BasicStroke();
    protected Paint paint = Color.CYAN;



    private Shape shape;

    public PojamPainter(Element element) {
        super(element);
    }


    @Override
    public void draw(Graphics2D g) {
        g.setPaint(paint);

        g.setStroke(stroke);
        g.draw(getShape());

        System.out.println("draw");

        g.fill(getShape());

        PojamElement element = (PojamElement) getElement();

        g.setColor(Color.black);
        g.drawOval(element.getWPosition(),element.getHPosition(),element.getXSize(), element.getYSize());

        if(element.getName() == " -"){
            RenameDialog rd = new RenameDialog(element);
            MainFrame.getInstance().getMapTree().refresh();
            rd.dispose();
            rd.setVisible(false);
        }

        g.drawString(element.getName(),element.getWPosition() + 50,element.getHPosition() + 50);

        g.setPaint(Color.BLACK);
//        g.drawString(element.getName(), element.getWPosition()+10,
//                element.getHPosition()+10);

    }

    @Override
    public boolean elementAt(int x, int y) {



        return this.getShape().contains(new Point(x,y));

    }

    public Shape getShape() {


        PojamElement element = (PojamElement) getElement();
        shape = new Ellipse2D.Double(element.getWPosition(),element.getHPosition(),element.getXSize(), element.getYSize());


        return shape;

    }


}
