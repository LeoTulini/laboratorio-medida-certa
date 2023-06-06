import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraIMC;

public class CalculadoraIMCTest {

    @Test
    public void deveCalcularCorretamenteOIMC() {

        Assert.assertEquals(CalculadoraIMC.calcularIMC(83, 175), 27.1, .01);
    }

    @Test
    public void deveInterpretarOIMCCorretamenteQuandoAbaixoDoPesoMasculino() {

        Assert.assertEquals(CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(63, 175), "m"), "Abaixo do Peso");
    }

    @Test
    public void deveInterpretarOIMCCorretamenteQuandoPesoIdealMasculino() {

        Assert.assertEquals(CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(73, 175), "m"), "Peso Ideal");
    }

    @Test
    public void deveInterpretarOIMCCorretamenteQuandoObesoMasculino() {

        Assert.assertEquals(CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(83, 175), "m"), "Obeso");
    }

    @Test
    public void deveInterpretarOIMCCorretamenteQuandoAbaixoDoPesoFeminino() {

        Assert.assertEquals(CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(53, 175), "f"), "Abaixo do Peso");
    }

    @Test
    public void deveInterpretarOIMCCorretamenteQuandoPesoIdealFeminino() {

        Assert.assertEquals(CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(63, 175), "f"), "Peso Ideal");
    }

    @Test
    public void deveInterpretarOIMCCorretamenteQuandoObesoFeminino() {

        Assert.assertEquals(CalculadoraIMC.interpretarIMC(CalculadoraIMC.calcularIMC(83, 175), "f"), "Obeso");
    }

}
