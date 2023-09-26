package NotaFiscal.src.test.java.vev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import NotaFiscal.src.main.java.vev.*;

@DisplayName("Testes para GeradorNotaFiscal")
public class GeradorNotaFiscalTest {

    GeradorNotaFiscal gerador = new GeradorNotaFiscal();

    @Nested
    @DisplayName("Testes de Limite")
    class LimiteTests {

        @Nested
        @DisplayName("Consultoria")
        class ConsultoriaTests {
            @Test
            @DisplayName("Limite Menor")
            public void testLimiteConsultoriaMenor() {
                Fatura fatura = new Fatura("Cliente A", "Rua X", "CONSULTORIA", 999.99);
                NotaFiscal nf = gerador.gera(fatura);
                assertEquals(999.99, nf.getValor(), 0.01);
                assertEquals(249.9975, nf.getImposto(), 0.01);
            }

            @Test
            @DisplayName("Limite Maior")
            public void testLimiteConsultoriaMaior() {
                Fatura fatura = new Fatura("Cliente B", "Rua Y", "CONSULTORIA", 1000.00);
                NotaFiscal nf = gerador.gera(fatura);
                assertEquals(1000.00, nf.getValor(), 0.01);
                assertEquals(250.00, nf.getImposto(), 0.01);
            }
        }

        @Nested
        @DisplayName("Treinamento")
        class TreinamentoTests {
            @Test
            @DisplayName("Limite Menor")
            public void testLimiteTreinamentoMenor() {
                Fatura fatura = new Fatura("Cliente C", "Rua Z", "TREINAMENTO", 999.99);
                NotaFiscal nf = gerador.gera(fatura);
                assertEquals(999.99, nf.getValor(), 0.01);
                assertEquals(149.9985, nf.getImposto(), 0.01);
            }

            @Test
            @DisplayName("Limite Maior")
            public void testLimiteTreinamentoMaior() {
                Fatura fatura = new Fatura("Cliente D", "Rua W", "TREINAMENTO", 1000.00);
                NotaFiscal nf = gerador.gera(fatura);
                assertEquals(1000.00, nf.getValor(), 0.01);
                assertEquals(150.00, nf.getImposto(), 0.01);
            }
        }

        @Nested
        @DisplayName("Outros")
        class OutrosTests {
            @Test
            @DisplayName("Limite Menor")
            public void testLimiteOutrosMenor() {
                Fatura fatura = new Fatura("Cliente E", "Rua V", "OUTROS", 999.99);
                NotaFiscal nf = gerador.gera(fatura);
                assertEquals(999.99, nf.getValor(), 0.01);
                assertEquals(59.9994, nf.getImposto(), 0.01);
            }

            @Test
            @DisplayName("Limite Maior")
            public void testLimiteOutrosMaior() {
                Fatura fatura = new Fatura("Cliente F", "Rua U", "OUTROS", 1000.00);
                NotaFiscal nf = gerador.gera(fatura);
                assertEquals(1000.00, nf.getValor(), 0.01);
                assertEquals(60.00, nf.getImposto(), 0.01);
            }
        }
    }

    @Nested
    @DisplayName("Testes de Sucesso")
    class SucessoTests {

        @Test
        @DisplayName("Consultoria")
        public void testConsultoriaComSucesso() {
            Fatura fatura = new Fatura("João", "Endereço qualquer", "CONSULTORIA", 100);
            NotaFiscal nf = gerador.gera(fatura);
            assertEquals(100, nf.getValor(), 0.01);
            assertEquals(25, nf.getImposto(), 0.01);
        }

        @Test
        @DisplayName("Treinamento")
        public void testTreinamentoComSucesso() {
            Fatura fatura = new Fatura("Ana", "Endereço qualquer", "TREINAMENTO", 100);
            NotaFiscal nf = gerador.gera(fatura);
            assertEquals(100, nf.getValor(), 0.01);
            assertEquals(15, nf.getImposto(), 0.01);
        }

        @Test
        @DisplayName("Outros")
        public void testOutroComSucesso() {
            Fatura fatura = new Fatura("Maria", "Endereço qualquer", "OUTROS", 100);
            NotaFiscal nf = gerador.gera(fatura);
            assertEquals(100, nf.getValor(), 0.01);
            assertEquals(6, nf.getImposto(), 0.01);
        }
    }
}