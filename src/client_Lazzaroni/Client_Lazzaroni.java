package client_Lazzaroni;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Tue Dec 08 17:36:41 CET 2020
 */



/**
 * @author Lazzaroni Luca
 */
public class Client_Lazzaroni extends JFrame {
    public Client_Lazzaroni() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) throws RemoteException, NotBoundException, MalformedURLException {
        new Aggiungi().setVisible(true);
        this.dispose();
    }

    private void button2ActionPerformed(ActionEvent e) throws RemoteException, NotBoundException, MalformedURLException {
        new Elimina().setVisible(true);
        this.dispose();
    }

    private void button3ActionPerformed(ActionEvent e) throws RemoteException, NotBoundException, MalformedURLException {
        new Tabella().setVisible(true);
        this.dispose();
    }

    private void button4ActionPerformed(ActionEvent e) {
        System.exit(1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[120,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- button1 ----
        button1.setText("Aggiungi");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            } catch (NotBoundException notBoundException) {
                notBoundException.printStackTrace();
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        contentPane.add(button1, "cell 0 0");

        //---- button2 ----
        button2.setText("Rimuovi");
        button2.addActionListener(e -> {
            try {
                button2ActionPerformed(e);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            } catch (NotBoundException notBoundException) {
                notBoundException.printStackTrace();
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        contentPane.add(button2, "cell 0 1");

        //---- button3 ----
        button3.setText("Elenco Contatti");
        button3.addActionListener(e -> {
            try {
                button3ActionPerformed(e);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            } catch (NotBoundException notBoundException) {
                notBoundException.printStackTrace();
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });
        contentPane.add(button3, "cell 0 2");

        //---- button4 ----
        button4.setText("Esci");
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4, "cell 0 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
