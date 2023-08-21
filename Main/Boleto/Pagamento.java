package Main.Boleto;
import Main.Boleto.Enums.status;
import Main.Boleto.Enums.tipo;
import java.util.Date;

public class Pagamento {
    private double valor;

    private Date data;

    private tipo tipoPagamento;

    private Fatura fatura;

    public Pagamento(double valor, Date data, tipo tipoPagamento, Fatura fatura) {
        this.valor = valor;
        this.data = data;
        this.tipoPagamento = tipoPagamento;
        this.fatura = fatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public tipo getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(tipo tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
