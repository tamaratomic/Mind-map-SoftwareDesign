package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {

    public AboutDialog() {

        setTitle("About developers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel lbl1 = new JLabel("Ignjat Krdzavac RN 115/2020");


        JLabel lbl2 = new JLabel("Tamara Tomic RN 113/2020");


        panel.add(lbl1,BorderLayout.NORTH);
        panel.add(lbl2,BorderLayout.AFTER_LAST_LINE);



        this.add(panel);
        this.pack();
        setVisible(true);

    }
}
