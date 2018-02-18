package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame{

    int screenWidth = 500;
    int screenHeight = 500;

    int buttonWidth = 100;
    int buttonHeight = 50;

    public Button helloworld;
    public JLabel hello;
    static String[][] database = new String[100][4];    //This is the array that stores the info until quit
    public static String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*?-_+=~`<>,./ ";    //set string for the alphabet for encryption
    public static char[] alphabet = string.toCharArray();
    static File f = new File("savefile.txt");   //make the file object
    public static String path = f.getAbsolutePath();    //get file path (for use on different machines)
    public static char[] password;

    public Main() {

        addButtons();
        addActions();

        getContentPane().setLayout(null);

        helloworld.setBounds(screenWidth - buttonWidth - 250 + buttonWidth, screenWidth/2, buttonWidth, buttonHeight);
        hello.setBounds(230, screenHeight /2 - 40, buttonWidth, buttonHeight);

        getContentPane().add(helloworld);
        getContentPane().add(hello);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        setTitle("PassMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void addButtons() {

        helloworld = new Button("Play");
        hello = new JLabel("Hello World!");

    }

    public void addActions() {
        helloworld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().add(hello);
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

    public void write() {

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

    static String caesarEncrypt(char[] password, char[] phrase) {
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

    }
}
