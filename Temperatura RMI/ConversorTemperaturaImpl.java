import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversorTemperaturaImpl extends UnicastRemoteObject implements ConversorTemperatura {

    protected ConversorTemperaturaImpl() throws RemoteException {
        super();
    }

    @Override
    public double celsiusAFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9 / 5) + 32;
    }

    @Override
    public double fahrenheitACelsius(double fahrenheit) throws RemoteException {
        return (fahrenheit - 32) * 5 / 9;
    }
}
