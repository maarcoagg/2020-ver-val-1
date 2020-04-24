package com.Grupo11;

public class DepComb {
	public static final int MAX_ADITIVO = 500;
	public static final int MAX_ALCOOL = 2500;
	public static final int MAX_GASOLINA = 10000;

	private int tGasolina;
	private int tAditivo;
	private int tAlcool1;
    private int tAlcool2;

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
		if (qtdade <= 0) return -1;	
		
		int armz_disp = MAX_ADITIVO - gettAditivo(); 
        int excesso = qtdade - armz_disp;
        settAditivo(qtdade - excesso);

		return (qtdade - excesso);
	}
	
	public int recebeGasolina(int qtdade){
		if (qtdade <= 0) return -1;	

		int armz_disp = MAX_GASOLINA - gettGasolina(); //2000
        int excesso = qtdade - armz_disp; //10000 - 2000 = 8000
        settGasolina(qtdade - excesso);

		return (qtdade - excesso);
	}

	public int recebeAlcool(int qtdade){
		if (qtdade <= 0) return -1;	

		int armz_disp = MAX_ALCOOL - (gettAlcool1() + gettAlcool2());
        int excesso = qtdade - armz_disp;
        settAlcool1((int)((qtdade - excesso)/2));
        settAlcool2((int)((qtdade - excesso)/2));

		return (qtdade - excesso);
    }
	
	public void atualizaCombustivel(int qtdade){
            settGasolina((int)(gettGasolina() - qtdade*0.70));
            settAditivo((int)(gettAditivo() - qtdade*0.05));
            settAlcool1((int)(gettAlcool1() - qtdade*0.125));
            settAlcool2((int)(gettAlcool2() - qtdade*0.125));
    }

	public int[] encomendaCombustivel(int qtdade, boolean emerg){
		int[] qntd_tanques;
		
		System.out.println("Quantidade: " + qtdade);
		if (qtdade > 0) {
			if (emerg) qntd_tanques = getCombustivel(qtdade, 0);
			else qntd_tanques = getCombustivel(qtdade, 25);
		} 
		else{
			qntd_tanques = new int[]{-2,0,0,0};
		} 

		return qntd_tanques;
	}
	
	public int[] getCombustivel(int qtdade, int limite) {
		double l = limite/100.0; // Transforma o limite em porcentagem
		int[] qtComb = new int[]{0, 0, 0, 0};
		boolean faltouAditivo = false, faltouGasolina= false, faltouAlcool = false;
		
		if ((int)(gettAditivo() - qtdade*0.05) < (MAX_ADITIVO*l)){
			System.out.println(MAX_ADITIVO*l);
			faltouAditivo = true;
			qtComb[0] = -1;
		}
    
		if ((int)(gettGasolina() - qtdade*0.70) < (MAX_GASOLINA*l)){
			System.out.println(MAX_GASOLINA*l);
			faltouGasolina = true;	
			qtComb[1] = -1;
		}
		
		if ((int)((gettAlcool1()+gettAlcool2()) - qtdade*0.25) < (MAX_ALCOOL*l)){
			System.out.println(MAX_ALCOOL*l);
			faltouAlcool = true;
			qtComb[2] = -1;
			qtComb[3] = -1;
		}
	
		if (faltouAditivo || faltouGasolina || faltouAlcool){
			return qtComb;
		} else {
			atualizaCombustivel(qtdade);
			qtComb = new int[]{tAditivo, tGasolina, tAlcool1, tAlcool2};
			return qtComb;	
		} 
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Posto Ver & Val:\n").
		   append("Aditivo:").append(tAditivo).
		   append("L\tGasolina:").append(tGasolina).
		   append("L\tAlcool 1:").append(tAlcool1).
		   append("L\tAlcool 2:").append(tAlcool2).
		   append("L.\n");
							
	    return sb.toString();
	}
}
