package functionalTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Main.NotaFiscal.Fatura;
import Main.NotaFiscal.GeradorNotaFiscal;
import Main.NotaFiscal.NotaFiscal;

public class GeradorNotaFiscalTest {

    @Test
    public void testLimiteConsultoriaMenor() {
        Fatura fatura = new Fatura("Cliente A", "Rua X", "CONSULTORIA", 999.99);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(999.99, nf.getValor(), 0.01);
        assertEquals(249.9975, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteConsultoriaMaior() {
        Fatura fatura = new Fatura("Cliente B", "Rua Y", "CONSULTORIA", 1000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(1000.00, nf.getValor(), 0.01);
        assertEquals(250.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteTreinamentoMenor() {
        Fatura fatura = new Fatura("Cliente C", "Rua Z", "TREINAMENTO", 999.99);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(999.99, nf.getValor(), 0.01);
        assertEquals(149.9985, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteTreinamentoMaior() {
        Fatura fatura = new Fatura("Cliente D", "Rua W", "TREINAMENTO", 1000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(1000.00, nf.getValor(), 0.01);
        assertEquals(150.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteOutrosMenor() {
        Fatura fatura = new Fatura("Cliente E", "Rua V", "OUTROS", 999.99);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(999.99, nf.getValor(), 0.01);
        assertEquals(59.9994, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteOutrosMaior() {
        Fatura fatura = new Fatura("Cliente F", "Rua U", "OUTROS", 1000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(1000.00, nf.getValor(), 0.01);
        assertEquals(60.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteConsultoriaZero() {
        Fatura fatura = new Fatura("Cliente G", "Rua T", "CONSULTORIA", 0.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(0.00, nf.getValor(), 0.01);
        assertEquals(0.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteTreinamentoZero() {
        Fatura fatura = new Fatura("Cliente H", "Rua S", "TREINAMENTO", 0.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(0.00, nf.getValor(), 0.01);
        assertEquals(0.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testLimiteOutrosZero() {
        Fatura fatura = new Fatura("Cliente I", "Rua R", "OUTROS", 0.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(0.00, nf.getValor(), 0.01);
        assertEquals(0.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testConsultoriaComSucesso() {
        Fatura fatura = new Fatura("João", "Endereço qualquer", "CONSULTORIA", 100);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(100, nf.getValor(), 0.01);
        assertEquals(25, nf.getImposto(), 0.01);
    }

    @Test
    public void testTreinamentoComSucesso() {
        Fatura fatura = new Fatura("Ana", "Endereço qualquer", "TREINAMENTO", 100);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(100, nf.getValor(), 0.01);
        assertEquals(15, nf.getImposto(), 0.01);
    }

    @Test
    public void testOutroComSucesso() {
        Fatura fatura = new Fatura("Maria", "Endereço qualquer", "OUTRO", 100);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        NotaFiscal nf = gerador.gera(fatura);
        assertEquals(100, nf.getValor(), 0.01);
        assertEquals(6, nf.getImposto(), 0.01);
    }

    @Test
    public void testFalhaTipoInvalido() {
        Fatura fatura = new Fatura("João", "Endereço qualquer", "INVALIDO", 100);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        assertThrows(IllegalArgumentException.class, () -> gerador.gera(fatura));
    }

    @Test
    public void testFalhaSemCliente() {
        Fatura fatura = new Fatura("", "Endereço qualquer", "CONSULTORIA", 100);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();
        assertThrows(IllegalArgumentException.class, () -> gerador.gera(fatura));
    }

}
