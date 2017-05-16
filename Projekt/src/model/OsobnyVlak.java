package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;

public class OsobnyVlak extends Vlak implements Serializable{
	private String kodLinky;
    private ArrayList<String> Zastavky;
    private int pocetCestujucich;
    private int personalVlaku;
    
    public void napln()
    {
    	ArrayList<OsobnyVlak> t = new ArrayList<OsobnyVlak>();
    	OsobnyVlak vlak = new OsobnyVlak();
    	vlak.setKodLinky("R600");
    	vlak.setSpolocnost("ZSSK");
    	vlak.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak.setCielovaStanica(new Stanica("Prešov"));		
    	vlak.setDlzkaTrasy();
        vlak.setRychlost();
    	vlak.setStart(vlak.getVychodziaStanica().getNazov());
    	vlak.setCiel(vlak.getCielovaStanica().getNazov());
    	t.add(vlak);
    	OsobnyVlak vlak2 = new OsobnyVlak();
        vlak2.setKodLinky("R601");
    	vlak2.setSpolocnost("ZSSK");
    	vlak2.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak2.setCielovaStanica(new Stanica("Žilina"));		
    	vlak2.setDlzkaTrasy();
        vlak2.setRychlost();
    	vlak2.setStart(vlak2.getVychodziaStanica().getNazov());
    	vlak2.setCiel(vlak2.getCielovaStanica().getNazov());
    	t.add(vlak2);
    	OsobnyVlak vlak3 = new OsobnyVlak();
    	vlak3.setKodLinky("R602");
    	vlak3.setSpolocnost("ZSSK");
    	vlak3.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak3.setCielovaStanica(new Stanica("Košice"));		
    	vlak3.setDlzkaTrasy();
        vlak3.setRychlost();
    	vlak3.setStart(vlak3.getVychodziaStanica().getNazov());
    	vlak3.setCiel(vlak3.getCielovaStanica().getNazov());
    	t.add(vlak3);
    	OsobnyVlak vlak4 = new OsobnyVlak();
    	vlak4.setKodLinky("R603");
    	vlak4.setSpolocnost("ZSSK");
    	vlak4.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak4.setCielovaStanica(new Stanica("Banská Bystrica"));		
    	vlak4.setDlzkaTrasy();
        vlak4.setRychlost();
    	vlak4.setStart(vlak4.getVychodziaStanica().getNazov());
    	vlak4.setCiel(vlak4.getCielovaStanica().getNazov());
    	t.add(vlak4);
    	OsobnyVlak vlak5 = new OsobnyVlak();
    	vlak5.setKodLinky("R604");
    	vlak5.setSpolocnost("ZSSK");
    	vlak5.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak5.setCielovaStanica(new Stanica("Poprad"));		
    	vlak5.setDlzkaTrasy();
        vlak5.setRychlost();
    	vlak5.setStart(vlak5.getVychodziaStanica().getNazov());
    	vlak5.setCiel(vlak5.getCielovaStanica().getNazov());
    	t.add(vlak5);
    	OsobnyVlak vlak6 = new OsobnyVlak();
    	vlak6.setKodLinky("R605");
    	vlak6.setSpolocnost("ZSSK");
    	vlak6.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak6.setCielovaStanica(new Stanica("Nitra"));		
    	vlak6.setDlzkaTrasy();
        vlak6.setRychlost();
    	vlak6.setStart(vlak6.getVychodziaStanica().getNazov());
    	vlak6.setCiel(vlak6.getCielovaStanica().getNazov());
    	t.add(vlak6);
    	try {
        FileOutputStream fileOut = new FileOutputStream(new File("trains.txt"),true);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	out.writeObject(t);
    	out.close();
        fileOut.close();
         }catch(IOException i) {
            i.printStackTrace();
         }
    }
//Polymorfizmus
 @Override
    public void setRychlost()
    {
    	if(dlzkaTrasy>40)
    	{
    		rychlost = 160;
    	}
    	else
    	{
    		rychlost = 120;
    	}
    }
    	public String getKodLinky() {
		return kodLinky;
	}

	public void setKodLinky(String kodLinky) {
		this.kodLinky = kodLinky;
	}
    public ArrayList<String> getZastavky() {
    	return Zastavky;
	}

    public void setZastavky(ArrayList<String> zastavky) {
    	Zastavky = zastavky;
	}

    public int getPocetCestujucich() {
    	return pocetCestujucich;
	}

    public void setPocetCestujucich(int pocetCestujucich) {
    	this.pocetCestujucich = pocetCestujucich;
    }

    public int getPersonalVlaku() {
    	return personalVlaku;
    }

    public void setPersonalVlaku(int personalVlaku) {
    	this.personalVlaku = personalVlaku;
    }

	public OsobnyVlak() {
        super();
        this.Zastavky = Zastavky;
        this.pocetCestujucich = pocetCestujucich;
        this.personalVlaku = personalVlaku;
    }
    
}