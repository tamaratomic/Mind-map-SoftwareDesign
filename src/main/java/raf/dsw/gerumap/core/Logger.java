package raf.dsw.gerumap.core;

import raf.dsw.gerumap.observer.ISubscriber;

public interface Logger extends ISubscriber {
    void log(String poruka);
}
