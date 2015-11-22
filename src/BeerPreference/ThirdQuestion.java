package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThirdQuestion extends Application {
	String kysimus3 = ("Palun valige sobiv värvus");

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
        Scene scene = new Scene(vbox, 200, 175);
        primaryStage.setScene(scene);
        Label kys3 = new Label();
        kys3.setText("Palun valige sobiv värvus");
        kys3.setTranslateX(20);
        kys3.setTranslateY(5);
        ToggleGroup kysimus3 = new ToggleGroup();
        RadioButton k1 = new RadioButton("Naeratav blondiin");
        RadioButton k2 = new RadioButton("Õhestav punapea");
        RadioButton k3 = new RadioButton("Naudisklev brünett");
        k1.setToggleGroup(kysimus3);
        k2.setToggleGroup(kysimus3);
        k3.setToggleGroup(kysimus3);
        k3.setSelected(true);
        vbox.getChildren().addAll(kys3, k1, k2, k3);
        primaryStage.show();
		
	}
	

}
