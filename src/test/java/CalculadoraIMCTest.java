import negocio.Genero;
import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraIMC;

public class CalculadoraIMCTest {

    @Test
    public void calcularIMC_Valido() {
        double peso = 80.5;
        double altura = 175.0;
        double imcEsperado = 26.285714285714285;

        double imcCalculado = CalculadoraIMC.calcularIMC(peso, altura);

        Assert.assertEquals(imcEsperado, imcCalculado, 0.001);
    }

    @Test
    public void interpretarIMC_Feminino_AbaixoPeso() {
        double imc = 17.0;
        Genero genero = Genero.MASCULINO;
        String interpretacaoEsperada = "Abaixo do Peso";

        String interpretacaoCalculada = CalculadoraIMC.interpretarIMC(imc, genero);

        Assert.assertEquals(interpretacaoEsperada, interpretacaoCalculada);
    }

    @Test
    public void interpretarIMC_Feminino_PesoIdeal() {
        double imc = 22.5;
        Genero genero = Genero.FEMININO;
        String interpretacaoEsperada = "Peso Ideal";

        String interpretacaoCalculada = CalculadoraIMC.interpretarIMC(imc, genero);

        Assert.assertEquals(interpretacaoEsperada, interpretacaoCalculada);
    }

    @Test
    public void interpretarIMC_Feminino_Obeso() {
        double imc = 30.0;
        Genero genero = Genero.FEMININO;
        String interpretacaoEsperada = "Obeso";

        String interpretacaoCalculada = CalculadoraIMC.interpretarIMC(imc, genero);

        Assert.assertEquals(interpretacaoEsperada, interpretacaoCalculada);
    }

    @Test
    public void interpretarIMC_Masculino_AbaixoPeso() {
        double imc = 19.5;
        Genero genero = Genero.MASCULINO;
        String interpretacaoEsperada = "Abaixo do Peso";

        String interpretacaoCalculada = CalculadoraIMC.interpretarIMC(imc, genero);

        Assert.assertEquals(interpretacaoEsperada, interpretacaoCalculada);
    }

    @Test
    public void interpretarIMC_Masculino_PesoIdeal() {
        double imc = 23.0;
        Genero genero = Genero.MASCULINO;
        String interpretacaoEsperada = "Peso Ideal";

        String interpretacaoCalculada = CalculadoraIMC.interpretarIMC(imc, genero);

        Assert.assertEquals(interpretacaoEsperada, interpretacaoCalculada);
    }

    @Test
    public void interpretarIMC_Masculino_Obeso() {
        double imc = 28.0;
        Genero genero = Genero.MASCULINO;
        String interpretacaoEsperada = "Obeso";

        String interpretacaoCalculada = CalculadoraIMC.interpretarIMC(imc, genero);

        Assert.assertEquals(interpretacaoEsperada, interpretacaoCalculada);
    }
}
