import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            ConversorTemperatura conversor = new ConversorTemperaturaImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ConversorTemperaturaService", conversor);
            System.out.println("Servidor de conversión de temperatura listo");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
