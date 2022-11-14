package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorDialog extends JDialog {


    public AuthorDialog(MapTreeItem project){

        setTitle("Author");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel jPanel = new JPanel(new BorderLayout());

        jPanel.add(new JLabel(project.getMapNode().getName()),BorderLayout.NORTH);
        TextField textField = new TextField();
        if(project.getAuthor() != null){
            textField.setText(project.getAuthor());
        }

        jPanel.add(textField, BorderLayout.CENTER);

        JButton saveButton = new JButton("SAVE");

        jPanel.add(saveButton, BorderLayout.AFTER_LAST_LINE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                project.setAuthor(textField.getText());
                dispose();
            }
        });


        this.add(jPanel);
        this.pack();
        setVisible(true);

    }


}
