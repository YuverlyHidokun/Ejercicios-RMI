import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

    protected CalculadoraImpl() throws RemoteException {
        super();
    }

    @Override
    public double sumar(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double restar(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) throws RemoteException {
        if (b == 0) throw new ArithmeticException("No se puede dividir por cero");
        return a / b;
    }
}
