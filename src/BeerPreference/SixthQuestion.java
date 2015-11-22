package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SixthQuestion extends Application {
	String kysimus6 = ("Palun valige sobiv tüüp");

	@Override

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
		Scene scene = new Scene(vbox, 200, 175);
		primaryStage.setScene(scene);
		Label kys6 = new Label();
		kys6.setText("Palun valige sobiv tüüp");
		kys6.setTranslateX(20);
		kys6.setTranslateY(5);
		ToggleGroup kysimus6 = new ToggleGroup();
		RadioButton k1 = new RadioButton("Malbe ja tagasihoidlik");
		RadioButton k2 = new RadioButton("Põhimõtteliselt olen valmis seikluseks, vist");
		RadioButton k3 = new RadioButton("Don't care, don't want to know!");
		k1.setToggleGroup(kysimus6);
		k2.setToggleGroup(kysimus6);
		k3.setToggleGroup(kysimus6);
		k3.setSelected(true);
		vbox.getChildren().addAll(kys6, k1, k2, k3);
		primaryStage.show();

	}

}
