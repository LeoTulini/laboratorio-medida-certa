package serviços;

import negocio.Genero;

public class CalculadoraIMC {
    public static double calcularIMC(double peso, double altura) {
        return peso / ((altura / 100) * (altura / 100));
    }

    public static String interpretarIMC(double imc, Genero genero) {
        if (genero == genero.FEMININO) {
            if (imc < 19.1) {
                return "Abaixo do Peso";
            } else if (imc >= 19.1 && imc <= 25.8) {
                return "Peso Ideal";
            } else {
                return "Obeso";
            }
        } else {
            if (imc < 20.7) {
                return "Abaixo do Peso";
            } else if (imc >= 20.7 && imc <= 26.4) {
                return "Peso Ideal";
            } else {
                return "Obeso";
            }
        }
    }
}
