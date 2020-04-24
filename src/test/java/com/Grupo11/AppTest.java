package com.Grupo11;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testaE1C1(){
        // Caso de emergência, falta aditivo        
        DepComb dc = new DepComb(10000, 0, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(50, true);
        int[] tanquesEx = {-1, 0, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE1C2(){
        // Caso de emergência, falta gasolina
        DepComb dc = new DepComb(0, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(100, true);
        int[] tanquesEx = {0, -1, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }
    
    @Test
    public void testaE1C3(){
        // Caso de emergência, falta alcool
        DepComb dc = new DepComb(10000, 500, 0, 0);
        int[] tanques = dc.encomendaCombustivel(100, true);
        int[] tanquesEx = {0, 0, -1, -1};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE1C4(){
        // Caso de emergência, pedido pode ser atendido
        DepComb dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(10000, true);
        int[] tanquesEx = {0, 3000, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE1C5(){
        // Caso de emergência, quantidade invalida  
        DepComb dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(-50, true);
        int[] tanquesEx = {-2, 0, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C1(){
        // Caso normal, falta aditivo
        DepComb dc = new DepComb(10000, 150, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(600, false);
        int[] tanquesEx = {-1, 0, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }
    
    @Test
    public void testaE2C2(){
        // Caso normal, falta gasolina
        DepComb dc = new DepComb(2600, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(1000, false);
        int[] tanquesEx = {0, -1, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C3(){
        // Caso normal, falta alcool
        DepComb dc = new DepComb(10000, 500, 400, 400);
        int[] tanques = dc.encomendaCombustivel(750, false);
        int[] tanquesEx = {0, 0, -1, -1};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C4(){
        // Caso normal, pedido pode ser atendido
        DepComb dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(80, false);
        int[] tanquesEx = {496, 9944 , 1240, 1240};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C5(){
        // Caso normal, quantidade invalida  
        DepComb dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(-100, false);
        int[] tanquesEx = {-2, 0, 0, 0};
        assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaRecebeAditivo(){
        DepComb dc = new DepComb(5000, 250, 625, 625);
        int info = dc.recebeAditivo(500);
        int infoEx = 250;

        assertEquals(infoEx, info);

        dc = new DepComb(5000, 250, 625, 625);
        info = dc.recebeAditivo(-10);
        infoEx = -1;

        assertEquals(infoEx, info);
    }

    @Test
    public void testaRecebeAlcool(){
        //
        DepComb dc = new DepComb(5000, 250, 625, 625);
        int info = dc.recebeAlcool(1250);
        int infoEx = 1250;

        assertEquals(infoEx, info);

        dc = new DepComb(5000, 250, 625, 625);
        info = dc.recebeAlcool(-30);
        infoEx = -1;

        assertEquals(infoEx, info);
    }

    @Test
    public void testaRecebeGasolina(){
        //
        DepComb dc = new DepComb(5000, 250, 625, 625);
        int info = dc.recebeGasolina(10000);
        int infoEx = 5000;

        assertEquals(infoEx, info);

        dc = new DepComb(5000, 250, 625, 625);
        info = dc.recebeGasolina(-50);
        infoEx = -1;

        assertEquals(infoEx, info);
    }    
}
