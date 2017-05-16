 package model;

import java.io.Serializable;

public class Vlak implements Serializable{
    protected int rychlost;
    protected int casPrichodu;
    protected int casOdchodu;
    protected int dlzkaTrasy;
    protected int pocetVagonov;
    protected String start;
    protected String ciel;
    protected Stanica vychodziaStanica;
    protected Stanica cielovaStanica;
    protected String spolocnost;
    
    public void setRychlost()
    {
    	if(pocetVagonov<=12)
    	{
    		rychlost = 120;
    	}
    	else
    	{
    		rychlost = 90;
    	}
    }
    
    public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getCiel() {
		return ciel;
	}

	public void setCiel(String ciel) {
		this.ciel = ciel;
	}

	public int getRychlost() {
		return rychlost;
	}

	public int getCasOdchodu() {
		return casOdchodu;
	}

	public void setCasOdchodu(int casOdchodu) {
		this.casOdchodu = casOdchodu;
	}

	public int getPocetVagonov() {
		return pocetVagonov;
	}

	public void setPocetVagonov(int pocetVagonov) {
		this.pocetVagonov = pocetVagonov;
	}
	
	public int getDlzkaTrasy() {
		return dlzkaTrasy;
	}

	public void setDlzkaTrasy() {
		if(vychodziaStanica.getVzdialenost()>cielovaStanica.getVzdialenost()){
		dlzkaTrasy = (vychodziaStanica.getVzdialenost())-(cielovaStanica.getVzdialenost());
		}
		else {
			dlzkaTrasy = ((cielovaStanica.getVzdialenost())-(vychodziaStanica.getVzdialenost()));
		}
	}

	public Stanica getVychodziaStanica() {
		return vychodziaStanica;
	}

	public void setVychodziaStanica(Stanica vychodziaStanica) {
		this.vychodziaStanica = vychodziaStanica;
	}

	public Stanica getCielovaStanica() {
		return cielovaStanica;
	}

	public void setCielovaStanica(Stanica cielovaStanica) {
		this.cielovaStanica = cielovaStanica;
	}

	public String getSpolocnost() {
		return spolocnost;
	}

	public void setSpolocnost(String spolocnost) {
		this.spolocnost = spolocnost;
	}

	public Vlak() {
        this.rychlost = rychlost;
        this.casPrichodu = casPrichodu;
        this.casOdchodu = casOdchodu;
        this.dlzkaTrasy = dlzkaTrasy;
        this.pocetVagonov = pocetVagonov;
        this.vychodziaStanica = vychodziaStanica;
        this.cielovaStanica = cielovaStanica;
        this.spolocnost = spolocnost;
    } 
}
