package atmPack;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Withdraw {

	GUImain main;
	Scene scene;
	UserAccount acc = new UserAccount();
	Stage stage;
    TransactionCls trans=new TransactionCls();
	
	
	
	public Withdraw(Stage stage) {
		this.stage = stage;
	}

	
	
	
	
	
	
	private void prepScene() {
		
		
		
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button zero = new Button("0");
		GridPane grid = new GridPane();

        grid.add(seven,3,0);		
        grid.add(four,3,1);		
        grid.add(one,3,2);		
        grid.add(eight,4,0);		
        grid.add(five,4,1);		
        grid.add(two,4,2);		
        grid.add(nine,5,0);		
        grid.add(six,5,1);		
        grid.add(three,5,2);		
        grid.add(zero,6,0);		
        
        
        
        Button back = new Button("BACK");
		Button enter = new Button("ENTER");
		final TextField text = new TextField();
        final Label label =new Label();
		Label lb1 = new Label("WITHDRAW");
        
		grid.add(enter, 6, 1);
		grid.add(text, 0,0 );
		grid.add(label, 0, 2);
		grid.add(lb1, 0, 1);
		grid.add(back, 6, 2);
		
		 
      
		one.setOnAction(new EventHandler() {

			public void handle(Event event) {
			
			    text.setText(text.getText()+"1");
			  
			}
			
		});
		two.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"2");
			}
			
		});
		
		three.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"3");
			}
			
		});
		four.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"4");
			}
			
		});
		five.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"5");
			}
			
		});
		six.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"6");
			}
			
		});
		seven.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"7");
			}
			
		});
		eight.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"8");
			}
			
		});
		nine.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"9");
			}
			
		});
		zero.setOnAction(new EventHandler() {

			public void handle(Event event) {
				 text.setText(text.getText()+"0");
			}
			
		});
		
		
		
		
		
		
		
		enter.setOnAction(new EventHandler() {

			public void handle(Event event) {
				final String num = text.getText();
				
				if (UserAccount.balance>=Integer.parseInt(num))
				{
				UserAccount.balance = UserAccount.balance - Integer.parseInt(num);
				stage.setScene(main.getScene());
				if (TransactionCls.i==5)
                {
					int x =0;
					while (x<4)
					{
						TransactionCls.amount[x]=TransactionCls.amount[x+1];
						TransactionCls.type[x]=TransactionCls.type[x+1];
						x++;
					}
					TransactionCls.i=4;
                }
				TransactionCls.amount[TransactionCls.i] = "withdraw";
				TransactionCls.type[TransactionCls.i] =text.getText();
				TransactionCls.i++;
				text.setText("");
				}
				else 
				{
					label.setText("INVALID AMOUNT");
				    text.setText("");
				}
				
				
				
			}

		});
		
		back.setOnAction(new EventHandler() {

			public void handle(Event event) {
				text.setText("");
				stage.setScene(main.getScene());
			}
			
		});
		
				
		

		scene = new Scene(grid, 600, 400);
		scene.getStylesheets().add(getClass().getResource("styling.css").toString());
	}

	
	
	public Scene getScene() {
		if (scene == null)
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
