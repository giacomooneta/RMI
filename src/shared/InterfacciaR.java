package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InterfacciaR extends Remote {
    boolean add(Contatto peson) throws  RemoteException;
    boolean remove(String numt) throws RemoteException;
    List<Contatto> getContatti() throws RemoteException;
}