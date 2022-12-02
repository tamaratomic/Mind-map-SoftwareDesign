package raf.dsw.gerumap.mapRepository.implementation;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PojamElement extends Element{

    private int xSize = 150;
    private int ySize = 100;
    private int wPosition;
    private int hPosition;

    protected String text = "TEXT";


    public PojamElement(int wPosition, int hPosition){
        super();
        this.wPosition = wPosition;
        this.hPosition = hPosition;
    }



}
