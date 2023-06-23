import org.junit.Assert;
import org.junit.Test;
import serviços.CalculadoraTaxaGordura;

public class CalculadoraTaxaGorduraTest {

    @Test
    public void calcularTaxaGordura_Feminino() {
        double imc = 22.5;
        String sexo = "F";
        int idade = 30;
        double taxaGorduraEsperada = 24.21;

        double taxaGorduraCalculada = CalculadoraTaxaGordura.calcularTaxaGordura(imc, sexo, idade);

        Assert.assertEquals(taxaGorduraEsperada, taxaGorduraCalculada, 0.01);
    }

    @Test
    public void calcularTaxaGordura_Masculino() {
        double imc = 25.0;
        String sexo = "M";
        int idade = 35;
        double taxaGorduraEsperada = 16.83;

        double taxaGorduraCalculada = CalculadoraTaxaGordura.calcularTaxaGordura(imc, sexo, idade);

        Assert.assertEquals(taxaGorduraEsperada, taxaGorduraCalculada, 0.01);
    }
}
