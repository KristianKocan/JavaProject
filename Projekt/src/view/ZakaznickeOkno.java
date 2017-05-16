package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ZakaznickeOkno extends Stage {

        private StackPane root = new StackPane();
        private Button addButton = new Button("Pridaj");
        private Button replaceButton = new Button("Uprav");
        private Button detailButton = new Button("Zobraz detail");
        private Button sortButton = new Button("Zotrieï");
        private Button removeButton = new Button("Odober");
        private TextField linka = new TextField("");
        private ComboBox<String> typVlaku = new ComboBox<String>();
        private ListView<String> list = new ListView<> ();
        private ObservableList<String> zoznam = FXCollections.observableArrayList(
                            "R600",
                            "R601",
                            "R602",
                            "R603",
                            "R604",
                            "R605"); 
        private ObservableList<String> zoznam2 = FXCollections.observableArrayList(
                "Vlak1",
                "Vlak2",
                "Vlak3",
                "Vlak4",
                "Vlak5",
                "Vlak6"); 
    	private TableView trains = new TableView();
        
    public ZakaznickeOkno () {
        	super();
            this.setTitle("Manazerske Okno");
            list.setItems(zoznam);
            list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            list.setMaxSize(100,200);
            StackPane.setAlignment(list,Pos.TOP_LEFT);
            StackPane.setMargin(list, new Insets(40,20,20,20));
            trains.setEditable(true);
            trains.setVisible(false);
            StackPane.setAlignment(trains,Pos.TOP_CENTER);
            StackPane.setMargin(trains, new Insets(60,30,60,140));
            typVlaku.getItems().addAll("Osobný Vlak","Nákladný Vlak");
            typVlaku.setEditable(true);  
            StackPane.setAlignment(typVlaku,Pos.TOP_RIGHT);
            StackPane.setMargin(typVlaku, new Insets(20,20,20,20));
            Scene scene2 = new Scene(this.root,800,400);
            Label title = new Label("Aktuálne Linky:");
            StackPane.setAlignment(title, Pos.TOP_LEFT);
            StackPane.setMargin(title, new Insets(10,20,20,20));
            Label nazov = new Label("Nazov linky:");
            StackPane.setAlignment(linka,Pos.BOTTOM_LEFT);
            StackPane.setMargin(linka, new Insets(20,500,20,100));
            StackPane.setAlignment(nazov,Pos.BOTTOM_LEFT);
            StackPane.setMargin(nazov, new Insets(20,20,20,20));
            StackPane.setAlignment(addButton,Pos.BOTTOM_CENTER);
            StackPane.setMargin(addButton, new Insets(20,20,20,10));
            StackPane.setAlignment(replaceButton,Pos.BOTTOM_CENTER);
            StackPane.setMargin(replaceButton, new Insets(20,20,20,120));
            StackPane.setAlignment(detailButton,Pos.BOTTOM_CENTER);
            StackPane.setMargin(detailButton, new Insets(20,20,20,270));
            StackPane.setAlignment(sortButton,Pos.BOTTOM_CENTER);
            StackPane.setMargin(sortButton, new Insets(20,20,20,430));
            StackPane.setAlignment(removeButton,Pos.BOTTOM_RIGHT);
            StackPane.setMargin(removeButton, new Insets(20,20,20,20));
            this.root.getChildren().addAll(list,title,typVlaku,trains,addButton,replaceButton,detailButton,sortButton,removeButton,linka,nazov);
            typVlaku.getSelectionModel().selectFirst();
            this.setScene(scene2);
            this.sizeToScene(); 
            this.show();
        }
    	/**
         * From this line below are getters and setters
         **/
    	public ComboBox<String> getTypVlaku() {
    		return typVlaku;
    	}
    	public void setTypVlaku(ComboBox<String> typVlaku) {
    		this.typVlaku = typVlaku;
    	}
        public TableView getTrains() {
    		return trains;
    	}
    	public void setTrains(TableView trains) {
    		this.trains = trains;
    	}
    	public TextField getLinka() {
    		return linka;
    	}
    	public void setLinka(TextField linka) {
    		this.linka = linka;
    	}
    	public ListView<String> getList() {
    		return list;
    	}
    	public void setList(ListView<String> list) {
    		this.list = list;
    	}
    	public ObservableList<String> getZoznam() {
    		return zoznam;
    	}
    	public void setLudia(ObservableList<String> zoznam) {
    		this.zoznam = zoznam;
    	}  
    	public ObservableList<String> getZoznam2() {
    		return zoznam2;
    	}
    	public void setZoznam2(ObservableList<String> zoznam2) {
    		this.zoznam2 = zoznam2;
    	}
    	public Button getAddButton() {
    		return addButton;
    	}
    	public void setAddButton(Button addButton) {
    		this.addButton = addButton;
    	}
    	public Button getReplaceButton() {
    		return replaceButton;
    	}
    	public void setReplaceButton(Button replaceButton) {
    		this.replaceButton = replaceButton;
    	}
    	
    	public Button getDetailButton() {
    		return detailButton;
    	}
    	public void setDetailButton(Button detailButton) {
    		this.detailButton = detailButton;
    	}
    	public Button getSortButton() {
    		return sortButton;
    	}
    	public void setSortButton(Button sortButton) {
    		this.sortButton = sortButton;
    	}
    	public Button getRemoveButton() {
    		return removeButton;
    	}
    	public void setRemoveButton(Button removeButton) {
    		this.removeButton = removeButton;
    	}
    }

