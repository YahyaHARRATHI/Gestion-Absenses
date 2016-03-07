package ing.controller;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AuthController {
	@FXML private Button Conectbutton;
	@FXML
public void connect(){
	try {
		
		Stage stage1=(Stage) Conectbutton.getScene().getWindow();
		stage1.close();
		Parent root=FXMLLoader.load(getClass().getResource("/ing/view/AcuueilE.fxml"));
		Scene scene = new Scene(root);
		
		Stage stage=new Stage();
		stage.setScene(scene);
		
		stage.show();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
