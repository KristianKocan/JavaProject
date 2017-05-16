package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OknoPridaj extends Stage {
	
	private TextField kodLinky = new TextField();
	private Button pridaj = new Button("Pridaj");
	private ComboBox<String> company = new ComboBox<String>();
	private ComboBox<String> from = new ComboBox<String>();
	private ComboBox<String> to = new ComboBox<String>();

	// Singleton design pattern
    private static OknoPridaj instance;
	
	private OknoPridaj()
	{
		super();
		OknoPridaj.setInstance(this);
		pridaj.setId("Nov˝");
        this.setTitle("Pridaj nov˝ vlak");
		BorderPane root = new BorderPane();
	    Scene scene = new Scene(root, 450, 200, Color.WHITE);
	    GridPane gridpane = new GridPane();
	    gridpane.setPadding(new Insets(5));
	    gridpane.setHgap(5);
	    gridpane.setVgap(5);
	    ColumnConstraints column1 = new ColumnConstraints(100);
	    ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
	    column2.setHgrow(Priority.ALWAYS);
	    gridpane.getColumnConstraints().addAll(column1, column2);

	    Label label1 = new Label("KÛd Linky");
	    Label label2 = new Label("SpoloËnosù");
	    Label label3 = new Label("Odkiaæ");
	    Label label4 = new Label("Kam");
	    
	    company.getItems().addAll("ZSSK","RegioJet SK","LeoExpress","Pendolino - »D","LTE Transport Slovakia");
        company.setEditable(false);  
        
        from.getItems().addAll("Bratislava","Koöice","Preöov","éilina","Bansk· Bystrica","Nitra","Trnava","TrenËÌn","Martin","Poprad");
        from.setEditable(false);
        
        to.getItems().addAll("Bratislava","Koöice","Preöov","éilina","Bansk· Bystrica","Nitra","Trnava","TrenËÌn","Martin","Poprad");
        to.setEditable(false);

	    GridPane.setHalignment(label1, HPos.RIGHT);
	    gridpane.add(label1, 0, 0);

	    GridPane.setHalignment(label2, HPos.RIGHT);
	    gridpane.add(label2, 0, 1);

	    GridPane.setHalignment(label3, HPos.RIGHT);
	    gridpane.add(label3, 0, 2);
	    
	    GridPane.setHalignment(label4, HPos.RIGHT);
	    gridpane.add(label4, 0, 3);
	    
	    GridPane.setHalignment(kodLinky, HPos.LEFT);
	    gridpane.add(kodLinky, 1, 0);

	    GridPane.setHalignment(company, HPos.LEFT);
	    gridpane.add(company, 1, 1);

	    GridPane.setHalignment(from, HPos.LEFT);
	    gridpane.add(from, 1, 2);
	    
	    GridPane.setHalignment(to, HPos.LEFT);
	    gridpane.add(to, 1, 3);
	    
	    GridPane.setHalignment(pridaj, HPos.RIGHT);
	    gridpane.add(pridaj, 1, 6);

	    root.setCenter(gridpane);
	    this.setScene(scene);
	    this.show();
	}
	public TextField getKodLinky() {
		return kodLinky;
	}
	public void setKodLinky(TextField kodLinky) {
		this.kodLinky = kodLinky;
	}
	public ComboBox<String> getCompany() {
		return company;
	}
	public void setCompany(ComboBox<String> company) {
		this.company = company;
	}
	public ComboBox<String> getFrom() {
		return from;
	}
	public void setFrom(ComboBox<String> from) {
		this.from = from;
	}
	public ComboBox<String> getTo() {
		return to;
	}
	public void setTo(ComboBox<String> to) {
		this.to = to;
	}
	public Button getPridaj() {
		return pridaj;
	}
	public void setPridaj(Button pridaj) {
		this.pridaj = pridaj;
	}
		// Singleton design pattern continuing
		public static OknoPridaj getInstance() {
	        while(instance == null) {
	            try {
	            	instance = new OknoPridaj();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// skip
				}
	        }
			return instance;
		}
		public static void setInstance(OknoPridaj instance) {
			OknoPridaj.instance = instance;
		}
}
