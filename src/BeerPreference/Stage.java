package BeerPreference;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Stage extends Application {

	@Override
	public void start(javafx.stage.Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
		Scene scene = new Scene(vbox, 200, 175);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
