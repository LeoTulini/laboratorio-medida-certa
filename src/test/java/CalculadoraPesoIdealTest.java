import negocio.Genero;
import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraPesoIdeal;

public class CalculadoraPesoIdealTest {

    @Test
    public void calcularPesoIdeal_Feminino() {
        double altura = 165.0;
        Genero genero = Genero.FEMININO;
        double pesoIdealEsperado = 57.5;

        double pesoIdealCalculado = CalculadoraPesoIdeal.calcularPesoIdeal(altura, genero);

        Assert.assertEquals(pesoIdealEsperado, pesoIdealCalculado, 0.001);
    }

    @Test
    public void calcularPesoIdeal_Masculino() {
        double altura = 180.0;
        Genero genero = Genero.MASCULINO;
        double pesoIdealEsperado = 72.5;

        double pesoIdealCalculado = CalculadoraPesoIdeal.calcularPesoIdeal(altura, genero);

        Assert.assertEquals(pesoIdealEsperado, pesoIdealCalculado, 0.001);
    }
}
