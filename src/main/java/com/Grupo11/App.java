package com.Grupo11;

public class App 
{
    public static void main( String[] args )
    {
        DepComb dc = new DepComb(10000, 150, 1250, 1250);
        int[] tanques = dc.encomendaCombustivel(-100, false);
        
        for(int i=0; i < tanques.length; i++){
            System.out.println(tanques[i]);
        }
    }
}
