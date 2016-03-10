package ing.controller;



import java.io.IOException;

import ing.DAO.ImplAbsenceDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;



public class ConsulterAbsence {
	

	public void ConsulterAbs() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader();
	        Scene scene = (Scene)FXMLLoader.load(getClass().getResource("/ing/view/Authentification.fxml"));
	        
		AuthController c = (AuthController) fxmlLoader.getController();
	
	if(c.getTxtIdent().getText().isEmpty())
		System.out.println("chbiiiiiiiik");
		else 
			System.out.println(c.getTxtIdent().getText());
		ImplAbsenceDAO a=new ImplAbsenceDAO();
	}
}
