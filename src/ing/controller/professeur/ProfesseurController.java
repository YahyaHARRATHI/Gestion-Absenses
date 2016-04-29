package ing.controller.professeur;

import java.io.IOException;
import java.util.List;

import ing.DAO.GroupeDAO;
import ing.DAO.ImplAbsenceDAO;
import ing.entity.Absence;
import ing.model.ModelAbsenceForProf;
import ing.model.ModelAffichageAbs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProfesseurController {
@FXML
private ChoiceBox<String> matierechoice ;

@FXML
private ChoiceBox<String> choicegroupe;
	@FXML
	private Button btnConsulter;
	@FXML
	private TableView<ModelAbsenceForProf> tbl;
	@FXML
	private ComboBox<String> comboMatiere;

	@FXML
	private ComboBox<String> comboGroupe;

	
	public Button getBtnConsulter() {
		return btnConsulter;
	}

	public void setBtnConsulter(Button btnConsulter) {
		this.btnConsulter = btnConsulter;
	}

	public TableView<ModelAbsenceForProf> getTbl() {
		return tbl;
	}

	public void setTbl(TableView<ModelAbsenceForProf> tbl) {
		this.tbl = tbl;
	}

	public ComboBox<String> getComboMatiere() {
		return comboMatiere;
	}

	public void setComboMatiere(ComboBox<String> comboMatiere) {
		this.comboMatiere = comboMatiere;
	}

	public ComboBox<String> getComboGroupe() {
		return comboGroupe;
	}

	public void setComboGroupe(ComboBox<String> comboGroupe) {
		this.comboGroupe = comboGroupe;
	}

	
	public void etudiants(){
		
		ImplAbsenceDAO dao = new ImplAbsenceDAO();
		GroupeDAO grpDao = new GroupeDAO();

		Long res = grpDao.getGroupe(choicegroupe.getValue().toString());
		ObservableList<ModelAbsenceForProf> data = FXCollections.observableArrayList();
		System.out.println("res " + res);
		List<Absence> l = dao.absencesByMatiereAndGroupe(matierechoice.getValue(), res);
		
		
		
		
	}
	
	
	
	
	
	public void listeAbsence() {

		ImplAbsenceDAO dao = new ImplAbsenceDAO();
		GroupeDAO grpDao = new GroupeDAO();

		Long res = grpDao.getGroupe(comboGroupe.getValue().toString());
		ObservableList<ModelAbsenceForProf> data = FXCollections.observableArrayList();
		
		List<Absence> l = dao.Etudiants(comboMatiere.getValue(), res);
		
		if (l.size() == 0) {
			System.out.println(" liste null ");
		} else {
			int i = 0;
			for (Absence absence : l) {

				i++;

				ModelAbsenceForProf m = new ModelAbsenceForProf("" + i + "", absence.getEtudiant().getNom(),
						absence.getEtudiant().getPrenom(), absence.getDate().toString(),absence.getId().toString());

				data.add(m);
			}

			if (data.size() == 0) {
				System.out.println("data empty");
			}
			System.out.println(data.get(1).getNom());

			

		}
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
		Stage s = new Stage();
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.show();

	}
}
