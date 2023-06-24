import negocio.Genero;
import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraTaxaGordura;

public class CalculadoraTaxaGorduraTest {

    @Test
    public void calcularTaxaGordura_Feminino() {
        double imc = 25.0;
        Genero genero = Genero.FEMININO;
        int idade = 35;
        double taxaGorduraEsperada = 32.65;

        double taxaGorduraCalculada = CalculadoraTaxaGordura.calcularTaxaGordura(imc, genero, idade);

        Assert.assertEquals(taxaGorduraEsperada, taxaGorduraCalculada, 0.01);
    }

    @Test
    public void calcularTaxaGordura_Masculino() {
        double imc = 25.0;
        Genero genero = Genero.MASCULINO;
        int idade = 35;
        double taxaGorduraEsperada = 21.85;

        double taxaGorduraCalculada = CalculadoraTaxaGordura.calcularTaxaGordura(imc, genero, idade);

        Assert.assertEquals(taxaGorduraEsperada, taxaGorduraCalculada, 0.01);
    }
}
