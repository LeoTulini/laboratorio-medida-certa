package negocio;

import java.util.List;

public class Pessoa {
    private static int ultimoCodigo = 0;
    private int codigo;
    private String nome;
    private Genero genero;
    private int idade;
    private double peso;
    private double altura;

    public Pessoa(String nome, Genero genero, int idade, double peso, double altura) {
        this.codigo = gerarNovoCodigo();
        validarNome(nome);
        validarGenero(genero);
        validarIdade(idade);
        validarPeso(peso);
        validarAltura(altura);
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    private static int gerarNovoCodigo() {
     ultimoCodigo++;
     return ultimoCodigo;
    }

    public static boolean idExiste(List<Pessoa> pessoas, int codigo) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero.name();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    private void validarNome(String name) throws  IllegalArgumentException{
        if (name == null || name.length() == 0){
            throw new IllegalArgumentException ("Não é permitido criar uma pessoa sem nome.");
        }
    }

    private void validarGenero(Genero genero){
        if(genero == null || !(genero.name().equalsIgnoreCase("MASCULINO") || genero.name().equalsIgnoreCase("FEMININO"))){
            throw new IllegalArgumentException ("Gênero inválido. O gênero deve ser 'MASCULINO' ou 'FEMININO'.");
        }
    }

    private void validarIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade inválida. A idade deve ser um valor positivo.");
        }
    }

    private void validarPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso inválido. O peso deve ser um valor positivo.");
        }
    }

    private void validarAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura inválida. A altura deve ser um valor positivo.");
        }
    }
}
