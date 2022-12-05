package raf.dsw.gerumap.gui.swing.painter;

import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.VezaElement;

import java.awt.*;
import java.awt.geom.Line2D;

public class VezaPainter extends ElementPainter{


    protected Stroke stroke = new BasicStroke();
    protected Paint paint = Color.BLACK;
    private Shape shape;

    public VezaPainter(Element element) {
        super(element);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setPaint(paint);

        g.setStroke(stroke);
        g.draw(getShape());
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }

    public Shape getShape() {
        VezaElement element = (VezaElement) getElement();
        shape = new Line2D.Double(element.getStart().x ,element.getStart().y
                                        ,element.getEnd().x,
                                         element.getEnd().y);

        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
