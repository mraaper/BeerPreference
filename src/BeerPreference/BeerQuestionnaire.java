package BeerPreference;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BeerQuestionnaire extends Application{
	
	//Osad koodiread baseeruvad Krister Viirsaare Java koduleheküljel http://i200.itcollege.ee/javafx
    	
		String kysimus1 = ("Mis on Teie nimi, härra/preili?");
		String kysimus2 = ("Palun sisestage oma vanus");
		@Override
		public void start(Stage primaryStage) throws Exception {
			
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(7);
        Scene scene = new Scene(vbox, 100, 100);
        primaryStage.setScene(scene);
        Label kys1 = new Label();
        kys1.setText("Kysimuse sisu");
        kys1.setTranslateX(0);
        kys1.setTranslateY(0);
        ToggleGroup kysimus1 = new ToggleGroup();
        RadioButton k1 = new RadioButton("Variant 1");
        RadioButton k2 = new RadioButton("Variant 2");
        RadioButton k3 = new RadioButton("Variant 3");
        k1.setToggleGroup(kysimus1);
        k2.setToggleGroup(kysimus1);
        k3.setToggleGroup(kysimus1);
        k3.setSelected(true);
        vbox.getChildren().addAll(kys1, k1, k2, k3);
        primaryStage.show();	
		}
		
		
	
		
	}


