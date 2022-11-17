package raf.dsw.gerumap.messageGenerator;

import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImplementation implements MessageGenerator {

    List<ISubscriber> subscribers;

    @Override
    public void generateMessage(EventType eventType) {
        if(eventType == EventType.NAME_CANNOT_BE_EMPTY){
            notifyObs(new Message(1,"Greska prilikom dodele imena","Polje za ime ne moze biti prazno"));
        }
        if(eventType == EventType.NOTHING_SELECTED){
            notifyObs(new Message(2, "Greska prilikom selektovanja", "Nista nije selektovano"));
        }
        if(eventType == EventType.PROJECT_EXPLORER_CANNOT_BE_DELETED){
            notifyObs(new Message(1, "Greska prilikom brisanja", "Project explorer ne moze biti obrisan"));
        }
    }

    @Override
    public void addSubs(ISubscriber sub) {
        if(sub == null) {
            return;
        }
        if(this.subscribers ==null) {
            this.subscribers = new ArrayList<>();
        }
        if(this.subscribers.contains(sub)) {
            return;
        }
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubs(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifyObs(Object notif) {
        if(notif == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notif);
        }
    }
}
