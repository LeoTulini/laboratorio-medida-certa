import org.junit.Assert;
import serviços.CalculadoraIMC;

public class CalculadoraIMCTest {

    public static void deveCalcularCorretamenteOIMC() {

        double imc = CalculadoraIMC.calcularIMC(83, 1.75);

        double esperado = 27.1;

        Assert.assertEquals(imc, esperado);
    }

}
