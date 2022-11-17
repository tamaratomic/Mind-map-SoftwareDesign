package raf.dsw.gerumap.mapRepository;

import jdk.swing.interop.SwingInterOpUtils;
import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

@Setter
@Getter
public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer root;

    public MapRepositoryImpl() {


        this.root = new ProjectExplorer("ProjectExplorer");


    }



    @Override
    public ProjectExplorer getProjectExplorer() {
        return root;
    }
}
