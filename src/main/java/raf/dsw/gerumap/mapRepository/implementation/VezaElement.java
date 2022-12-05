package raf.dsw.gerumap.mapRepository.implementation;


import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Random;

@Setter
@Getter
public class VezaElement extends Element {

    private PojamElement odPojma;
    private PojamElement doPojma;

    private Point start;

    private Point end;





    public VezaElement(PojamElement odPojma, PojamElement doPojma, Point start, Point end) {
        this.odPojma = odPojma;
        this.doPojma = doPojma;
        this.start = start;
        this.end = end;
        this.name = "Veza" + new Random().nextInt(100);
    }

    public VezaElement(){
        this.name = "Veza" + new Random().nextInt(100);
    }


}
