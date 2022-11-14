package raf.dsw.gerumap.msggenerator.model;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.msggenerator.EventType;

import java.sql.Timestamp;

@Getter
@Setter
public class Message {

    private String message;
    private EventType type;
    private Timestamp time;


    public Message(String message, EventType type, Timestamp time) {
        this.message = message;
        this.type = type;
        this.time = time;
    }





}
