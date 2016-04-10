package ing.controller.responsable;

import java.util.List;

import ing.DAO.ImplAbsenceDAO;
import ing.entity.Absence;
import ing.model.ModelAbsenceForProf;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ResponsableController {
	
	@FXML
	private TextField CINText;
	
	@FXML
	private ComboBox<String> comboMatiere;
	
	@FXML
	private TableView<ModelAbsenceForProf> tblrespons;
	
	public void consulterabsence(){
		
		
		ImplAbsenceDAO daoAbsence=new ImplAbsenceDAO();
		
		List<Absence> l=daoAbsence.getAbsenceForResponsable(Integer.parseInt(CINText.getText()), comboMatiere.getValue().toString());
	
	
	
	
	}

}
