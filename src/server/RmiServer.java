package server;
import server.DB.DB_Manager;
import shared.Contatto;
import shared.InterfacciaR;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.List;

public class RmiServer extends UnicastRemoteObject implements InterfacciaR {
    // Costruttore
    public RmiServer() throws RemoteException {
        super();
    }

    // Implementazione dei metodi remoti dichiarati nell'interfaccia
    @Override
    public boolean add(Contatto peson) throws RemoteException {
        boolean check;
        check = DB_Manager.add_db(peson);
        return check;
    }

    @Override
    public boolean remove(String numt) throws RemoteException {
        boolean check;
        check = DB_Manager.remove_db(numt);
        return check;
    }

    @Override
    public List<Contatto> getContatti() throws RemoteException {
        return DB_Manager.getContatti_db();
    }


    public static void main(String[] args) {
        // Registrazione del servizio
        try {
            RmiServer serverRmi = new RmiServer();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("ServizioRubrica", serverRmi);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }


}