import Main.Boleto.Boleto;
import Main.Boleto.Fatura;
import Main.Boleto.Enums.*;
import Main.Boleto.Processador;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static Main.Boleto.Enums.status.AGUARDANDO_PAGAMENTO;
import static Main.Boleto.Enums.status.PAGO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Boletos {

    private List<Boleto> boletosList = new ArrayList<>();


    @BeforeAll
    public void init() {
        Boleto boleto1 = new Boleto("0001", 500, "Pedro");
        Boleto boleto2 = new Boleto("0002", 400, "Jorge");
        Boleto boleto3 = new Boleto("0003", 600, "Felipe");

        boletosList.add(boleto1);
        boletosList.add(boleto2);
        boletosList.add(boleto3);
    }

    @Test
    @DisplayName("Testa pagamento bem sucedido")
    void testPagamentoSuccess(){
        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        Fatura fatura = new Fatura("25/01/2001", 1500, "Jorge");
        processadorDeBoletos.processaBoletos(boletosList, fatura);
        Assertions.assertEquals(PAGO, fatura.getStatus());

    }

    @Test
    @DisplayName("Testa pagamento não realizado")
    void testPagamentoFail(){
        ProcessadorDeBoletos processadorDeBoletos = new ProcessadorDeBoletos();
        Fatura fatura = new Fatura("25/01/2001", 3000, "Jorge");
        processadorDeBoletos.processaBoletos(boletosList, fatura);
        Assertions.assertEquals(AGUARDANDO_PAGAMENTO, fatura.getStatus());

    }
}