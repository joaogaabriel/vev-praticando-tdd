package Main.NotaFiscal;

public class Fatura {
    private String cliente;
    private String endereco;
    private String tipoServico;
    private double valor;

    public Fatura(String cliente, String endereco, String tipoServico, double valor) {
        this.cliente = cliente;
        this.endereco = endereco;
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public double getValor() {
        return valor;
    }
}
