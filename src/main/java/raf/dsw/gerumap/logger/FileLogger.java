package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.core.Logger;
import raf.dsw.gerumap.messageGenerator.Message;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileLogger implements Logger {




    @Override
    public void log(String poruka) {


        FileWriter fw = null;
        try {
            File f = new File("src/main/resources/FileLogger.txt");
            fw = new FileWriter(f);
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss").format(Calendar.getInstance().getTime());

            fw.append("[ERROR][" + timeStamp + "] " +poruka);
          //  writer.write("[ERROR][" + timeStamp + "] " +poruka);

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


      /* String path = getClass().getResource("/").toString();
        System.out.println(path);
        try {
            Files.write(Paths.get(path), "the text".getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }*/



    }

    @Override
    public void update(Object notif, Object notif2) {
        if(notif instanceof Message){
            Message msg = (Message)notif;
            log(msg.getTitle());
        }
    }
}
