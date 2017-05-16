package view;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrihlasovacieOkno extends Application {
	
    private Button ownerButton = new Button("Majite¾");
    private Button userButton = new Button("Zákazník");
    private Button zamer = new Button("Zámer projektu");
    private StackPane root = new StackPane();
    
    // Singleton design pattern
    private static PrihlasovacieOkno instance;
    

    @Override
    public void start(Stage primaryStage) {
    	PrihlasovacieOkno.setInstance(this);
        primaryStage.setTitle("Vitajte v aplikácii");
        Scene scene = new Scene(root, 800, 550,Color.WHITE);
        //BorderPane pane1 = new BorderPane();
        //pane1.setPadding(new Insets(20, 20, 20, 20));
        //pane1.setCenter(ownerButton);
        //pane1.setCenter(userButton);
        StackPane.setAlignment(ownerButton,Pos.BOTTOM_LEFT);
        StackPane.setAlignment(userButton,Pos.BOTTOM_RIGHT);
        StackPane.setMargin(ownerButton, new Insets(20,20,20,20));
        StackPane.setMargin(userButton, new Insets(20,20,20,20));
        
        StackPane.setAlignment(zamer,Pos.BOTTOM_CENTER);
        StackPane.setMargin(zamer, new Insets(20,20,20,20));
        
        //ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/vlak.jpg"),800,600,true,true));
        //StackPane.setAlignment(image,Pos.TOP_CENTER);
         
        root.getChildren().addAll(ownerButton,userButton,zamer);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene(); 
        primaryStage.show();
        
    }
    /**
     * From this line below are getters and setters
     **/
    
	public Button getOwnerButton() {
		return ownerButton;
	}

	public void setOwnerButton(Button ownerButton) {
		this.ownerButton = ownerButton;
	}

	public Button getUserButton() {
		return userButton;
	}

	public void setUserButton(Button userButton) {
		this.userButton = userButton;
	}
	
	public Button getZamer() {
		return zamer;
	}

	public void setZamer(Button zamer) {
		this.zamer = zamer;
	}

    // Singleton design pattern continuing
	public static PrihlasovacieOkno getInstance() {
        while(instance == null) {
        	// this is required because of JavaFX, see: http://stackoverflow.com/questions/27652509/getting-application-instance-in-javafx
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// skip
			}
        }
		return instance;
	}

	public static void setInstance(PrihlasovacieOkno instance) {
		PrihlasovacieOkno.instance = instance;
	}

}
