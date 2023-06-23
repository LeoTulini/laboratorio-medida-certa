package serviços;

public class CalculadoraPesoIdeal {
    public static double calcularPesoIdeal(double altura, String sexo) {
        double k = sexo.equalsIgnoreCase("f") ? 2 : 4;
        return ((altura * 100) - 100) - (((altura * 100) - 150) / k);
    }
}
