package cl.billeteraVirtualBootcamp.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntercambioUSDaBTCTest {

    @Test
    void ajustarTasaUSDaBTC() {
        IntercambioUSDaBTC tasaPrueba = new IntercambioUSDaBTC(70000);
        tasaPrueba.ajustarTasaUSDaBTC(90);
        assertEquals(90, tasaPrueba.getTasaUSDaBTC());
    }

    @Test
    void convertir() {
        IntercambioUSDaBTC tasaPrueba = new IntercambioUSDaBTC(70000);
        assertEquals(0.5, tasaPrueba.convertir(35000));
    }
}