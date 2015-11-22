package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeventhQuestion extends Application {
	String kysimus7 = ("Palun valige sobiv piirkond");

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
        Scene scene = new Scene(vbox, 200, 175);
        primaryStage.setScene(scene);
        Label kys7 = new Label();
        kys7.setText("Palun valige sobiv piirkond");
        kys7.setTranslateX(20);
        kys7.setTranslateY(5);
        ToggleGroup kysimus7 = new ToggleGroup();
        RadioButton k1 = new RadioButton("EESTI!!");
        RadioButton k2 = new RadioButton("Euro-Neuro");
        RadioButton k3 = new RadioButton("The World Is Not Enough");
        k1.setToggleGroup(kysimus7);
        k2.setToggleGroup(kysimus7);
        k3.setToggleGroup(kysimus7);
        k3.setSelected(true);
        vbox.getChildren().addAll(kys7, k1, k2, k3);
        primaryStage.show();
	}
}
