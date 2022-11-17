package raf.dsw.gerumap.messageGenerator;

public class Message {

    private int type;
    private String message;
    private String title;

    public Message(int type, String message, String title) {
        this.type = type;
        this.message = message;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
