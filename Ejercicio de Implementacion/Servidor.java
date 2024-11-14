
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static void main(String[] args) {

        try {
            //Crear una instancia de la implementacion de la interfaz
            Interfaz ObjetoInterfaz = new Implementacion(); 
            //Crear un registro RMI en un puerto especifico
            Registry registro = LocateRegistry.createRegistry(4444);
            //Vincular el objeto remoto con un nombre especifico
            registro.rebind("Cliente", ObjetoInterfaz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
