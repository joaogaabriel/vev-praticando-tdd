package Main.Boleto;

public class Boleto {

    private String data;

    private double valor;

    private String nome;

    public Boleto(String data, double valor, String nome) {
        this.data = data;
        this.valor = valor;
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
