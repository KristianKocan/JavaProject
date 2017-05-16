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
    stage.setTitle("Z�mer projektu");
    Label nazov = new Label("Podpora logistiky �elezn�c Slovenskej Republiky");
    nazov.setFont(new Font(22));
    StackPane.setAlignment(nazov,Pos.TOP_CENTER);
    StackPane.setMargin(nazov, new Insets(20,20,20,20));
    Text zamer = new Text();
    zamer.setFont(new Font(14));
    zamer.setWrappingWidth(500);
    zamer.setTextAlignment(TextAlignment.LEFT);
    zamer.setText("Z�merom m�jho projektu bude vytvori� softv�rov� syst�m na podporu logistiky �elezni�nej dopravy na �zem� SR."
    			  + " Bude zobrazova� vlaky osobnej a n�kladnej dopravy v r�mci prepravn�ho poriadku. "
    			  + " Pri osobn�ch vlakoch bude softv�r zobrazova� po�et a druh cestuj�cich, typ vlaku "
    			  + " (EN, REX, IC,EC, Os, RR, R �), jeho r�chlos�, �as pr�chodu a odchodu, jednotliv� zast�vky,"
    			  + " v�chodziu a cie�ov� stanicu, spolo�nos� vypravuj�cu vlak, d�ku trasy, po�et voz�ov a typ pou�itej lokomot�vy."
    			  + " Pri n�kladn�ch vlakoch druh tovaru, typ a po�et vag�nov nutn�ch na prevoz �pecifick�ho tovaru, �as pr�chodu a odchodu, r�chlos�, hmotnos� tovaru a spolo�nos�, ktor� objednala prevoz tovaru."
    			  + " Pou��vate� bude schopn� vytv�ra� nov� vlakov� spojenia pod�a vlastn�ch po�iadaviek, prid�va� na existuj�cich"
    			  + " link�ch dal�ie stanice, objedna� n�kladn� vlak na prevoz �pecifick�ho tovaru,  zad�va� v�luky na tratiach, "
    			  + " meni� maxim�lnu r�chlos�, zvoli� po�et a typ voz�ov pou�it�ch na linke, roz�irova� prepravn� kapacity a zad�va� "
    			  + " trval� obmedzenia tr�s a infra�trukt�ry."
    			  + " O mo�nostiach a dostupnosti zaradenia nov�ho vlaku alebo objednania n�kladn�ho bude pou��vate� informovan�."
    			  + " Na z�klade krit�ri� zadan�ch pou��vate�om mu bude navrhnut� u� existuj�ce spojenie.");
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
