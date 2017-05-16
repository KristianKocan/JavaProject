package model;

import java.io.Serializable;

public class Stanica implements Serializable {
	private String nazov;
	private int vzdialenost;

	public String getNazov() {
		return nazov;
	}
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	public int getVzdialenost() {
		return vzdialenost;
	}
	public void setVzdialenost(int vzdialenost) {
		this.vzdialenost = vzdialenost;
	}
	public Stanica(String nazov) {
		this.nazov = nazov;
		if(nazov=="Bratislava")vzdialenost = 0;
		if(nazov=="Ko�ice")vzdialenost = 442;
		if(nazov=="Pre�ov")vzdialenost = 445;
		if(nazov=="�ilina")vzdialenost = 203;
		if(nazov=="Bansk� Bystrica")vzdialenost = 230;
		if(nazov=="Nitra")vzdialenost = 98;
		if(nazov=="Trnava")vzdialenost = 46;
		if(nazov=="Tren��n")vzdialenost = 124;
		if(nazov=="Martin")vzdialenost = 227;
		if(nazov=="Poprad")vzdialenost = 344;
	}
	
}
