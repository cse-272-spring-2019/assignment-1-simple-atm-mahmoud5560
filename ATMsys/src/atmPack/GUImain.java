package atmPack;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUImain {

	Stage stage;
	private Scene scene = null;
	private GUIlogin login;
	Withdraw draw;
	GUIdeposite deposite;
	TransactionCls trans = new TransactionCls();

	public GUImain(Stage stage) {
		this.stage = stage;
	}

	private void prepScene() {
		Button withdraw = new Button(" WITHDRAW ");
		Button deposite = new Button("  DEPOSITE    ");
		Button balanceInquiry = new Button("MY BALANCE");
		Button next = new Button("      NEXT      ");
		Button previous = new Button("   PREVIOUS  ");
		final Label label = new Label();

		GridPane grid = new GridPane();

		grid.add(withdraw, 0, 0);
		grid.add(deposite, 0, 1);
		grid.add(balanceInquiry, 0, 2);
		grid.add(next, 0, 3);
		grid.add(previous, 0, 4);
		grid.add(label, 0, 5);

		balanceInquiry.setOnAction(new EventHandler() {
			public void handle(Event event) {
				// TODO Auto-generated method stub
				TransactionCls.n=4;
				label.setText("YOUR BALANCE IS: " + UserAccount.balance+"$");
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
				TransactionCls.amount[TransactionCls.i] = "balance inquiry";
				TransactionCls.type[TransactionCls.i] =""+ UserAccount.balance;
				TransactionCls.i++;
			}
		});

		withdraw.setOnAction(new EventHandler() {

			public void handle(Event event) {
				TransactionCls.n=4;
				label.setText("");
				stage.setScene(draw.getScene());

			}

		});

		deposite.setOnAction(new EventHandler() {

			public void handle(Event arg0) {
				TransactionCls.n=4;
				label.setText("");
				stage.setScene(GUImain.this.deposite.getScene());

			}

		});

		previous.setOnAction(new EventHandler() {

			public void handle(Event event) {
				if(TransactionCls.n>4)
				{
					TransactionCls.n=4;
				}
				if(TransactionCls.n<0)
				{
					TransactionCls.n=0;
				}
				if(TransactionCls.n<5)
				{
				while (TransactionCls.n>=0)
				{
				if (TransactionCls.type[TransactionCls.n] != null && TransactionCls.amount[TransactionCls.n] != null)
				{
					label.setText(TransactionCls.amount[TransactionCls.n] + ":" + TransactionCls.type[TransactionCls.n]+"$");
					TransactionCls.n--;
					break;
				}
				TransactionCls.n--;
				}
			}
			}

		});

		next.setOnAction(new EventHandler() {

			public void handle(Event event) {
				
				if(TransactionCls.n<0)
				{
					TransactionCls.n=0;
				}
				if(TransactionCls.n<4)
					TransactionCls.n++;
				{
				if (TransactionCls.type[TransactionCls.n] != null && TransactionCls.amount[TransactionCls.n] != null)
				{
					label.setText(TransactionCls.amount[TransactionCls.n] + ":" + TransactionCls.type[TransactionCls.n]+"$");
				}
				}
				

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

	public GUIlogin getLogin() {
		return login;
	}

	public void setLogin(GUIlogin login) {
		this.login = login;
	}

	public Withdraw getDraw() {
		return draw;
	}

	public void setDraw(Withdraw draw) {
		this.draw = draw;
	}

	public GUIdeposite getDeposite() {
		return deposite;
	}

	public void setDeposite(GUIdeposite deposite) {
		this.deposite = deposite;
	}

	public TransactionCls getTrans() {
		return trans;
	}

	public void setTrans(TransactionCls trans) {
		this.trans = trans;
	}

}
