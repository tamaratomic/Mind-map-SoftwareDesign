package raf.dsw.gerumap.mapRepository;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer root;

    public MapRepositoryImpl() {
        this.root = new ProjectExplorer("ProjectExplorer");
    }



    public void setRoot(ProjectExplorer root) {
        this.root = root;
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return root;
    }
}
