package model;

public class DopravnaNehoda extends Nehoda{
	private int pocetZranenych;
	private int pocetMrtvych;
	private boolean trvalePoskodenie;
	private int dobaMeskania;
	//@Overload
	public int meskanie(int dobaMeskania)
	{
		return dobaMeskania;
	}
	
	public int meskanie(int dobaMeskania, int pocetZranenych)
	{
		if(pocetZranenych<=10){ dobaMeskania += 60;
								return dobaMeskania;}
		else return dobaMeskania*pocetZranenych;
	}
	
	public int meskanie(int dobaMeskania, int pocetZranenych,int pocetMrtvych)
	{
		if(pocetMrtvych!=0){
							 dobaMeskania = dobaMeskania*pocetZranenych+60*pocetMrtvych;}
		return dobaMeskania;
	}
	
	public int getPocetZranenych() {
		return pocetZranenych;
	}
	public void setPocetZranenych(int pocetZranenych) {
		this.pocetZranenych = pocetZranenych;
	}
	public int getPocetMrtvych() {
		return pocetMrtvych;
	}
	public void setPocetMrtvych(int pocetMrtvych) {
		this.pocetMrtvych = pocetMrtvych;
	}
	public boolean isTrvalePoskodenie() {
		return trvalePoskodenie;
	}
	public void setTrvalePoskodenie(boolean trvalePoskodenie) {
		this.trvalePoskodenie = trvalePoskodenie;
	}
	public int getDobaMeskania() {
		return dobaMeskania;
	}
	public void setDobaMeskania(int dobaMeskania) {
		this.dobaMeskania = dobaMeskania;
	}
	
}
