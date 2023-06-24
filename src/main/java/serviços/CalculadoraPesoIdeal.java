package serviços;

import negocio.Genero;

public class CalculadoraPesoIdeal {
    public static double calcularPesoIdeal(double altura, Genero genero) {
        double k = genero == Genero.FEMININO ? 2 : 4;
        return (altura - 100) - ((altura - 150) / k);
    }
}
