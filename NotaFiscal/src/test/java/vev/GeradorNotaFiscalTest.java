package vev;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GeradorNotaFiscalTest {

    @Test
    public void testGerarNotaFiscalParaConsultoria() {
        Fatura fatura = new Fatura("Cliente A", "Rua X", "CONSULTORIA", 1000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal nf = gerador.gera(fatura);

        assertEquals(1000.00, nf.getValor(), 0.01);
        assertEquals(250.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testGerarNotaFiscalParaTreinamento() {
        Fatura fatura = new Fatura("Cliente B", "Rua Y", "TREINAMENTO", 1000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal nf = gerador.gera(fatura);

        assertEquals(1000.00, nf.getValor(), 0.01);
        assertEquals(150.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testGerarNotaFiscalParaServicoDesconhecido() {
        Fatura fatura = new Fatura("Cliente C", "Rua Z", "MANUTENCAO", 1000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal nf = gerador.gera(fatura);

        assertEquals(1000.00, nf.getValor(), 0.01);
        assertEquals(60.00, nf.getImposto(), 0.01);
    }

    @Test
    public void testNotaFiscalSalvaNoBanco() {
        Fatura fatura = new Fatura("Cliente D", "Rua W", "CONSULTORIA", 2000.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal nf = gerador.gera(fatura);

        assertTrue(gerador.getNotaFiscalDao().contem(nf));
    }

    @Test
    public void testNotaFiscalEnviadaParaSAP() {
        Fatura fatura = new Fatura("Cliente E", "Rua V", "TREINAMENTO", 1500.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal nf = gerador.gera(fatura);

        assertTrue(gerador.getSAP().contem(nf));
    }

    @Test
    public void testNotaFiscalEnviadaPorEmail() {
        Fatura fatura = new Fatura("Cliente F", "Rua U", "MANUTENCAO", 500.00);
        GeradorNotaFiscal gerador = new GeradorNotaFiscal();

        NotaFiscal nf = gerador.gera(fatura);

        assertTrue(gerador.getSmtp().contem(nf));
    }

}
