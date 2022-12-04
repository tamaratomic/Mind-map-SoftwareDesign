package raf.dsw.gerumap.observer;

public interface IPublisher {

    void addSubs(ISubscriber sub);
    void removeSubs(ISubscriber sub);
    void notifyObs(Object notif, Object not);
}
