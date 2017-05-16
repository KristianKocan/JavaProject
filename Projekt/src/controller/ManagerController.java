package controller;

import view.ManazerskeOkno;
import view.OknoPridaj;
import view.OknoPridaj2;
import view.PrihlasovacieOkno;
import model.Vlak;
import model.NakladnyVlak;
import model.OsobnyVlak;
import model.Stanica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class ManagerController implements EventHandler<ActionEvent>{

	private ManazerskeOkno managerView;
	private OknoPridaj addView;
	private ArrayList<OsobnyVlak> vlaky = new ArrayList<OsobnyVlak>();
	private ArrayList<NakladnyVlak> vlaky2 = new ArrayList<NakladnyVlak>();
	private ObservableList<OsobnyVlak> tab = FXCollections.observableArrayList();
	private ObservableList<NakladnyVlak> tab2 = FXCollections.observableArrayList();
	private ArrayList<OsobnyVlak> list = new ArrayList<OsobnyVlak>();
	private ArrayList<NakladnyVlak> list2 = new ArrayList<NakladnyVlak>();
	TableColumn<OsobnyVlak, String> lineCode = new TableColumn<>("KÛd Linky");
	TableColumn<OsobnyVlak, String> company = new TableColumn<>("SpoloËnosù");
    TableColumn<OsobnyVlak, String> odchod = new TableColumn<>("Z");
    TableColumn<OsobnyVlak, String> prichod = new TableColumn<>("Do");
    TableColumn<OsobnyVlak, Integer> speed = new TableColumn<>("R˝chlosù");
    TableColumn<OsobnyVlak, Integer> vzdialenost = new TableColumn<>("Vzdialenosù");
    TableColumn<NakladnyVlak, String> spol = new TableColumn<>("SpoloËnosù");
    TableColumn<NakladnyVlak, String> odch = new TableColumn<>("Z");
    TableColumn<NakladnyVlak, String> prich = new TableColumn<>("Do");
    TableColumn<NakladnyVlak, Integer> fast = new TableColumn<>("R˝chlosù");
    TableColumn<NakladnyVlak, Integer> distance = new TableColumn<>("Vzdialenosù");
    TableColumn<NakladnyVlak, Integer> weight = new TableColumn<>("Nosnosù");
    TableColumn<NakladnyVlak, String> tovar = new TableColumn<>("Druh Tovaru");
    TableColumn<NakladnyVlak, String> obj = new TableColumn<>("Objedn·vateæ");
    
	public ManagerController(ManazerskeOkno managerView) {
		        this.managerView = managerView;
		        managerView.getAddButton().setOnAction(this);
		        managerView.getReplaceButton().setOnAction(this);
		        managerView.getDetailButton().setOnAction(this);
		        managerView.getSortButton().setOnAction(this);
		        managerView.getRemoveButton().setOnAction(this);
		        managerView.getTypVlaku().setOnAction(this);
                managerView.getTrains().getColumns().addAll(lineCode, company, odchod, prichod, speed, vzdialenost);
                managerView.getTrains2().getColumns().addAll(spol, odch, prich, fast, distance, weight, tovar, obj);
                list = null;
         		try {
        	         FileInputStream fileIn = new FileInputStream("trains.txt");
        	         ObjectInputStream in = new ObjectInputStream(fileIn);
        	         list = (ArrayList) in.readObject();
        	         in.close();
        	         fileIn.close();
        	      }catch(IOException i) {
        	         i.printStackTrace();
        	         return;
        	      }catch(ClassNotFoundException c) {
        	         System.out.println("Vlaky neboli najdene!");
        	         c.printStackTrace();
        	         return;
        	      }
         		vlaky = list;
         		int i=0;
         		for(OsobnyVlak tr :list){
         			tab.add(tr);
         			managerView.getZoznam().add(tr.getKodLinky());
	         		}
         		list2 = null;
         		try {
        	         FileInputStream fileIn = new FileInputStream("LoadTrains.txt");
        	         ObjectInputStream in = new ObjectInputStream(fileIn);
        	         list2 = (ArrayList) in.readObject();
        	         in.close();
        	         fileIn.close();
        	      }catch(IOException z) {
        	         z.printStackTrace();
        	         return;
        	      }catch(ClassNotFoundException c) {
        	         System.out.println("Vlaky neboli najdene!");
        	         c.printStackTrace();
        	         return;
        	      }
         		vlaky2 = list2;
         		i=0;
         		for(NakladnyVlak tr2 :list2){
         			tab2.add(tr2);
         			managerView.getZoznam2().add(tr2.getObjednavatel());
	         		}
         		//multithreading
                new Thread() {
                    @Override
                    public void run() {
                    	managerView.getZoznam().addListener (new ListChangeListener<Object>()
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
                    	managerView.getTypVlaku().setOnAction(new EventHandler <ActionEvent>()
                    {
                        @Override
                        public void handle(ActionEvent t)
                        {
                        		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
                        		{
                        			managerView.getTrains2().setVisible(false);
                        			managerView.getList().setItems(managerView.getZoznam());
                        			managerView.getList().getSelectionModel().clearSelection();
                        			
                        			
                        		}
                        		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
                        		{
                        			managerView.getTrains().setVisible(false);
                        			managerView.getList().setItems(managerView.getZoznam2());
                        			managerView.getList().getSelectionModel().clearSelection();
                        			
                        		}
                        		
                        }
                }
                );
              }      
                }.start();
		    }
	
	@Override
    public void handle(ActionEvent event) 
    {
		String tlacidlo = ((Button) event.getSource()).getId();
        switch(tlacidlo) { //switch statement for each of the action command 
            case "Pridaj":
            	if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
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
                             managerView.getZoznam().add(addView.getKodLinky().getText());
                             String st = addView.getFrom().getValue();	
                             novyVlak.setVychodziaStanica(new Stanica(st));
                             String st2 = addView.getTo().getValue();
                             novyVlak.setCielovaStanica(new Stanica(st2));		
                             novyVlak.setDlzkaTrasy();
                             novyVlak.setRychlost();
                             novyVlak.setStart(novyVlak.getVychodziaStanica().getNazov());
                             novyVlak.setCiel(novyVlak.getCielovaStanica().getNazov());
                             vlaky.add(novyVlak);
                             tab.add(novyVlak);
                      		}
                       });
                	managerView.getList().getSelectionModel().clearSelection();
        		}
        		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
        		{
        			OknoPridaj2 addView = OknoPridaj2.getInstance();
                	addView.getPridaj().setOnAction(new EventHandler <ActionEvent>()
                    {
                        @Override
                        public void handle(ActionEvent j)
                        {
                        	NakladnyVlak novyVlak = new NakladnyVlak();
                        	novyVlak.setObjednavatel(addView.getCustomer().getText());
                  			novyVlak.setSpolocnost(addView.getCompany().getValue());
                  			managerView.getZoznam2().add(addView.getCustomer().getText());
                  			String st = addView.getFrom().getValue();	
                            novyVlak.setVychodziaStanica(new Stanica(st));
                            String st2 = addView.getTo().getValue();
                            novyVlak.setCielovaStanica(new Stanica(st2));	
                            novyVlak.setDlzkaTrasy();
                            int n = Integer.parseInt(addView.getVagony().getText());
                            novyVlak.setPocetVagonov(n);
                            novyVlak.setRychlost();
                            novyVlak.setNosnost(n);
                            novyVlak.setTypPrevazanehoTovaru(addView.getType().getValue());
                            novyVlak.setStart(novyVlak.getVychodziaStanica().getNazov());
                            novyVlak.setCiel(novyVlak.getCielovaStanica().getNazov());
                            vlaky2.add(novyVlak);
                            tab2.add(novyVlak);
                      		}
                    });
                	managerView.getList().getSelectionModel().clearSelection();
        		}
                break;
            case "PrepÌö": 
            	if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
        		{
        			if(managerView.getList().getSelectionModel().isEmpty()||managerView.getLinka().getText().isEmpty())
        			{
        			System.out.println("Vyber polozku na prepisanie a napis novy nazov!");
        			}
        			else{
        			managerView.getZoznam().set(managerView.getList().getSelectionModel().getSelectedIndex(), managerView.getLinka().getText());
        			managerView.getList().getSelectionModel().clearSelection();
        			}
        		}
        		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
        		{
        			if(managerView.getList().getSelectionModel().isEmpty()||managerView.getLinka().getText().isEmpty())
        			{
        				System.out.println("Vyber polozku na prepisanie a napis novy nazov!");
        			}
        			else{
        				managerView.getZoznam2().set(managerView.getList().getSelectionModel().getSelectedIndex(), managerView.getLinka().getText());
        				managerView.getList().getSelectionModel().clearSelection();
        			}
        		}
            	break;
            case "Podrobnosti": 
            	managerView.getTrains().setItems(tab);
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
                 vzdialenost.setMinWidth(100);
                 vzdialenost.setCellValueFactory(
                 		new PropertyValueFactory<OsobnyVlak, Integer>("dlzkaTrasy"));
         		managerView.getTrains2().setItems(tab2);
         		 obj.setMinWidth(100);
                 obj.setCellValueFactory(
                		new PropertyValueFactory<NakladnyVlak, String>("objednavatel"));
                 odch.setMinWidth(100);
                 odch.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, String>("start"));
                 prich.setMinWidth(100);
                 prich.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, String>("ciel"));
                 spol.setMinWidth(100);
         		 spol.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, String>("spolocnost"));
                 fast.setMinWidth(100);
                 fast.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, Integer>("rychlost"));
                 distance.setMinWidth(100);
                 distance.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, Integer>("dlzkaTrasy"));
                 weight.setMinWidth(100);
                 weight.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, Integer>("nosnost"));
                 tovar.setMinWidth(100);
                 tovar.setCellValueFactory(
                 		new PropertyValueFactory<NakladnyVlak, String>("typPrevazanehoTovaru"));
                 if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
                {
                	managerView.getTrains2().setVisible(false);
         			managerView.getTrains().setVisible(true);
         			managerView.getList().setItems(managerView.getZoznam());
         			managerView.getList().getSelectionModel().clearSelection();
         		}
         		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
         		{
         			managerView.getTrains().setVisible(false);
         			managerView.getTrains2().setVisible(true);
         			managerView.getList().setItems(managerView.getZoznam2());
         			managerView.getList().getSelectionModel().clearSelection();
         		}
                break;
            case "ZotrieÔ": 
            	if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
            	{
            		FXCollections.sort(managerView.getZoznam());
            		managerView.getList().getSelectionModel().clearSelection();
         		}
         		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
         		{
         			FXCollections.sort(managerView.getZoznam2());
            		managerView.getList().getSelectionModel().clearSelection();
         		}
            	break;
            case "Vymaû": 
        		
        		 if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("Osobn˝ Vlak"))
                 {
        			 if(!managerView.getList().getSelectionModel().isEmpty())
             		{
             			if(managerView.getList().getSelectionModel().getSelectedItems().size()>1){}
             			managerView.getZoznam().remove(managerView.getList().getSelectionModel().getSelectedItem());
             		}
             		else { System.out.println("Vyber aspon jednu vec na vymazanie!");
             		}
          		managerView.getList().getSelectionModel().clearSelection(); 
          		}
          		if(managerView.getTypVlaku().getSelectionModel().getSelectedItem().equals("N·kladn˝ Vlak"))
          		{
          			 if(!managerView.getList().getSelectionModel().isEmpty())
              		{
              			if(managerView.getList().getSelectionModel().getSelectedItems().size()>1){}
              			managerView.getZoznam2().remove(managerView.getList().getSelectionModel().getSelectedItem());
              		}
              		else { System.out.println("Vyber aspon jednu vec na vymazanie!");
              		}
           		managerView.getList().getSelectionModel().clearSelection(); 
          		}
            break;
            }
    }
}
/*if(vlaky.size()>1){
try {
    FileOutputStream fileOut = new FileOutputStream("trains.txt",true);
    ObjectOutputStream out = new ObjectOutputStream(fileOut);
    out.writeObject(vlaky);
    out.close();
    fileOut.close();
    //System.out.printf("SerializovanÈ d·ta boli uloûenÈ do trains.txt");
 }catch(IOException i) {
    i.printStackTrace();
 }
}**/
