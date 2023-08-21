package vev;

public class GeradorNotaFiscal {
    public NotaFiscal gera(Fatura fatura) {
        double imposto = 0.0;

        switch (fatura.getTipoServico()) {
            case "CONSULTORIA":
                imposto = fatura.getValor() * 0.25;
                break;
            case "TREINAMENTO":
                imposto = fatura.getValor() * 0.15;
                break;
            default:
                imposto = fatura.getValor() * 0.06;
                break;
        }

        return new NotaFiscal(fatura.getCliente(), fatura.getValor(), imposto);
    }
}
