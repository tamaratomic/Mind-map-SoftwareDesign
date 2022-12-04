package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.core.Logger;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.messageGenerator.Message;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String poruka) {
        //  [ERROR][12.11.2022. 22:56] ProjectExplorer ne može biti obrisan.

        String timeStamp = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.println("[ERROR][" + timeStamp + "] " + poruka);
    }

    @Override
    public void update(Object notif, Object notif2) {
        if(notif instanceof Message){
            Message msg = (Message)notif;
            log(msg.getTitle());
        }
    }
}
