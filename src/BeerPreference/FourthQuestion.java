package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FourthQuestion extends Application {
	String kysimus4 = ("Palun valige sobiv tugevus");

	@Override

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
		Scene scene = new Scene(vbox, 200, 175);
		primaryStage.setScene(scene);
		Label kys4 = new Label();
		kys4.setText("Palun valige sobiv tugevus");
		kys4.setTranslateX(20);
		kys4.setTranslateY(5);
		ToggleGroup kysimus4 = new ToggleGroup();
		RadioButton k1 = new RadioButton("Kärbes/sulgkaal");
		RadioButton k2 = new RadioButton("Isa soovitusel palun midagi head");
		RadioButton k3 = new RadioButton("Sink the Bismarck!");
		k1.setToggleGroup(kysimus4);
		k2.setToggleGroup(kysimus4);
		k3.setToggleGroup(kysimus4);
		k3.setSelected(true);
		vbox.getChildren().addAll(kys4, k1, k2, k3);
		primaryStage.show();

	}

}
