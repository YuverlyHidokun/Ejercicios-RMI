import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conectar con el registro y obtener la referencia remota
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ConversorTemperatura conversor = (ConversorTemperatura) registry.lookup("ConversorTemperaturaService");

            // Lógica de entrada del usuario en un bucle
            Scanner scanner = new Scanner(System.in);
            String input;

            while (true) {
                System.out.println("\nSeleccione la conversión: 1) Celsius a Fahrenheit 2) Fahrenheit a Celsius o escriba 'salir' para terminar");
                input = scanner.next();

                if (input.equalsIgnoreCase("salir")) {
                    System.out.println("Cerrando el cliente...");
                    break;
                }

                int opcion = Integer.parseInt(input);

                System.out.print("Ingrese la temperatura: ");
                double temperatura = scanner.nextDouble();

                double resultado = 0;
                switch (opcion) {
                    case 1 -> resultado = conversor.celsiusAFahrenheit(temperatura);
                    case 2 -> resultado = conversor.fahrenheitACelsius(temperatura);
                    default -> System.out.println("Opción no válida");
                }

                System.out.println("Resultado: " + resultado);
            }

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
