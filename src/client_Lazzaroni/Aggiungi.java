package client_Lazzaroni;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.*;
import net.miginfocom.swing.*;
import shared.Contatto;
import shared.InterfacciaR;
/*
 * Created by JFormDesigner on Tue Dec 08 15:54:26 CET 2020
 */



/**
 * @author Lazzaroni Luca
 */
public class Aggiungi extends JFrame {
    InterfacciaR rubricaService = (InterfacciaR) Naming.lookup("ServizioRubrica");
    public Aggiungi() throws RemoteException, NotBoundException, MalformedURLException {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) throws RemoteException {
        if(!textField1.getText().equals("") && !textField2.getText().equals("")){

            if(rubricaService.add(new Contatto(textField1.getText(),textField2.getText())) == false){
                System.out.println("errore");
            }
            else{
                new Client_Lazzaroni().setVisible(true);
                this.dispose();
            }

        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        new Client_Lazzaroni().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[120,fill]" +
            "[120,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Nome");
        contentPane.add(label1, "cell 0 1");

        //---- label2 ----
        label2.setText("Numero");
        contentPane.add(label2, "cell 1 1");
        contentPane.add(textField1, "cell 0 2");
        contentPane.add(textField2, "cell 1 2");

        //---- button1 ----
        button1.setText("Aggiungi");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            try {
                button1ActionPerformed(e);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        });
        contentPane.add(button1, "cell 0 3");

        //---- button2 ----
        button2.setText("Esci");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 1 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
