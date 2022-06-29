package fp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Fp2 {

    @FXML
    private Button startbuttom;

    @FXML
    void pressstart(ActionEvent event) throws IOException{
    	Parent root=FXMLLoader.load(getClass().getResource("fp.fxml"));
		Scene scene=new Scene(root);
		scene.getRoot().requestFocus();
		FP.currentStage.setScene(scene);
		FP.player1.stop();
		FP.player2 = new MediaPlayer(new Media(FileSystems.getDefault().getPath("src","fp","game.mp3").toUri().toURL().toString()));
		FP.player2.setCycleCount(-1);
		FP.player2.play();
};
    
	
	

}
