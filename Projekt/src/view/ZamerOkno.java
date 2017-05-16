package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;

public class ZamerOkno{
	
	private StackPane root3 = new StackPane();
	Stage stage = new Stage();
	// Singleton design pattern
    private static ZamerOkno instance;
	
	private ZamerOkno(){
    super();
    Scene scene3 = new Scene(root3,600,400,Color.AZURE);
    stage.setTitle("Zámer projektu");
    Label nazov = new Label("Podpora logistiky elezníc Slovenskej Republiky");
    nazov.setFont(new Font(22));
    StackPane.setAlignment(nazov,Pos.TOP_CENTER);
    StackPane.setMargin(nazov, new Insets(20,20,20,20));
    Text zamer = new Text();
    zamer.setFont(new Font(14));
    zamer.setWrappingWidth(500);
    zamer.setTextAlignment(TextAlignment.LEFT);
    zamer.setText("Zámerom môjho projektu bude vytvori softvérovı systém na podporu logistiky elezniènej dopravy na území SR."
    			  + " Bude zobrazova vlaky osobnej a nákladnej dopravy v rámci prepravného poriadku. "
    			  + " Pri osobnıch vlakoch bude softvér zobrazova poèet a druh cestujúcich, typ vlaku "
    			  + " (EN, REX, IC,EC, Os, RR, R …), jeho rıchlos, èas príchodu a odchodu, jednotlivé zastávky,"
    			  + " vıchodziu a cie¾ovú stanicu, spoloènos vypravujúcu vlak, dåku trasy, poèet vozòov a typ pouitej lokomotívy."
    			  + " Pri nákladnıch vlakoch druh tovaru, typ a poèet vagónov nutnıch na prevoz špecifického tovaru, èas príchodu a odchodu, rıchlos, hmotnos tovaru a spoloènos, ktorá objednala prevoz tovaru."
    			  + " Pouívate¾ bude schopnı vytvára nové vlakové spojenia pod¾a vlastnıch poiadaviek, pridáva na existujúcich"
    			  + " linkách dalšie stanice, objedna nákladnı vlak na prevoz špecifického tovaru,  zadáva vıluky na tratiach, "
    			  + " meni maximálnu rıchlos, zvoli poèet a typ vozòov pouitıch na linke, rozširova prepravné kapacity a zadáva "
    			  + " trvalé obmedzenia trás a infraštruktúry."
    			  + " O monostiach a dostupnosti zaradenia nového vlaku alebo objednania nákladného bude pouívate¾ informovanı."
    			  + " Na základe kritérií zadanıch pouívate¾om mu bude navrhnuté u existujúce spojenie.");
    zamer.setFill(Color.BLACK);
    StackPane.setMargin(zamer, new Insets(20,20,20,20));
    this.root3.getChildren().addAll(zamer,nazov);
    stage.setScene(scene3);
    stage.sizeToScene(); 
    stage.show();
	}
	// Singleton design pattern continuing
			public static ZamerOkno getInstance() {
		        while(instance == null) {
		            try {
		            	instance = new ZamerOkno();
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// skip
					}
		        }
				return instance;
			}

			public static void setInstance(ZamerOkno instance) {
				ZamerOkno.instance = instance;
			}
}
