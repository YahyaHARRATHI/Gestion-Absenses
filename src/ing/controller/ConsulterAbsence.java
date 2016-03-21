package ing.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import ing.DAO.ImplAbsenceDAO;
import ing.DAO.ImplMatiere;
import ing.entity.Absence;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;

public class ConsulterAbsence {

	@FXML
	private ChoiceBox<String> matiere;
	@FXML
	private Long user_id;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void ConsulterAbs() throws IOException {
		
		ImplAbsenceDAO a = new ImplAbsenceDAO();
		ImplMatiere m=new ImplMatiere();
		
		String mat=matiere.getValue().toString();
		Long id_mat=m.getIdMatiere(mat);
		System.out.println(id_mat);

		
		List<Absence> abs=a.listeAbsenceParMatiere(this.user_id, id_mat);
		Iterator<Absence>  it=abs.iterator();
		while (it.hasNext()) {
			Absence temp = (Absence) it.next();
			System.out.println(temp.getDate());
			
		}
	}
}



