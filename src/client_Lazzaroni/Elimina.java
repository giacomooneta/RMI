package client_Lazzaroni;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.*;
import net.miginfocom.swing.*;
import shared.InterfacciaR;
/*
 * Created by JFormDesigner on Tue Dec 08 16:55:14 CET 2020
 */



/**
 * @author Lazzaroni Luca
 */
public class Elimina extends JFrame {
    InterfacciaR rubricaService = (InterfacciaR) Naming.lookup("ServizioRubrica");
    public Elimina() throws RemoteException, NotBoundException, MalformedURLException {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) throws RemoteException {
        if(!textField1.getText().equals("")){

            if(!rubricaService.remove(textField1.getText())){
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
        textField1 = new JTextField();
        label1 = new JLabel();
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
            "[]"));
        contentPane.add(textField1, "cell 0 1");

        //---- label1 ----
        label1.setText("Numero");
        contentPane.add(label1, "cell 1 1");

        //---- button1 ----
        button1.setText("Elimina");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        });
        contentPane.add(button1, "cell 0 2");

        //---- button2 ----
        button2.setText("Esci");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 1 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
    private JTextField textField1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
