import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraPesoIdeal;

public class CalculadoraPesoIdealTest {

    @Test
    public void calcularPesoIdeal_Feminino() {
        double altura = 165.0;
        String sexo = "F";
        double pesoIdealEsperado = 52.5;

        double pesoIdealCalculado = CalculadoraPesoIdeal.calcularPesoIdeal(altura, sexo);

        Assert.assertEquals(pesoIdealEsperado, pesoIdealCalculado, 0.001);
    }

    @Test
    public void calcularPesoIdeal_Masculino() {
        double altura = 180.0;
        String sexo = "M";
        double pesoIdealEsperado = 70.0;

        double pesoIdealCalculado = CalculadoraPesoIdeal.calcularPesoIdeal(altura, sexo);

        Assert.assertEquals(pesoIdealEsperado, pesoIdealCalculado, 0.001);
    }
}
