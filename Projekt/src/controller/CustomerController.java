package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OsobnyVlak;
import model.Stanica;
import view.ZakaznickeOkno;
import view.ManazerskeOkno;
import view.OknoPridaj;

public class CustomerController implements EventHandler<ActionEvent> {
	private ZakaznickeOkno customerView;
	private ArrayList<OsobnyVlak> vlaky = new ArrayList<OsobnyVlak>();
	private ObservableList<OsobnyVlak> tab = FXCollections.observableArrayList();
	TableColumn<OsobnyVlak, String> lineCode = new TableColumn<>("KÛd Linky");
	TableColumn<OsobnyVlak, String> company = new TableColumn<>("SpoloËnosù");
    TableColumn<OsobnyVlak, String> odchod = new TableColumn<>("Z");
    TableColumn<OsobnyVlak, String> prichod = new TableColumn<>("Do");
    TableColumn<OsobnyVlak, Integer> speed = new TableColumn<>("R˝chlosù");
    
	public CustomerController(ZakaznickeOkno customerView) {
		        this.customerView = customerView;
		        customerView.getAddButton().setOnAction(this);
		        customerView.getReplaceButton().setOnAction(this);
		        customerView.getDetailButton().setOnAction(this);
		        customerView.getSortButton().setOnAction(this);
		        customerView.getRemoveButton().setOnAction(this);
		        customerView.getTypVlaku().setOnAction(this);
                customerView.getTrains().getColumns().addAll(lineCode, company, odchod, prichod, speed);
		    }
	@Override
	public void handle(ActionEvent event) {
		customerView.getAddButton().setOnAction(new EventHandler <ActionEvent>()
        {
                @Override
                public void handle(ActionEvent t)
                {
                		OknoPridaj addView = OknoPridaj.getInstance();
                		addView.getPridaj().setOnAction(new EventHandler <ActionEvent>()
                        {
                            @Override
                            public void handle(ActionEvent t)
                            {
                            	OsobnyVlak novyVlak = new OsobnyVlak();
                            	novyVlak.setKodLinky(addView.getKodLinky().getText());
                            	novyVlak.setSpolocnost(addView.getCompany().getValue());
                            	customerView.getZoznam().add(addView.getKodLinky().getText());
                            	String st = addView.getFrom().getValue();	
                            			switch (st)
                            			{
                            			    case "Bratislava": novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Koöice":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Preöov":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "éilina":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Bansk· Bystrica":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Nitra":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Trnava":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "TrenËÌn":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Martin":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			    case "Poprad":novyVlak.setVychodziaStanica(new Stanica(st));break;
                            			}
                            	String st2 = addView.getTo().getValue();
                            			switch (st2)
                            			{
                            				case "Bratislava": novyVlak.setCielovaStanica(new Stanica(st2));break;
                            				case "Koöice":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "Preöov":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "éilina":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "Bansk· Bystrica":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "Nitra":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "Trnava":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "TrenËÌn":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "Martin":novyVlak.setCielovaStanica(new Stanica(st2));break;
		                    			    case "Poprad":novyVlak.setCielovaStanica(new Stanica(st2));break;
                            			}
                            novyVlak.setDlzkaTrasy();
                            novyVlak.setRychlost();
                            novyVlak.setStart(novyVlak.getVychodziaStanica().getNazov());
                            novyVlak.setCiel(novyVlak.getCielovaStanica().getNazov());
                            vlaky.add(novyVlak);
                            tab.add(novyVlak);
                            }
                        });
                	    //customerView.getZoznam().add(customerView.getLinka().getText());
                	    customerView.getList().getSelectionModel().clearSelection();
                }
        }
        );
		customerView.getZoznam().addListener (new ListChangeListener<Object>()
        {
            @Override
            public void onChanged(ListChangeListener.Change change)
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Upozornenie");
                alert.setHeaderText(null);
                alert.setContentText("Zoznam liniek bol uspesne upraveny!");
                alert.showAndWait();
            } 
        }
        );
		customerView.getSortButton().setOnAction(new EventHandler <ActionEvent>()
        {
                @Override
                public void handle(ActionEvent t)
                {
                		FXCollections.sort(customerView.getZoznam());
                		customerView.getList().getSelectionModel().clearSelection();
                }
        }
        );
		customerView.getRemoveButton().setOnAction(new EventHandler <ActionEvent>()
		{
            @Override
            public void handle(ActionEvent t)
            {
            		if(!customerView.getList().getSelectionModel().isEmpty())
            		{
            			/*if(customerView.getList().getSelectionModel().getSelectedItems().size()>1)
            			{
            				
            				
            			}**/
            			customerView.getZoznam().remove(customerView.getList().getSelectionModel().getSelectedItem());
            		}
            		else { System.out.println("Vyber aspon jednu vec na vymazanie!");
            		}
            		customerView.getList().getSelectionModel().clearSelection();
            }
    }
	);
		customerView.getReplaceButton().setOnAction(new EventHandler <ActionEvent>()
        {
                @Override
                public void handle(ActionEvent t)
                {
                		if(customerView.getList().getSelectionModel().isEmpty()||customerView.getLinka().getText().isEmpty())
                		{
                			System.out.println("Vyber polozku na prepisanie a napis novy nazov!");
                		}
                		else{
                			customerView.getZoznam().set(customerView.getList().getSelectionModel().getSelectedIndex(), customerView.getLinka().getText());
                			customerView.getList().getSelectionModel().clearSelection();
                		}
                }
        }
        );
		customerView.getDetailButton().setOnAction(new EventHandler <ActionEvent>()
        {
                @Override
                public void handle(ActionEvent t)
                {
                	    customerView.getTrains().setItems(tab);
                	    lineCode.setMinWidth(100);
                        lineCode.setCellValueFactory(
                        		new PropertyValueFactory<OsobnyVlak, String>("kodLinky"));
                        company.setMinWidth(100);
                        company.setCellValueFactory(
                        		new PropertyValueFactory<OsobnyVlak, String>("spolocnost"));
                        odchod.setMinWidth(100);
                        odchod.setCellValueFactory(
                        		new PropertyValueFactory<OsobnyVlak, String>("start"));
                        prichod.setMinWidth(100);
                        prichod.setCellValueFactory(
                        		new PropertyValueFactory<OsobnyVlak, String>("ciel"));
                        speed.setMinWidth(100);
                        speed.setCellValueFactory(
                        		new PropertyValueFactory<OsobnyVlak, Integer>("rychlost"));
                		customerView.getTrains().setVisible(true);
                }
        }
        );
		customerView.getTypVlaku().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
            		if(customerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
            		{
            			customerView.getList().setItems(customerView.getZoznam());
            			customerView.getList().getSelectionModel().clearSelection();
            		}
            		if(customerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
            		{
            			customerView.getList().setItems(customerView.getZoznam2());
            			customerView.getList().getSelectionModel().clearSelection();
            		}
            		
            }
    }
    );
	}
}
