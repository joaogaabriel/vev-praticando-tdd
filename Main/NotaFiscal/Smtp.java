package Main.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class Smtp {

    private List<NotaFiscal> emailsEnviados = new ArrayList<>();

    public void envia(NotaFiscal nf) {
        emailsEnviados.add(nf);
        System.out.println("enviando por email");
    }

    public boolean contem(NotaFiscal nf) {
        return emailsEnviados.contains(nf);
    }
}
