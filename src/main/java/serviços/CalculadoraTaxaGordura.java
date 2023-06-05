package serviços;

public class CalculadoraTaxaGordura {
    public static double calcularTaxaGordura(double imc, String sexo, int idade) {
        int s = sexo.equalsIgnoreCase("f") ? 0 : 1;
        return (1.2 * imc) - (10.8 * s) + (0.23 * idade) - 5.4;
    }
}
