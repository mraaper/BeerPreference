package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecondQuestion extends Application {
	String kysimus2 = ("Palun valige enda maitse j�rgi �lule sobiv aroom");

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("�llede k�simustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
        Scene scene = new Scene(vbox, 200, 175);
        primaryStage.setScene(scene);
        Label kys2 = new Label();
        kys2.setText("Palun valige oma maitse j�rgi �lule sobiv aroom");
        kys2.setTranslateX(20);
        kys2.setTranslateY(5);
        ToggleGroup kysimus2 = new ToggleGroup();
        RadioButton k1 = new RadioButton("L�hnatu on mu teine nimi");
        RadioButton k2 = new RadioButton("Parajalt humalane ja h��");
        RadioButton k3 = new RadioButton("K�lmade talve�htute nauding");
        k1.setToggleGroup(kysimus2);
        k2.setToggleGroup(kysimus2);
        k3.setToggleGroup(kysimus2);
        k3.setSelected(true);
        vbox.getChildren().addAll(kys2, k1, k2, k3);
        primaryStage.show();
		
	}
	
	

}
