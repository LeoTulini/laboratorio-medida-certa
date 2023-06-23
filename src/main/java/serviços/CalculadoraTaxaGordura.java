package serviços;

public class CalculadoraTaxaGordura {
    public static double calcularTaxaGordura(double imc, String genero, int idade) {
        int s = genero.equalsIgnoreCase("FEMININO") ? 0 : 1;
        return (1.2 * imc) - (10.8 * s) + (0.23 * idade) - 5.4;
    }
}
