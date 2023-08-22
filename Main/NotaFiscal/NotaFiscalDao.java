package Main.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDao {

	private List<NotaFiscal> notasFiscais = new ArrayList<>();

	public void salva(NotaFiscal nf) {
		notasFiscais.add(nf);
		System.out.println("salvando no banco");
	}

	public boolean contem(NotaFiscal nf) {
		return notasFiscais.contains(nf);
	}
}
