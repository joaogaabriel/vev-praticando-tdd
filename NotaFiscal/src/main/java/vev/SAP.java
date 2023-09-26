package NotaFiscal.src.main.java.vev;

import java.util.ArrayList;
import java.util.List;

public class SAP {

    private List<NotaFiscal> notasEnviadas = new ArrayList<>();

    public void envia(NotaFiscal nf) {
        notasEnviadas.add(nf);
        System.out.println("enviando pro sap");
    }

    public boolean contem(NotaFiscal nf) {
        return notasEnviadas.contains(nf);
    }
}
