package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NakladnyVlak extends Vlak {
    private int nosnost;
    private String typPrevazanehoTovaru;
    private String objednavatel;
    
    public void napln()
    {
    	ArrayList<NakladnyVlak> n = new ArrayList<>();
    	NakladnyVlak vlak = new NakladnyVlak();
    	vlak.setSpolocnost("ZSSK");
    	vlak.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak.setCielovaStanica(new Stanica("Prešov"));		
    	vlak.setDlzkaTrasy();
        vlak.setPocetVagonov(12);
        vlak.setRychlost();
        vlak.setNosnost(12);
        vlak.setTypPrevazanehoTovaru("Cement");
        vlak.setObjednavatel("Váhostav-SK");
    	vlak.setStart(vlak.getVychodziaStanica().getNazov());
    	vlak.setCiel(vlak.getCielovaStanica().getNazov());
    	n.add(vlak);
    	NakladnyVlak vlak2 = new NakladnyVlak();
    	vlak2.setSpolocnost("ZSSK");
    	vlak2.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak2.setCielovaStanica(new Stanica("Žilina"));		
    	vlak2.setDlzkaTrasy();
        vlak2.setPocetVagonov(12);
    	vlak2.setRychlost();
        vlak2.setNosnost(12);
        vlak2.setTypPrevazanehoTovaru("Železná ruda");
        vlak2.setObjednavatel("UsSteel-Košice");
    	vlak2.setStart(vlak2.getVychodziaStanica().getNazov());
    	vlak2.setCiel(vlak2.getCielovaStanica().getNazov());
    	n.add(vlak2);
    	NakladnyVlak vlak3 = new NakladnyVlak();
    	vlak3.setSpolocnost("ZSSK");
    	vlak3.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak3.setCielovaStanica(new Stanica("Košice"));		
    	vlak3.setDlzkaTrasy();
        vlak3.setPocetVagonov(12);
    	vlak3.setRychlost();
        vlak3.setNosnost(12);
        vlak3.setTypPrevazanehoTovaru("Uhlie");
        vlak3.setObjednavatel("UsSteel");
    	vlak3.setStart(vlak3.getVychodziaStanica().getNazov());
    	vlak3.setCiel(vlak3.getCielovaStanica().getNazov());
    	n.add(vlak3);
    	NakladnyVlak vlak4 = new NakladnyVlak();
    	vlak4.setSpolocnost("ZSSK");
    	vlak4.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak4.setCielovaStanica(new Stanica("Banská Bystrica"));		
    	vlak4.setDlzkaTrasy();
        vlak4.setPocetVagonov(12);
    	vlak4.setRychlost();
        vlak4.setNosnost(12);
        vlak4.setTypPrevazanehoTovaru("Chemikálie");
        vlak4.setObjednavatel("Duslo Ša¾a");
    	vlak4.setStart(vlak4.getVychodziaStanica().getNazov());
    	vlak4.setCiel(vlak4.getCielovaStanica().getNazov());
    	n.add(vlak4);
    	NakladnyVlak vlak5 = new NakladnyVlak();
    	vlak5.setSpolocnost("ZSSK");
    	vlak5.setVychodziaStanica(new Stanica("Bratislava"));
    	vlak5.setCielovaStanica(new Stanica("Nitra"));		
    	vlak5.setDlzkaTrasy();
        vlak5.setPocetVagonov(12);
    	vlak5.setRychlost();
        vlak5.setNosnost(12);
        vlak5.setTypPrevazanehoTovaru("Autodiely");
        vlak5.setObjednavatel("Jaguár SK");
    	vlak5.setStart(vlak5.getVychodziaStanica().getNazov());
    	vlak5.setCiel(vlak5.getCielovaStanica().getNazov());
    	n.add(vlak5);
    	try {
        FileOutputStream fileOut = new FileOutputStream(new File("LoadTrains.txt"),true);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
    	out.writeObject(n);
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
    	if(dlzkaTrasy>60&&pocetVagonov<=30)
    	{
    		rychlost = 90;
    	}
    	else
    	{
    		rychlost = 70;
    	}
    }    
    public int getNosnost() {
		return nosnost;
	}
	public void setNosnost(int pocetVagonov) {
		nosnost = pocetVagonov*50;//hmotnost 50 uvedena v tonach
	}
	public String getTypPrevazanehoTovaru() {
		return typPrevazanehoTovaru;
	}
	public void setTypPrevazanehoTovaru(String typPrevazanehoTovaru) {
		this.typPrevazanehoTovaru = typPrevazanehoTovaru;
	}
	public String getObjednavatel() {
		return objednavatel;
	}
	public void setObjednavatel(String objednavatel) {
		this.objednavatel = objednavatel;
	}
	public NakladnyVlak() {
        super();
        this.nosnost = nosnost;
        this.typPrevazanehoTovaru = typPrevazanehoTovaru;
        this.objednavatel = objednavatel;
    }
}
