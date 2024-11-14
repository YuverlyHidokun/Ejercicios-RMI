import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            Calculadora calculadora = new CalculadoraImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculadoraService", calculadora);
            System.out.println("Servidor de calculadora listo");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
