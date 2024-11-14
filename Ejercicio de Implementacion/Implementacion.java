
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacion extends UnicastRemoteObject implements  Interfaz{

    //Se necesita un contructor
    public Implementacion() throws RemoteException{
        super();
    }
    //Implementar los metodos indicados en la interfaz
    public  String mensaje () throws RemoteException{
        return "Hola, desde el servidor :3";
    }
    public double operacion (double a, double b){
        return a+b;
    }


}
