package model;

public interface VlakInterface {
	void setRychlost();
	String getStart();
	void setStart();
	String getCiel();
	void setCiel();
	int getRychlost();
	int getCasOdchodu();
	void setCasOdchodu();
	int getPocetVagonov();
	void setPocetVagonov();
	int getDlzkaTrasy();
	void setDlzkaTrasy();
	Stanica getVychodziaStanica();
	void setVychodziaStanica();
	Stanica getCielovaStanica();
	void setCielovaStanica();
	String getSpolocnost();
	void setSpolocnost();
}
