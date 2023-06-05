package negocio;

public class Pessoa {
    private int codigo;
    private String nome;
    private String sexo;
    private int idade;
    private double peso;
    private double altura;

    public Pessoa(int codigo, String nome, String sexo, int idade, double peso, double altura) throws IllegalArgumentException {
        setCodigo(codigo);
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código inválido. O código deve ser maior que zero.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido. O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
            throw new IllegalArgumentException("Sexo inválido. O sexo deve ser 'M' ou 'F'.");
        }
        this.sexo = sexo.toUpperCase();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade inválida. A idade deve ser maior que zero.");
        }
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso inválido. O peso deve ser maior que zero.");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura inválida. A altura deve ser maior que zero.");
        }
        this.altura = altura;
    }
}
