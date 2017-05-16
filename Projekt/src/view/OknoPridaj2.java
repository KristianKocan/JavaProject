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

public class OknoPridaj2 extends Stage{
	private TextField Customer = new TextField();
	private TextField Vagony = new TextField();
	private Button pridaj = new Button("Pridaj");
	private ComboBox<String> company = new ComboBox<String>();
	private ComboBox<String> from = new ComboBox<String>();
	private ComboBox<String> to = new ComboBox<String>();
	private ComboBox<String> type = new ComboBox<String>();

	// Singleton design pattern
    private static OknoPridaj2 instance;
	
	private OknoPridaj2()
	{
		super();
		OknoPridaj2.setInstance(this);
		pridaj.setId("Nov˝");
        this.setTitle("Pridaj nov˝ vlak");
		BorderPane root = new BorderPane();
	    Scene scene = new Scene(root, 450, 300, Color.WHITE);
	    GridPane gridpane = new GridPane();
	    gridpane.setPadding(new Insets(5));
	    gridpane.setHgap(5);
	    gridpane.setVgap(5);
	    ColumnConstraints column1 = new ColumnConstraints(100);
	    ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
	    column2.setHgrow(Priority.ALWAYS);
	    gridpane.getColumnConstraints().addAll(column1, column2);

	    Label label1 = new Label("Objedn·vateæ");
	    Label label2 = new Label("SpoloËnosù");
	    Label label3 = new Label("Odkiaæ");
	    Label label4 = new Label("Kam");
	    Label label5 = new Label("PoËet vagÛnov");
	    Label label6 = new Label("Typ tovaru");
	    
	    company.getItems().addAll("ZSSK","RegioJet SK","LeoExpress","Pendolino - »D","LTE Transport Slovakia");
        company.setEditable(false);  
        
        from.getItems().addAll("Bratislava","Koöice","Preöov","éilina","Bansk· Bystrica","Nitra","Trnava","TrenËÌn","Martin","Poprad");
        from.setEditable(false);
        
        to.getItems().addAll("Bratislava","Koöice","Preöov","éilina","Bansk· Bystrica","Nitra","Trnava","TrenËÌn","Martin","Poprad");
        to.setEditable(false);
        
        type.getItems().addAll("Cement","Drevo","Uhlie","éelezn· ruda","Chemik·lie","Aut·","Autodiely","Piesok","Obilie");
        type.setEditable(false);

	    GridPane.setHalignment(label1, HPos.RIGHT);
	    gridpane.add(label1, 0, 0);

	    GridPane.setHalignment(label2, HPos.RIGHT);
	    gridpane.add(label2, 0, 1);

	    GridPane.setHalignment(label3, HPos.RIGHT);
	    gridpane.add(label3, 0, 2);
	    
	    GridPane.setHalignment(label4, HPos.RIGHT);
	    gridpane.add(label4, 0, 3);
	    
	    GridPane.setHalignment(label5, HPos.RIGHT);
	    gridpane.add(label5, 0, 4);
	    
	    GridPane.setHalignment(label6, HPos.RIGHT);
	    gridpane.add(label6, 0, 5);
	    
	    GridPane.setHalignment(Customer, HPos.LEFT);
	    gridpane.add(Customer, 1, 0);

	    GridPane.setHalignment(company, HPos.LEFT);
	    gridpane.add(company, 1, 1);

	    GridPane.setHalignment(from, HPos.LEFT);
	    gridpane.add(from, 1, 2);
	    
	    GridPane.setHalignment(to, HPos.LEFT);
	    gridpane.add(to, 1, 3);
	    
	    GridPane.setHalignment(Vagony, HPos.LEFT);
	    gridpane.add(Vagony, 1, 4);
	    
	    GridPane.setHalignment(type, HPos.LEFT);
	    gridpane.add(type, 1, 5);
	    
	    GridPane.setHalignment(pridaj, HPos.RIGHT);
	    gridpane.add(pridaj, 1, 6);

	    root.setCenter(gridpane);
	    this.setScene(scene);
	    this.show();
	}
	public TextField getCustomer() {
		return Customer;
	}
	public void setCustomer(TextField Customer) {
		this.Customer = Customer;
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
	public ComboBox<String> getType() {
		return type;
	}
	public void setType(ComboBox<String> type) {
		this.type = type;
	}
		public TextField getVagony() {
		return Vagony;
	}
	public void setVagony(TextField vagony) {
		Vagony = vagony;
	}
		// Singleton design pattern continuing
		public static OknoPridaj2 getInstance() {
	        while(instance == null) {
	            try {
	            	instance = new OknoPridaj2();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// skip
				}
	        }
			return instance;
		}
		public static void setInstance(OknoPridaj2 oknoPridaj2) {
			OknoPridaj2.instance = oknoPridaj2;
		}
}

