import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfacciaR extends Remote {
    boolean add(Contatto peson) throws  RemoteException;
    boolean remove(String numt) throws RemoteException;
    ArrayList<Contatto> searchN(String nome) throws RemoteException;
    Contatto searchT(String numt) throws RemoteException;
    ArrayList<Contatto> getContatti() throws RemoteException;
}