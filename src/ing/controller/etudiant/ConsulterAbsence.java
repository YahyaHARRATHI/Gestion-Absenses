package ing.controller.etudiant;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ing.DAO.ImplAbsenceDAO;
import ing.DAO.ImplMatiere;
import ing.controller.ModelAffichageAbs;
import ing.entity.Absence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class ConsulterAbsence {

	@FXML
	private ChoiceBox<String> matiere;
	@FXML
	private Long userId;

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
		
		if(abs!=null){
		int i=0;
		for (Absence absence : abs) {
			//System.out.println(absence.getDate());
			ModelAffichageAbs model = new ModelAffichageAbs();
			model.setDate(absence.getDate().toString());
			i++;
			model.setNum(""+i+"");

			data.add(model);

		}
		tableabs.setItems(data);
		tableabs.setVisible(true);
		}
		
		else{
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
}
