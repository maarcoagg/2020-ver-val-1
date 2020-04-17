package com.Grupo11;

public class DepComb {
	public static final int MAX_ADITIVO = 500;
	public static final int MAX_ALCOOL = 2500;
	public static final int MAX_GASOLINA = 10000;

	private int tGasolina;
	private int tAditivo;
	private int tAlcool1;
    private int tAlcool2;
    private int gas_25 = (int) (MAX_GASOLINA * 0.25);
    private int adi_25 = (int) (MAX_ADITIVO * 0.25);
    private int alc_25 = (int) (MAX_ALCOOL * 0.25);


	
	public DepComb(int tGasolina,int tAditivo,int tAlcool1,int tAlcool2){
		this.tGasolina = tGasolina;
		this.tAditivo = tAditivo;
		this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
        

	}
	
	public int gettGasolina(){return tGasolina;}
	
	public int gettAditivo(){return tAditivo;}
	
	public int gettAlcool1(){return tAlcool1;}
	
	public int gettAlcool2(){return tAlcool2;}

	public void settGasolina(int qntd){this.tGasolina = qntd;}
	
	public void settAditivo(int qntd){this.tAditivo = qntd;}
	
	public void settAlcool1(int qntd){this.tAlcool1 = qntd;}
	
	public void settAlcool2(int qntd){this.tAlcool2 = qntd;}
	
	public int recebeAditivo(int qtdade){
        int dif = MAX_ADITIVO - gettAditivo();
        int aux = qtdade - dif;
        settAditivo(qtdade - aux);

		return (qtdade - aux);
	}
	
	public int recebeGasolina(int qtdade){
		int dif = MAX_GASOLINA - gettGasolina();
        int aux = qtdade - dif;
        settGasolina(qtdade - aux);

		return (qtdade - aux);
	}

	public int recebeAlcool(int qtdade){
		int dif = MAX_ALCOOL - (gettAlcool1() + gettAlcool2());
        int aux = qtdade - dif;
        settAlcool1((int)((qtdade - aux)/2));
        settAlcool2((int)((qtdade - aux)/2));

		return (qtdade - aux);
    }
    
    public void retiraGasolinaEmerg(int qtdade){
        if((int)(gettAditivo() - qtdade*0.05) >= 0  && (int)(gettGasolina() - qtdade*0.70) >=0 && (int)(gettAlcool1() - qtdade*0.125) >= 0 && (int)(gettAlcool2() - qtdade*0.125) >= 0){
            settGasolina((int)(gettGasolina() - qtdade*0.05));
            settAditivo((int)(gettAditivo() - qtdade*0.05));
            settAlcool1((int)(gettAditivo() - qtdade*0.125));
            settAlcool2((int)(gettAditivo() - qtdade*0.125));
        }
    }

    public void retiraGasolina(int qtdade){
        if((int)(gettAditivo() - qtdade*0.05) >= adi_25  && (int)(gettGasolina() - qtdade*0.70) >= gas_25 && (int)((gettAlcool1()+gettAlcool2()) - qtdade*0.25) >= alc_25){
            settGasolina((int)(gettGasolina() - qtdade*0.05));
            settAditivo((int)(gettAditivo() - qtdade*0.05));
            settAlcool1((int)(gettAditivo() - qtdade*0.125));
            settAlcool2((int)(gettAditivo() - qtdade*0.125));
        }
    }
    
	/**
	  * O método “encomendaCombustivel” é
		usado quando o centro de distribuição recebe o pedido de um posto. Este método recebe a
		quantidade solicitada pelo posto e um booleano que indica se é um pedido de emergência
		nacional (true) ou não (false). Se o pedido puder ser atendido, o método retorna um arranjo
		com a quantidade de combustível remanescente em cada tanque, depois do pedido atendido.
		As quantidades devem ser retornadas pela ordem: aditivo, gasolina, álcool T1 e álcool T2. No
		caso de ser recebido um valor inválido por parâmetro deve-se retornar -2 na primeira posição
		do arranjo. Se o pedido não puder ser atendido retorna-se -1 na posição correspondente ao
		elemento que tem quantidade insuficiente e 0 nas demais (no caso do álcool deve retornar -1
		na posição do tanque 1). Por simplicidade trabalha-se apenas com números inteiros. Os
		cálculos devem ser feitos com números reais e convertidos para inteiro após a última
		operação.
	 */

	public int[] encomendaCombustivel(int qtdade, boolean emerg){
		if(gettAditivo()==0 || gettAlcool1() == 0|| gettAlcool2() == 0 || gettGasolina() == 0)
		{
			return null;
        }
		return null;
	}
	
	@Override
	public String toString() {
	    return "DepComb [tAditivo=" + tAditivo +", tAlcool1=" + tAlcool1 +", tAlcool2=" + tAlcool2 + ", tGasolina="+tGasolina + "]";
	}
}
