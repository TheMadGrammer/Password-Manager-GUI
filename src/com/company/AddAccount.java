package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccount extends JFrame {

    int screenWidth = 300;
    int screenHeight = 500;

    int buttonWidth = 100;
    int buttonHeight = 50;

    int fieldWidth = 150;
    int fieldHeight = 25;

    public Button add;
    public JTextField account, user, pass;
    public JLabel accountLabel, userLabel, passLabel;

    public AddAccount() {

        addButtons();
        addActions();

        getContentPane().setLayout(null);

        add.setBounds(screenWidth / 2 - buttonWidth / 2, 300, buttonWidth, buttonHeight);
        account.setBounds(screenWidth / 2 - fieldWidth / 2, 100, fieldWidth, fieldHeight);
        user.setBounds(screenWidth / 2 - fieldWidth / 2, 175, fieldWidth, fieldHeight);
        pass.setBounds(screenWidth / 2 - fieldWidth / 2, 250, fieldWidth, fieldHeight);
        accountLabel.setBounds(screenWidth / 2 - fieldWidth / 2, 75, fieldWidth, fieldHeight);

        getContentPane().add(add);
        getContentPane().add(account);
        getContentPane().add(user);
        getContentPane().add(pass);
        getContentPane().add(accountLabel);

        reload();
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        //setVisible(true);

    }


    public void addButtons() {

        add = new Button("Add");
        account = new JTextField("");
        user = new JTextField("");
        pass = new JTextField("");
        accountLabel = new JLabel("Account Name:");
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");

    }

    public void addActions() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Account: " + account.getText());
                System.out.println("User: " + user.getText());
                System.out.println("Pass: " + pass.getText());

                addAccount(account.getText(), user.getText(), pass.getText());

            }
        });

    }

    private void reload() {
        pack();
        //setVisible(true);
        //setLocationRelativeTo(null);
        //setSize(screenWidth + 1 - 1, screenHeight);
        //setTitle("PassMan (Add Account)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }

    void addAccount(String account, String user, String pass) {

        String[] toAdd = new String[3];

        toAdd[0] = account;
        toAdd[1] = user;
        toAdd[2] = pass;

        for (int i = 0; i < Main.database.length; i++) {
            if (Main.database[i][0] == null) {
                Main.database[i][0] = toAdd[0];
                Main.database[i][1] = toAdd[1];
                Main.database[i][2] = toAdd[2];
                break;
            }
        }
    }

}
