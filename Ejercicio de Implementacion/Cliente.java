
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            //Obtener registro en el puerto
            Registry registro = LocateRegistry.getRegistry("localhost", 4444);
            //Crear instancia de la implementacion de la interfaz
            Interfaz objetoRemoto = (Interfaz) registro.lookup("Cliente");
            String mensaje = objetoRemoto.mensaje();
            double resultado = objetoRemoto.operacion(4, 5);

            System.out.println("Mensaje: " + mensaje);
            System.out.println("Operacion: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
