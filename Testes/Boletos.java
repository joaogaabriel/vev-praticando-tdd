import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;

public class Boletos {

    @BeforeAll
    public void init() {
        Boleto boleto1 = new Boleto("0001", 500, "Gabriel");
        Boleto boleto2 = new Boleto("0002", 400, "Caio");
        Boleto boleto3 = new Boleto("0003", 600, "Felipe");

        List<Boleto> boletosList = new ArrayList<>();
        boletoList.add(boleto1);
        boletoList.add(boleto2);
        boletoList.add(boleto3);
    }

    @Test
    @DisplayName("Testa pagamento bem sucedido")
    void testPagamentoSuccess(){
        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        Fatura fatura = new Fatura(new Date(), 1500, "Caio");
        processadorDeBoletos.processaBoletos(boletosList);

    }

    @Test
    @DisplayName("Testa pagamento não realizado")
    void testPagamentoFail(){
        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        Fatura fatura = new Fatura(new Date(), 1500, "Caio");

    }
}