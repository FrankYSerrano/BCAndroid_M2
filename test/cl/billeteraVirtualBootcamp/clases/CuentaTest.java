package cl.billeteraVirtualBootcamp.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void incrementaSaldoCLP() {
        Cuenta cuentaPrueba = new Cuenta("F",26216,
                0,0,0);
        cuentaPrueba.setSaldoCLP(cuentaPrueba.agregarSaldoCLP(3));
        assertEquals(3, cuentaPrueba.getSaldoCLP());
    }

    @Test
    void restaSaldoCLP() {
        Cuenta cuentaPrueba = new Cuenta("F",26216,
                6,0,0);
        cuentaPrueba.setSaldoCLP(cuentaPrueba.retirarSaldoCLP(3));
        assertEquals(3, cuentaPrueba.getSaldoCLP());
    }

    @Test
    void convierteCLPaUSD() {
    }

    @Test
    void convierteUSDaBTC() {
    }
}