package raf.dsw.gerumap.logger;

import raf.dsw.gerumap.core.Logger;
import raf.dsw.gerumap.messageGenerator.Message;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileLogger implements Logger {
    @Override
    public void log(String poruka) {





      /* String path = getClass().getResource("/").toString();
        System.out.println(path);
        try {
            Files.write(Paths.get(path), "the text".getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }*/



    }

    @Override
    public void update(Object notif) {
        if(notif instanceof Message){
            Message msg = (Message)notif;
            log(msg.getTitle());
        }
    }
}
