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
		String kysimus2 = ("Palun märkige oma vanus");
		String kysimus3 = ("Palun valige enda maitse järgi õlule sobiv aroom");
		String kysimus4 = ("Palun valige sobiv värvus");
		String kysimus5 = ("Palun valige sobiv tugevus");
		String kysimus6 = ("Palun valige sobiv maitse");
		String kysimus7 = ("Palun valige sobiv tüüp");
		String kysimus8 = ("Palun valige sobiv piirkond");
		@Override
		public void start(Stage primaryStage) throws Exception {
			
		primaryStage.setTitle("Õllede küsimustik");
		VBox vbox = new VBox();
		vbox.setSpacing(17);
        Scene scene = new Scene(vbox, 200, 175);
        primaryStage.setScene(scene);
        Label kys1 = new Label();
        kys1.setText("Palun märkige oma vanus");
        kys1.setTranslateX(20);
        kys1.setTranslateY(5);
        ToggleGroup kysimus1 = new ToggleGroup();
        RadioButton k1 = new RadioButton("18-30");
        RadioButton k2 = new RadioButton("31-49");
        RadioButton k3 = new RadioButton("50-75");
        k1.setToggleGroup(kysimus1);
        k2.setToggleGroup(kysimus1);
        k3.setToggleGroup(kysimus1);
        k3.setSelected(true);
        vbox.getChildren().addAll(kys1, k1, k2, k3);
        primaryStage.show();	
		}
		
		
	
		
	}


