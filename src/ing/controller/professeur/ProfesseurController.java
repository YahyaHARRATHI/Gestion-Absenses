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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProfesseurController {

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

	public void listeAbsence() {

		ImplAbsenceDAO dao = new ImplAbsenceDAO();
		GroupeDAO grpDao = new GroupeDAO();

		Long res = grpDao.getGroupe(comboGroupe.getValue().toString());
		ObservableList<ModelAbsenceForProf> data = FXCollections.observableArrayList();
		System.out.println("res " + res);
		List<Absence> l = dao.absencesByMatiereAndGroupe(comboMatiere.getValue(), res);
		if (l == null) {
			System.out.println(" liste l dan le controlleur nuuuuuul");

		}

		else {
			
			ModelAbsenceForProf model = null;
			Long idTest = 0L;
			int i = 0;

			for (Absence absence : l) {

				System.out.println("nom = " + absence.getEtudiant().getNom() + "prenom "
						+ absence.getEtudiant().getPrenom() + " date " + absence.getDate());

				if (absence.getEtudiant().getId() == idTest) {
					model.concatabs((absence.getDate().toString()));
					System.out.println("absences concat " + model.getAbsences());

				} else {
					// pour la premiere insertion
					if (model != null)
						data.add(model);
					model = new ModelAbsenceForProf();
					model.setNom(absence.getEtudiant().getNom());
					System.out.println(absence.getEtudiant().getNom());
					model.setPrenom(absence.getEtudiant().getPrenom());
					System.out.println(absence.getEtudiant().getPrenom());
					i++;
					model.setNum(""+i+"");
					model.setAbsences(absence.getDate().toString());
					idTest = absence.getEtudiant().getId();
				}

			}

			if (model != null) {
				data.add(model);
				System.out.println(model.getAbsences()+"   "+model.getNom()+" "+model.getNum());
				
				tbl.setItems(data);
				tbl.setVisible(true);
				// tableabs.setVisible(true);

			} else
				System.out.println("model still empty man ");

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
