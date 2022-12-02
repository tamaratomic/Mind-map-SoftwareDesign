package raf.dsw.gerumap.mapRepository.implementation;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VezaElement extends Element {

    private PojamElement odPojma;
    private PojamElement doPojma;

    public VezaElement(PojamElement odPojma, PojamElement doPojma) {
        this.odPojma = odPojma;
        this.doPojma = doPojma;
    }
}
