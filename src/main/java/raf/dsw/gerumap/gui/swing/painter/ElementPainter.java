package raf.dsw.gerumap.gui.swing.painter;

import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.awt.*;
import java.awt.geom.GeneralPath;

public abstract class ElementPainter {


    private Element element;

    public ElementPainter(Element element) {
        this.element = element;
    }

    public abstract void draw(Graphics2D g);

    public abstract void elementAt();

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }


}
