package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.User;
import model.NakladnyVlak;
import model.OsobnyVlak;
import controller.ManagerController;
import view.PrihlasovacieOkno;
import view.ManazerskeOkno;
import view.OknoPridaj;
import view.ZakaznickeOkno;
import view.ZamerOkno;
/**
* @author Michal Bystricky - prebrane z cvicenia
*/
public class Login implements EventHandler<ActionEvent> {
	
    public static void main(String[] args) {
    	new Thread() {
            @Override
            public void run() {
            	javafx.application.Application.launch(PrihlasovacieOkno.class);
            }
        }.start();
        
        Login login = new Login();
        login.bindActions(PrihlasovacieOkno.getInstance());
        //OsobnyVlak t1 = new OsobnyVlak();
        //t1.napln();
        //NakladnyVlak t2 = new NakladnyVlak();
        //t2.napln();
    }

	public void handle(ActionEvent event) {
		String user = ((Button) event.getSource()).getText();
		switch (user) {
			case "Majite¾": 
				if (User.verify("none")) {
					ManazerskeOkno okno1 = new ManazerskeOkno();
			        ManagerController manager = new ManagerController(okno1);
				}
				break;
			case "Zákazník": 
				if (User.verify("none")) {
					ZakaznickeOkno okno2 = new ZakaznickeOkno();
					CustomerController customer = new CustomerController(okno2);
				}
				break;
			case "Zámer projektu": 
				if (User.verify("none")) {
					ZamerOkno zamer = ZamerOkno.getInstance();
				}
				break;
			default:
				System.err.println("Unknown user. This incident will be reported.");
				break;
		}
	}

    public void bindActions(PrihlasovacieOkno loginWindow) {
    	loginWindow.getOwnerButton().setOnAction(this);
    	loginWindow.getUserButton().setOnAction(this);
    	loginWindow.getZamer().setOnAction(this);
    }
}

