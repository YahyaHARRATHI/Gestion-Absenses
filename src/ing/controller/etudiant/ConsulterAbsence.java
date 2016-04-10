package ing.controller.etudiant;

import java.io.IOException;

import java.util.List;

import ing.DAO.ImplAbsenceDAO;
import ing.DAO.ImplMatiere;
import ing.model.ModelAffichageAbs;
import ing.entity.Absence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConsulterAbsence {

	@FXML
	private ChoiceBox<String> matiere;
	@FXML
	private Long userId;
	@FXML
	private Button btnConsulter;

	@FXML
	private Label lblAbsence;
	@FXML
	private TableView<ModelAffichageAbs> tableabs;
	@FXML
	private TableColumn<ModelAffichageAbs, java.util.Date> date;
	@FXML
	private TableColumn<ModelAffichageAbs, Integer> num;

	// j'ai fait tous les getters and setters

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void ConsulterAbs() throws IOException {

		ImplAbsenceDAO a = new ImplAbsenceDAO();
		ImplMatiere m = new ImplMatiere();

		String mat = matiere.getValue().toString();
		Long id_mat = m.getIdMatiere(mat);

		List<Absence> abs = a.listeAbsenceParMatiere(this.userId, id_mat);

		ObservableList<ModelAffichageAbs> data = FXCollections.observableArrayList();

		if (abs != null) {
			int i = 0;
			for (Absence absence : abs) {
				// System.out.println(absence.getDate());
				ModelAffichageAbs model = new ModelAffichageAbs();
				model.setDate(absence.getDate().toString());
				i++;
				model.setNum("" + i + "");

				data.add(model);

			}
			tableabs.setItems(data);
			tableabs.setVisible(true);
			lblAbsence.setVisible(false);

		}

		else {
			tableabs.setVisible(false);
			lblAbsence.setVisible(true);
		}
		// autre methode abs.iterator
		/*
		 * while (it.hasNext()) { Absence temp = (Absence) it.next();
		 * System.out.println("hghg"+temp.getDate());
		 * 
		 * }
		 */
	}

	public void quitterInterface() {
		
		Stage stage1 = (Stage) btnConsulter.getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ing/view/Authentification.fxml"));
		

		Pane pane = null;
		try {
			pane = (Pane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// on peut faire new stage
		stage1.close();
		Stage s=new Stage();
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.show();

	}
}
