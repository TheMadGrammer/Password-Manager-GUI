package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame{

    int screenWidth = 300;
    int screenHeight = 500;

    int buttonWidth = 100;
    int buttonHeight = 50;

    public Button addaccount, view;
    public static String[][] database = new String[100][4];    //This is the array that stores the info until quit
    public static String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*?-_+=~`<>,./ ";    //set string for the alphabet for encryption
    public static char[] alphabet = string.toCharArray();
    static File f = new File("savefile.txt");   //make the file object
    public static String path = f.getAbsolutePath();    //get file path (for use on different machines)
    public static char[] password;

    public Main() {

        addButtons();
        addActions();

        getContentPane().setLayout(null);

        addaccount.setBounds(5, screenWidth / 2, buttonWidth, buttonHeight);
        view.setBounds(screenWidth - buttonWidth - 10, screenWidth/2, buttonWidth, buttonHeight);

        getContentPane().add(addaccount);
        getContentPane().add(view);

        reload();
        setVisible(true);

    }

   private void reload() {

        pack();
        //setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        setTitle("PassMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void addButtons() {

        addaccount = new Button("Add Accounts");
        view = new Button("View Accounts");

    }

    public void addActions() {
        addaccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAccount();
            }
        });
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View();
            }
        });

    }

    public void addAccount () {

    }

    public void search() {

    }

    public void delete() {

    }

    public void update() {

    }

    public static void write() throws IOException {

        FileWriter file = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(file);
        writer.write("");
        for (int i = 0; i < database.length; i++) {
            if (database[i][0] != null) {
                //caesarEncrypt();
                writer.append(caesarEncrypt(password, database[i][0].toCharArray()) + "\n");
                writer.append(caesarEncrypt(password, database[i][1].toCharArray()) + "\n");
                writer.append(caesarEncrypt(password, database[i][2].toCharArray()) + "\n");
            }
        }
        writer.close();
        file.close();

    }

    public static int getIndex(char c) {
        boolean found;
        int i = 0;
        while (true) {
            if (c == alphabet[i]) {
                found = true;
                break;
            }
            i++;
        }
        if (found) {
            return i;
        } else {
            return 0;
        }
    }

    public static int  wrapInt(int x) {
        while (x < 0) {
            x += alphabet.length;
        }
        while (x > alphabet.length - 1) {
            x -= alphabet.length;
        }
        return x;
    }

    public static char encryptChar(char c, int shift) {
        int location = getIndex(c);
        location += shift;
        location = wrapInt(location);
        return alphabet[location];
    }

    public static String caesarEncrypt(char[] password, char[] phrase) {
        int key = 0;
        String encrypted = "";
        for (int i = 0; i < password.length; i++) {
            key += (int)password[i];
        }
        key = key % 26;

        for (int i = 0; i < phrase.length; i++) {
            encrypted += encryptChar(phrase[i], key);	}


        return encrypted;
    }

    public static String caesarDecrypt(char[] password, char[] phrase) {
        int key = 0;
        String decrypted = "";
        for (int i = 0; i < password.length; i++) {
            key += (int)password[i];
        }
        key = key % 26;
        key = key * -1;

        for (int i = 0; i < phrase.length; i++) {
            decrypted += encryptChar(phrase[i], key);
        }

        return decrypted;
    }

    public static void main(String[] args) {

       new Main();
       //new AddAccount();

        try {
            write();
        } catch (IOException io) {

        }



    }
}
