import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conectar con el registro y obtener la referencia remota
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculadora calculadora = (Calculadora) registry.lookup("CalculadoraService");

            // Lógica de entrada del usuario en un bucle
            Scanner scanner = new Scanner(System.in);
            String input;

            while (true) {
                System.out.println("\nSeleccione una operación: 1) Sumar 2) Restar 3) Multiplicar 4) Dividir o escriba 'salir' para terminar");
                input = scanner.next();

                if (input.equalsIgnoreCase("salir")) {
                    System.out.println("Cerrando el cliente...");
                    break;
                }

                int operacion = Integer.parseInt(input);

                System.out.print("Ingrese el primer número: ");
                double a = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                double b = scanner.nextDouble();

                double resultado = 0;
                try {
                    switch (operacion) {
                        case 1 -> resultado = calculadora.sumar(a, b);
                        case 2 -> resultado = calculadora.restar(a, b);
                        case 3 -> resultado = calculadora.multiplicar(a, b);
                        case 4 -> {
                            if (b == 0) {
                                System.out.println("Error: No se puede dividir por cero");
                                continue;
                            }
                            resultado = calculadora.dividir(a, b);
                        }
                        default -> System.out.println("Operación no válida");
                    }

                    System.out.println("Resultado: " + resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Error en la operación: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
