package atmPack;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainCLs extends Application {


	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		GUIlogin login = new GUIlogin(primaryStage);
		GUImain main=new GUImain(primaryStage);
	    Withdraw draw=new Withdraw(primaryStage);
		GUIdeposite deposite = new GUIdeposite(primaryStage);
	    
		login.setMain(main);
		main.setDraw(draw);
		draw.setMain(main);
		main.setDeposite(deposite);
		deposite.setMain(main);
		
		
		primaryStage.setTitle("ATM APP");
		primaryStage.setScene(login.getScene());
		primaryStage.show();

	}

}
