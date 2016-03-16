package ing.controller;

import java.io.IOException;


import ing.DAO.ImplEtudiantDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {
	@FXML private Button Conectbutton;
	@FXML private TextField txtIdent;
	@FXML private TextField txtfield;
	@FXML private SplitMenuButton profile;
	 @FXML private Label lblerreur;
	 @FXML
		private ComboBox<String> profileCombo;
	
	
public TextField getTxtIdent() {
		return txtIdent;
	}



	public TextField getPassfield() {
		return txtfield;
	}



public void connect(){
	try {
		System.out.println(profileCombo.getValue());
		
		//if profileCombo.getValue() == Etudiant then search etudiant table
		ImplEtudiantDAO e=new ImplEtudiantDAO();
		boolean test=e.connecter(txtIdent.getText(),txtfield.getText());
		if(test==true)
		{
		Stage stage1=(Stage) Conectbutton.getScene().getWindow();
		//System.out.println(passfield.);
		stage1.close();
		Parent root=FXMLLoader.load(getClass().getResource("/ing/view/AcuueilE.fxml"));
		Scene scene = new Scene(root);
		
		Stage stage=new Stage();
		stage.setScene(scene);
		
		stage.show();
		}
		else {
			
			
		lblerreur.setText("khfjh");
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
