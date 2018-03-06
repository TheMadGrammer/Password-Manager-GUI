/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kthsd_0
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public static String[][] database = new String[100][4];    //This is the array that stores the info until quit
    public static final String STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*?-_+=~`<>,./ ";    //set string for the alphabet for encryption
    public static char[] alphabet = STRING.toCharArray();
    static File f = new File("savefile.txt");   //make the file object
    public static String path = f.getAbsolutePath();    //get file path (for use on different machines)
    public static char[] password;
    public boolean delete = false;
    
    /**
     * Creates new form NewJFrame
     */
    public Main() {
        initComponents();
    }
    
    public static void moveLastup(String[] arr, int pos) {
    String last = arr[arr.length-1];

    // Copy sub-array starting at pos to pos+1
    System.arraycopy(arr, pos, arr, pos - 1, arr.length - pos + 1);

    arr[pos] = last;
}
    
    public void remove() {
        
        boolean found = false;
        String search = List.getSelectedValue();
        
        for (int i = 0; i < database.length; i++) {
			if (database[i][0] != null && database[i][0].equals(search)) {
				found = true;
                                int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account? Deletion is permenant!", "Delete", JOptionPane.YES_NO_OPTION);
				if (p == 0) {
					database[i][0] = null;
					database[i][1] = null;
					database[i][2] = null;
//                                        for (int j = 0; j < database.length; j++) {
//                                            if (database[j][0] == null) {
//                                                moveLastup(database[0], j + 1);
//                                            }
//                                        }
                                        List.clearSelection();
				} else {
					break;
				}
				break;
			}
		}
		if (!found) {
		    JOptionPane.showMessageDialog(null, "The account you searched for was not found.");
        }
                try {
            Main.write();
        } catch (IOException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileData.readFile();
        List.clearSelection();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PassMan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        List.setModel(new javax.swing.AbstractListModel<String>() {
            String[][] strings = Main.database;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i][0]; }
        });
        jScrollPane1.setViewportView(List);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RemoveButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(AddButton)
                        .addGap(18, 18, 18)
                        .addComponent(RemoveButton)
                        .addGap(18, 18, 18)
                        .addComponent(EditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(ExitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddAccount account = new AddAccount();
                account.setLocationRelativeTo(null);
                account.setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        remove();
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        try {
            write();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        
        ViewAccount.tempAccount = List.getSelectedValue();
        if (List.getSelectedValue() != null) {
            for (int i = 0; i < database.length; i++) {
                if (database[i][0] != null && database[i][0].equals(ViewAccount.tempAccount)) {
                    ViewAccount.tempUser = database[i][1];
                    ViewAccount.tempPass = database[i][2];
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select an account to be updated.");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewAccount view = new ViewAccount();
                view.setLocationRelativeTo(null);
                view.setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_EditButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            write();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JList<String> List;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
