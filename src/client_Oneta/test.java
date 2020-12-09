package client_Oneta;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class test {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Client c = new Client();
        c.pack();
        c.setVisible(true);
    }
}