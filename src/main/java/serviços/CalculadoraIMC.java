package serviços;

public class CalculadoraIMC {
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura) * 10000;
    }

    public static String interpretarIMC(double imc, String sexo) {
        if (sexo.equalsIgnoreCase("f")) {
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
