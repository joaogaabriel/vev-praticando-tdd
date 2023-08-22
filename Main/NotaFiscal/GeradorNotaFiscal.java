package Main.NotaFiscal;

public class GeradorNotaFiscal {

    private NotaFiscalDao notaFiscalDao = new NotaFiscalDao();
    private SAP sap = new SAP();
    private Smtp smtp = new Smtp();

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

        NotaFiscal nf = new NotaFiscal(fatura.getCliente(), fatura.getValor(), imposto);

        notaFiscalDao.salva(nf);
        sap.envia(nf);

        return nf;
    }

    public NotaFiscalDao getNotaFiscalDao() {
        return notaFiscalDao;
    }

    public SAP getSAP() {
        return sap;
    }

    public Smtp getSmtp() {
        return smtp;
    }

}
