package ing.controller;

import java.io.IOException;


import ing.DAO.ImplEtudiantDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {
	@FXML private Button Conectbutton;
	@FXML private TextField txtIdent;
	@FXML private PasswordField passfield;
	@FXML private SplitMenuButton profile;
	
	
	
public TextField getTxtIdent() {
		return txtIdent;
	}



	public PasswordField getPassfield() {
		return passfield;
	}



public void connect(){
	try {
		System.out.println("kjgjkh");
		ImplEtudiantDAO e=new ImplEtudiantDAO();
		e.connecter(txtIdent.getText(), "hg");
		Stage stage1=(Stage) Conectbutton.getScene().getWindow();
		//System.out.println(passfield.);
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
