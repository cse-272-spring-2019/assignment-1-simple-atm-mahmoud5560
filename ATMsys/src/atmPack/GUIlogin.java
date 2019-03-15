package atmPack;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//IMP:user code is "1234"

public class GUIlogin {

	private ATMcls atm;
	private UserAccount acc;
    private Scene scene = null;
	GUImain main;
	Stage stage;
	
	
	public GUIlogin (Stage stage)
	{
		this.stage=stage;
	}
	
	private void prepScene ()
	{
		atm = new ATMcls();
		acc= new UserAccount();
		Label codelabel = new Label ("code:");
		final TextField codeField =new TextField();
		Button enter = new Button("Enter");
		final Label validlabel = new Label ();
		
		GridPane grid = new GridPane();
		grid.add( codelabel, 0, 0);
		grid.add( codeField, 0, 1);
		grid.add( enter, 1, 1);
		grid.add( validlabel, 0, 2);
		
		enter.setOnAction(new EventHandler() {
			public void handle(Event arg0) {
		
				String code = codeField.getText();
				boolean valid = atm.checkCode(acc.userCode, code);
				
				if (valid)
				{	
				stage.setScene(main.getScene());
				}
				else
			    {
					validlabel.setText("INVALID PLEASE TRY AGAIN");
				}
			}
		});
		scene = new Scene(grid , 600 , 400);
		scene.getStylesheets().add(getClass().getResource("styling.css").toString());
	}

	public Scene getScene() {
      	if(scene == null)
      		this.prepScene();
		return this.scene;
	}

	public GUImain getMain() {
		return main;
	}

	public void setMain(GUImain main) {
		this.main = main;
	}
	
	

}
