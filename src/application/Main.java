package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Main extends Application {
	private TextField textField1;
	private TextField textField2;
	private TextField textField3;
	private TextField textField4;
	private Controller cont;

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 360, 600);
		scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
		root.setId("BorderPane");
		GridPane grid = new GridPane();
		GridPane fieldGrid = new GridPane();
		this.cont = new Controller();

		this.textField1 = new TextField();
		this.textField2 = new TextField();
		this.textField3 = new TextField();
		this.textField4 = new TextField();
		primaryStage.setResizable(false);
		root.setTop(fieldGrid);
		fieldGrid.add(textField1, 1, 1);
		fieldGrid.add(textField2, 1, 2);
		fieldGrid.add(textField3, 1, 3);
		fieldGrid.add(textField4, 1, 4);
		fieldGrid.setHgrow(textField1, Priority.ALWAYS);
		fieldGrid.setHgrow(textField2, Priority.ALWAYS);
		fieldGrid.setHgrow(textField3, Priority.ALWAYS);
		fieldGrid.setHgrow(textField4, Priority.ALWAYS);

		primaryStage.setScene(scene);
		primaryStage.show();
		textField1.setDisable(true);
		textField2.setDisable(true);
		textField3.setDisable(true);
		textField4.setDisable(true);
		root.setCenter(grid);

		grid.setHgap(10);
		grid.setVgap(10);

		updateFields();

		// Operationerna på vänstra sidan
		Button plus = new Button("+");
		grid.add(plus, 1, 2);
		plus.setOnAction(event -> {
			cont.plus();
			updateFields();
		});

		Button minus = new Button("-");
		grid.add(minus, 1, 3);
		minus.setOnAction(event -> {
			cont.minus();
			updateFields();
		});

		Button multi = new Button("*");
		grid.add(multi, 1, 4);
		multi.setOnAction(event -> {
			cont.multi();
			updateFields();
		});

		Button div = new Button("/");
		grid.add(div, 1, 5);
		div.setOnAction(event -> {
			cont.div();
			updateFields();
		});

		// Operationerna på högsta raden
		Button enter = new Button("Enter");
		grid.add(enter, 4, 1);
		enter.setId("buttonStyle3");
		enter.setOnAction(event -> {
			cont.enter();
			updateFields();
		});

		Button chs = new Button("Chs");
		grid.add(chs, 3, 1);
		chs.setId("buttonStyle3");
		chs.setOnAction(event -> {
			cont.CHS();
			updateFields();
		});

		Button clearStack = new Button("Clear Stack");
		grid.add(clearStack, 1, 1);
		clearStack.setId("buttonStyle3");
		clearStack.setOnAction(event -> {
			cont.clearStack();
			updateFields();
		});

		Button clear = new Button("Clear");
		grid.add(clear, 2, 1);
		clear.setId("buttonStyle3");
		clear.setOnAction(event -> {
			cont.clearLast();
			updateFields();
		});

		// skapar knapparna och sätter funktioner på de
		for (int i = 0; i < 10; i++) {
			int tal = i;
			Button newButton = new Button(String.valueOf(i));
			newButton.setOnAction(event -> {
				cont.push(tal);
				updateFields();
			});
			if (i == 0) {
				grid.add(newButton, 2, 5);
			} else if (i >= 1 && i <= 3) {
				grid.add(newButton, i + 1, 4);
			} else if (i >= 4 && i <= 6) {
				grid.add(newButton, i - 2, 3);

			} else if (i >= 7 && i <= 9) {
				grid.add(newButton, i - 5, 2);

			}

		}

	}

	/**
	 * Uppdaterar textFields som visas i skärmen
	 */

	public void updateFields() {
		double a = cont.getFrom(3);
		double b = cont.getFrom(2);
		double c = cont.getFrom(1);
		double d = cont.getFrom(0);
		textField1.setText(String.valueOf(a));
		textField2.setText(String.valueOf(b));
		textField3.setText(String.valueOf(c));
		textField4.setText(String.valueOf(d));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
