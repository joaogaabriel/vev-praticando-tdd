import Main.Boleto.*;
import Main.Boleto.Enums.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class BoletosTest {

    @Test
    @DisplayName("Valor Limite Inferior: 1499")
    void testValorLimiteInferior() {
        testScenario(1500, new double[] { 500, 400, 599 }, status.AGUARDANDO_PAGAMENTO, 3);
    }

    @Test
    @DisplayName("No Limite: 1500")
    void testNoLimite() {
        testScenario(1500, new double[] { 500, 400, 600 }, status.PAGO, 3);
    }

    @Test
    @DisplayName("Valor Limite Superior: 1501")
    void testValorLimiteSuperior() {
        testScenario(1500, new double[] { 500, 400, 601 }, status.PAGO, 3);
    }

    // Partições de Equivalência
    @Test
    @DisplayName("Todos os boletos somam para o valor exato da fatura")
    void testParticaoValorExato() {
        testScenario(1500, new double[] { 500, 400, 600 }, status.PAGO, 3);
    }

    @Test
    @DisplayName("Nenhum pagamento feito")
    void testParticaoNenhumPagamento() {
        testScenario(1500, new double[] { 0, 0, 0 }, status.AGUARDANDO_PAGAMENTO, 3);
    }

    @Test
    @DisplayName("Um único boleto paga toda a fatura")
    void testParticaoUmBoleto() {
        testScenario(1500, new double[] { 1500, 0, 0 }, status.PAGO, 1);
    }

    @Test
    @DisplayName("Dois boletos pagam toda a fatura")
    void testParticaoDoisBoletos() {
        testScenario(1500, new double[] { 750, 750, 0 }, status.PAGO, 2);
    }

    // Tabelas de Decisão
    @Test
    @DisplayName("Cenário comum de três boletos que pagam a fatura")
    void testDecisaoCenarioComum() {
        testScenario(1500, new double[] { 500, 400, 600 }, status.PAGO, 3);
    }

    @Test
    @DisplayName("Um único boleto paga toda a fatura")
    void testDecisaoUmBoleto() {
        testScenario(1500, new double[] { 0, 0, 1500 }, status.PAGO, 1);
    }

    @Test
    @DisplayName("Nenhuma fatura, nenhum pagamento")
    void testDecisaoNenhumaFatura() {
        testScenario(0, new double[] { 0, 0, 0 }, status.AGUARDANDO_PAGAMENTO, 0);
    }

    @Test
    @DisplayName("Três boletos de 500 pagam a fatura de 1500")
    void testDecisaoTresBoletos() {
        testScenario(1500, new double[] { 500, 500, 500 }, status.PAGO, 3);
    }

    // Método auxiliar para testar os cenários
    private void testScenario(double valorFatura, double[] valoresBoletos, status expectedStatus,
            int expectedPayments) {
        List<Boleto> boletosList = new ArrayList<>();
        for (double valor : valoresBoletos) {
            boletosList.add(new Boleto("01/01/2022", valor, "Cliente"));
        }
        Processador processador = new Processador();
        Fatura fatura = new Fatura("01/01/2022", valorFatura, "Cliente");

        List<Pagamento> pagamentos = processador.processaBoletos(boletosList, fatura);

        Assertions.assertEquals(expectedPayments, pagamentos.size());
        Assertions.assertEquals(expectedStatus, fatura.getStatus());
    }
}
