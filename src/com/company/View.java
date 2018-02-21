package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    int screenWidth = 500;
    int screenHeight = 500;

    int buttonWidth = 100;
    int buttonHeight = 50;

    public Button helloworld;
    public JLabel hello;

    public View() {

        addButtons();
        addActions();

        getContentPane().setLayout(null);



        reload();
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        //setVisible(true);

    }


    public void addButtons() {

        helloworld = new Button("Play");
        hello = new JLabel("Hello World!");

    }

    public void addActions() {
        helloworld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Hello");
                getContentPane().add(hello);
                reload();

            }
        });

    }

    private void reload() {
        pack();
        setVisible(true);
        //setLocationRelativeTo(null);
        //setSize(screenWidth + 1 - 1, screenHeight);
        setTitle("PassMan (View Accounts)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
