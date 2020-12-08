package client;

import shared.Contatto;
import shared.InterfacciaR;

import java.awt.event.*;

//import server.shared.Contatto;
//import server.shared.InterfacciaR;

import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Giacomo Oneta
 */
class Client extends JFrame{
    List<Contatto> lista;
    InterfacciaR echoService = (InterfacciaR) Naming.lookup("ServizioRubrica");

    public Client() throws RemoteException, NotBoundException, MalformedURLException {
        initComponents();
        setContentPane(finestra);
        lista = echoService.getContatti();
        fillTable(lista,tabella);
    }

    private void button3ActionPerformed(ActionEvent e) {
        System.exit(1);
    }

    private void button6ActionPerformed(ActionEvent e) throws RemoteException {
        if(echoService.add(createContatto(textField2.getText(),textField3.getText())) == true){
            lista = echoService.getContatti();
            fillTable(lista,tabella);
        }
        else
            System.out.println("Error");
    }

    private void button5ActionPerformed(ActionEvent e) throws RemoteException {
        if(echoService.remove(textField3.getText()) == true){
            lista = echoService.getContatti();
            fillTable(lista,tabella);
        }
        else{
            System.out.println("Error");
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        search(textField2.getText(), textField3.getText());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Giacomo Oneta
        finestra = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        tabella = new JTable();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        textField2 = new JTextField();
        textField3 = new JTextField();
        buttonBar = new JPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== finestra ========
        {
            finestra.setBorder(new EmptyBorder(12, 12, 12, 12));
            finestra.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
                    . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
                    . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
                    awt .Font .BOLD ,12 ), java. awt. Color. red) ,finestra. getBorder( )) )
            ; finestra. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
            finestra.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {

                    //---- tabella ----
                    tabella.setModel(new DefaultTableModel(
                            new Object[][] {
                            },
                            new String[] {
                                    "Nome", "Numero"
                            }
                    ));
                    scrollPane1.setViewportView(tabella);
                }

                //---- button3 ----
                button3.setText("Esci");
                button3.addActionListener(e -> button3ActionPerformed(e));

                //---- button4 ----
                button4.setText("Cerca");
                button4.addActionListener(e -> button4ActionPerformed(e));

                //---- button5 ----
                button5.setText("Rimuovi");
                button5.addActionListener(e -> {
                    try {
                        button5ActionPerformed(e);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                });

                //---- button6 ----
                button6.setText("Aggiungi");
                button6.addActionListener(e -> {
                    try {
                        button6ActionPerformed(e);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                });

                //---- textField2 ----
                textField2.setToolTipText("Numero");
                textField2.setText("Nome");

                //---- textField3 ----
                textField3.setToolTipText("Nome");
                textField3.setText("Numero");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                                                        .addContainerGap())
                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                        .addComponent(button6)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(button5)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(button4)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(button3))))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button3)
                                                .addComponent(button4)
                                                .addComponent(button5)
                                                .addComponent(button6)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap())
                );
            }
            finestra.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < buttonBar.getComponentCount(); i++) {
                        Rectangle bounds = buttonBar.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = buttonBar.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    buttonBar.setMinimumSize(preferredSize);
                    buttonBar.setPreferredSize(preferredSize);
                }
            }
            finestra.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(finestra, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Giacomo Oneta
    private JPanel finestra;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable tabella;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel buttonBar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void fillTable(List<Contatto> lista, JTable tabella){
        DefaultTableModel dm = (DefaultTableModel) tabella.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }

        for (int i = 0; i<lista.size();i++){
            Contatto util = lista.get(i);
            ((DefaultTableModel) tabella.getModel()).addRow(new Object[]{
                    util.getNome(), util.getNum()
            });
        }
    }


    public Contatto createContatto(String name, String number){
        Contatto j = new Contatto(name, number);
        return j;
    }


    public void search(String nome, String numero) {
        if (nome.equals("") && numero.equals("")) {
            fillTable(lista, tabella);
            Error error = new Error();
            error.pack();
            error.setVisible(true);
        } if(nome.equals("")){
            ArrayList<shared.Contatto> appoggio = new ArrayList<>();
            for (int i = 0; i<lista.size();i++){
                if(numero.equals(lista.get(i).getNum())){
                    appoggio.add(lista.get(i));
                }
            }
            fillTable(appoggio,tabella);
        }else
        if(numero.equals("")){
            ArrayList<shared.Contatto> appoggio = new ArrayList<>();
            for (int i = 0; i<lista.size();i++){
                if(nome.equals(lista.get(i).getNome())){
                    appoggio.add(lista.get(i));
                }
            }
            fillTable(appoggio,tabella);
        }
        else{
            fillTable(lista,tabella);
            Error2 error2 = new Error2();
            error2.pack();
            error2.setVisible(true);
        }
        /*List<Contatto> appoggio = new ArrayList<>();
        for(int i=0; i<lista.size();i++){
            if(lista.get(i).getNum().equals(textField2.getText()) && textField3.getText().isEmpty()){
                appoggio.add(lista.get(i));
            }
            if(lista.get(i).getNome().equals(textField3.getText()) && textField2.getText().isEmpty()){
                appoggio.add(lista.get(i));
            }
            if(lista.get(i).getNum().equals(textField2.getText()) && lista.get(i).getNome().equals(textField3.getText())){
                appoggio.add(lista.get(i));
            }
        }
        if(appoggio.isEmpty()){
            fillTable(lista,tabella);
            Error2 error2 = new Error2();
            error2.pack();
            error2.setVisible(true);
        }*/
    }

}



