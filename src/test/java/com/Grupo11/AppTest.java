package com.Grupo11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    DepComb dc;

    @Test
    public void testaE1C1(){
        // Caso de emergência, falta aditivo        
        dc = new DepComb(10000, 0, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(50, true);
        int[] tanquesEx = {-1, 0, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE1C2(){
        // Caso de emergência, falta gasolina
        dc = new DepComb(0, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(100, true);
        int[] tanquesEx = {0, -1, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }
    
    @Test
    public void testaE1C3(){
        // Caso de emergência, falta alcool
        dc = new DepComb(10000, 500, 0, 0);
        int[] tanques = dc.encomendaCombustivel(100, true);
        int[] tanquesEx = {0, 0, -1, -1};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE1C4(){
        // Caso de emergência, pedido pode ser atendido
        dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(10000, true);
        int[] tanquesEx = {0, 3000, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE1C5(){
        // Caso de emergência, quantidade invalida  
        dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(-50, true);
        int[] tanquesEx = {-2, 0, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C1(){
        // Caso normal, falta aditivo
        dc = new DepComb(10000, 150, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(600, false);
        int[] tanquesEx = {-1, 0, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }
    
    @Test
    public void testaE2C2(){
        // Caso normal, falta gasolina
        dc = new DepComb(2600, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(1000, false);
        int[] tanquesEx = {0, -1, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C3(){
        // Caso normal, falta alcool
        dc = new DepComb(10000, 500, 400, 400);
        int[] tanques = dc.encomendaCombustivel(750, false);
        int[] tanquesEx = {0, 0, -1, -1};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C4(){
        // Caso normal, pedido pode ser atendido
        dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(80, false);
        int[] tanquesEx = {496, 9944 , 1240, 1240};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaE2C5(){
        // Caso normal, quantidade invalida  
        dc = new DepComb(10000, 500, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(-100, false);
        int[] tanquesEx = {-2, 0, 0, 0};
        Assertions.assertArrayEquals(tanquesEx, tanques);
    }

    @Test
    public void testaRecebeAditivo(){
        dc = new DepComb(5000, 250, 625, 625);
        int info = dc.recebeAditivo(500);
        int infoEx = 250;

        Assertions.assertEquals(infoEx, info);

        dc = new DepComb(5000, 250, 625, 625);
        info = dc.recebeAditivo(-10);
        infoEx = -1;

        Assertions.assertEquals(infoEx, info);
    }

    @Test
    public void testaRecebeAlcool(){
        //
        dc = new DepComb(5000, 250, 625, 625);
        int info = dc.recebeAlcool(1250);
        int infoEx = 1250;

        Assertions.assertEquals(infoEx, info);

        dc = new DepComb(5000, 250, 625, 625);
        info = dc.recebeAlcool(-30);
        infoEx = -1;

        Assertions.assertEquals(infoEx, info);
    }

    @Test
    public void testaRecebeGasolina(){
        //
        dc = new DepComb(5000, 250, 625, 625);
        int info = dc.recebeGasolina(10000);
        int infoEx = 5000;

        Assertions.assertEquals(infoEx, info);

        dc = new DepComb(5000, 250, 625, 625);
        info = dc.recebeGasolina(-50);
        infoEx = -1;

        Assertions.assertEquals(infoEx, info);
    }

}
