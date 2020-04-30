package com.Grupo11;

public class App 
{
    public static void main( String[] args )
    {
        //"350,5001,800,800,3572,false,172,2501,354,354",

        DepComb dc = new DepComb(5001, 350, 800, 800);
        int[] tanques = dc.encomendaCombustivel(3572, false);
        
        for(int i=0; i < tanques.length; i++){
            System.out.println(tanques[i] );
        }
        System.out.println("Expected: 172,2501,354,354");
    }
}
