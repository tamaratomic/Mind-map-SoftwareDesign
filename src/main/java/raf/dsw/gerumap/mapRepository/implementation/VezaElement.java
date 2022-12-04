package raf.dsw.gerumap.mapRepository.implementation;


import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class VezaElement extends Element {

    private PojamElement odPojma;
    private PojamElement doPojma;

    public VezaElement(){
        this.name = "Veza" + new Random().nextInt(100);
    }



    public VezaElement(PojamElement odPojma, PojamElement doPojma) {
        this.odPojma = odPojma;
        this.doPojma = doPojma;
        this.name = "Veza" + new Random().nextInt(100);
    }
}
