package client_Lazzaroni;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;
import shared.Contatto;
import shared.InterfacciaR;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
/*
 * Created by JFormDesigner on Tue Dec 08 17:08:24 CET 2020
 */



/**
 * @author Lazzaroni Luca
 */
public class Tabella extends JFrame {
    InterfacciaR rubricaService = (InterfacciaR) Naming.lookup("ServizioRubrica");
    public Tabella() throws RemoteException, NotBoundException, MalformedURLException {
        initComponents();
        riempi(rubricaService.getContatti(),table1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void button1ActionPerformed(ActionEvent e) {
        new Client_Lazzaroni().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[120,fill]" +
            "[fill]" +
            "[120,fill]",
            // rows
            "[256]"));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Nome", "Numero"
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 0");

        //---- button1 ----
        button1.setText("Esci");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, "cell 2 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lazzaroni Luca
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void riempi(List<Contatto> lista, JTable table){
        for(int i = 0;i<lista.size();i++){
            Contatto c = lista.get(i);
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{
                c.getNome(),c.getNum()
            });
        }
    }
}
