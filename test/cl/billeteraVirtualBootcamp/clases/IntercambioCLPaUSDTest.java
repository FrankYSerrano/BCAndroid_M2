package cl.billeteraVirtualBootcamp.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntercambioCLPaUSDTest {

    @Test
    void ajustarTasaCLPaUSD() {
        IntercambioCLPaUSD tasaPrueba = new IntercambioCLPaUSD(100);
        tasaPrueba.ajustarTasaCLPaUSD(90);
        assertEquals(90, tasaPrueba.getTasaCLPaUSD());
    }

    @Test
    void convertir() {
        IntercambioCLPaUSD tasaPrueba = new IntercambioCLPaUSD(100);
        assertEquals(5, tasaPrueba.convertir(500));
    }
}