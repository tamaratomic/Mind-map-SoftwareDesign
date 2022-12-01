package raf.dsw.gerumap.mapRepository.implementation;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PojamElement extends Element{

    private int xSize = 5;
    private int ySize = 3;
    private int wPosition;
    private int hPosition;


    public PojamElement(){
        super();
    }



}
