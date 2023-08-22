package Main.NotaFiscal;

public class NotaFiscal {
    private String cliente;
    private double valor;
    private double imposto;

    public NotaFiscal(String cliente, double valor, double imposto) {
        this.cliente = cliente;
        this.valor = valor;
        this.imposto = imposto;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public double getImposto() {
        return imposto;
    }
}
