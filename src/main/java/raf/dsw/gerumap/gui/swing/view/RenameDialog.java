package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenameDialog extends JDialog {


    public RenameDialog(Element element){

        setTitle("Pojam");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jPanel = new JPanel(new BorderLayout());

        jPanel.add(new JLabel("Unesite naziv pojma"), BorderLayout.NORTH);

        TextField textField = new TextField();
        jPanel.add(textField, BorderLayout.CENTER);

        JButton saveButton = new JButton("SAVE");

        jPanel.add(saveButton, BorderLayout.AFTER_LAST_LINE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!textField.getText().toString().equalsIgnoreCase("")){
                    element.setName(textField.getText());
                    System.out.println(element.getName());
                    dispose();
                }else{
                    System.out.println("UNESITE IME STRINGA");
                }
            }
        });


        this.add(jPanel);
        this.pack();
        this.setModal(true);
        setVisible(true);



    }



    public RenameDialog(MapTreeItem item){

        setTitle("Rename");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel jPanel = new JPanel(new BorderLayout());

        jPanel.add(new JLabel("Set new name for: "+ item.getMapNode().getName()),BorderLayout.NORTH);
        TextField textField = new TextField();
        if(item.getAuthor() != null){
            textField.setText(item.getAuthor());
        }

        jPanel.add(textField, BorderLayout.CENTER);

        JButton saveButton = new JButton("SAVE");

        jPanel.add(saveButton, BorderLayout.AFTER_LAST_LINE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                item.setName(textField.getText());
                dispose();
            }
        });


        this.add(jPanel);
        this.pack();
        setVisible(true);

    }
}
