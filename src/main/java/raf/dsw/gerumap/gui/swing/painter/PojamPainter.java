package raf.dsw.gerumap.gui.swing.painter;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.RenameDialog;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.PojamElement;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PojamPainter extends ElementPainter{



    private Shape shape;

    public PojamPainter(Element element) {
        super(element);
    }


    @Override
    public void draw(Graphics2D g) {
        PojamElement element = (PojamElement) getElement();

        if(element.getColor() == null){
            g.setPaint(Color.cyan);
        }else{
            g.setPaint(element.getColor());
        }


        g.setStroke(new BasicStroke(getElement().getStroke()));
        g.draw(getShape());



        g.fill(getShape());



        g.setColor(Color.black);
        g.drawOval(element.getWPosition(),element.getHPosition(),element.getXSize(), element.getYSize());


        /*if(element.getName() == " -"){
            RenameDialog rd = new RenameDialog(element);
            MainFrame.getInstance().getMapTree().refresh();
            rd.dispose();
            rd.setVisible(false);
        }*/

        g.drawString(element.getName(),element.getWPosition() + 50,element.getHPosition() + 50);


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
