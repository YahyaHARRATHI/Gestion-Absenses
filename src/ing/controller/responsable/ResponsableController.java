package ing.controller.responsable;

import java.io.IOException;
import java.util.List;

import org.jboss.logging.MDC;

import ing.DAO.ImplAbsenceDAO;
import ing.entity.Absence;
import ing.model.ModelAbsenceForProf;
import ing.model.ModelAffichageAbs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResponsableController {
	
	@FXML
	private TextField CINText;
	
	@FXML
	private ComboBox<String> comboMatiere;
	
	@FXML
	private TableView<ModelAbsenceForProf> tblrespons;
	
	public void consulterabsence(){
		
		
		ImplAbsenceDAO daoAbsence=new ImplAbsenceDAO();
		
		
		ObservableList<ModelAbsenceForProf> data = FXCollections.observableArrayList();
		Integer in=Integer.parseInt(CINText.getText());
		List<Absence> l=daoAbsence.getAbsenceForResponsable(in, comboMatiere.getValue());
	
		if(l.size()==0){
			System.out.println(" liste null ");
		}
		else {
			int i=0;
		for (Absence absence : l) {
			
			i++;
			
			
			ModelAbsenceForProf m=new ModelAbsenceForProf(""+i+"", 
					absence.getEtudiant().getNom(),
					absence.getEtudiant().getPrenom(), absence.getDate().toString());
			
			data.add(m);
		}
		
		
		
		if(data.size()==0){
			System.out.println("data empty");
		}
		System.out.println(data.get(1).getNom());
		tblrespons.setItems(data);
		
		
	
		}
		
	}
	
	
	public void envoyerMail(){ 
		
		ImplAbsenceDAO daoAbsence=new ImplAbsenceDAO();
		daoAbsence.listmail();
		
		
	}
	
	
	
	public void quitterInterface() {

		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ing/view/Authentification.fxml"));

		Pane pane = null;
		try {
			pane = (Pane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// on peut faire new stage
		
		Stage s = new Stage();
		Scene scene = new Scene(pane);
		s.setScene(scene);
		s.show();

	}

}
