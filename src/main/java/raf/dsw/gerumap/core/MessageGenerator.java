package raf.dsw.gerumap.core;

import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.observer.IPublisher;

public interface MessageGenerator extends IPublisher {
        void generateMessage(EventType eventType);
}
