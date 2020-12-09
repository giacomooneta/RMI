package client_Lazzaroni;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Client_Lazzaroni c = new Client_Lazzaroni();
        c.pack();
        c.setVisible(true);
    }
}
