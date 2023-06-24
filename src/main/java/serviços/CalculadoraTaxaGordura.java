package serviços;

import negocio.Genero;

public class CalculadoraTaxaGordura {
    public static double calcularTaxaGordura(double imc, Genero genero, int idade) {
        int s = genero == Genero.FEMININO ? 0 : 1;
        return (1.2 * imc) - (10.8 * s) + (0.23 * idade) - 5.4;
    }
}
