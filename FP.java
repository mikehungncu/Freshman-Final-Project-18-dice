package fp;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;
import javafx.util.Duration;
public class FP extends Application{
	public static Stage currentStage;
	public static Scene menuScene;
	static MediaPlayer player1;
	static MediaPlayer player2;
	@Override	
	public void start(Stage stage) throws Exception{
		currentStage=stage;
		Parent root=FXMLLoader.load(getClass().getResource("fp2.fxml"));
		menuScene=new Scene(root);
		currentStage.setScene(menuScene);
		currentStage.setTitle("澳門線上賭場");
		currentStage.show();  
		
		
//		Parent root2=FXMLLoader.load(getClass().getResource("fp2.fxml"));
//		Scene scene2=new Scene(root2);
//		var stage2=new Stage();
//		stage2.setScene(scene2);
//		stage2.setTitle("遊戲規則");
//		stage2.show();

	}
	public static void main(String[] args) throws MalformedURLException {
		
//		try {
			player1 = new MediaPlayer(new Media(FileSystems.getDefault().getPath("src","fp","rule.mp3").toUri().toURL().toString()));
			player1.setCycleCount(-1);
			player1.play();
//		} catch (MalformedURLException e) {
			
//			e.printStackTrace();
//		}
		launch(args);
	}

}
