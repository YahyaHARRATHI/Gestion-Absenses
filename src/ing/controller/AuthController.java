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

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AuthController {

	@FXML
	private Button Conectbutton;
	@FXML
	private TextField txtIdent;
	@FXML
	private TextField txtfield;

	@FXML
	private Label lblerreur;
	@FXML
	private ComboBox<String> profileCombo;

	public TextField getTxtIdent() {
		return txtIdent;
	}

	public TextField getPassfield() {
		return txtfield;
	}

	public void connect() {

		try {
			// System.out.println(profileCombo.getValue());

			// if profileCombo.getValue().equals(Etudiant) then search etudiant
			// table
			ImplEtudiantDAO e = new ImplEtudiantDAO();
			Long test = e.connecter(txtIdent.getText(), txtfield.getText());
			if (test!= null) {
				Stage stage1 = (Stage) Conectbutton.getScene().getWindow();


				FXMLLoader loader = new FXMLLoader(getClass().getResource("/ing/view/AcuueilE.fxml"));

				Pane pane = (Pane) loader.load();

				ConsulterAbsence controller = loader.<ConsulterAbsence> getController();

				controller.setUser_id((test));
				
				Scene scene = new Scene(pane);
				// on peut faire new stage

				stage1.setScene(scene);
				stage1.show();
			} else {

				lblerreur.setText("khfjh");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
