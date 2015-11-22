package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FifthQuestion extends Application {
	String kysimus5 = ("Palun valige sobiv maitse");

	@Override

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
		Scene scene = new Scene(vbox, 200, 175);
		primaryStage.setScene(scene);
		Label kys5 = new Label();
		kys5.setText("Palun valige sobiv maitse");
		kys5.setTranslateX(20);
		kys5.setTranslateY(5);
		ToggleGroup kysimus5 = new ToggleGroup();
		RadioButton k1 = new RadioButton("Oot...see maitseb ju nagu....vesi?!");
		RadioButton k2 = new RadioButton("Päris hea humalane ettevõtmine");
		RadioButton k3 = new RadioButton("Oleme me kindlad, et tegu on lahja alkoholiga??");
		k1.setToggleGroup(kysimus5);
		k2.setToggleGroup(kysimus5);
		k3.setToggleGroup(kysimus5);
		k3.setSelected(true);
		vbox.getChildren().addAll(kys5, k1, k2, k3);
		primaryStage.show();

	}

}
