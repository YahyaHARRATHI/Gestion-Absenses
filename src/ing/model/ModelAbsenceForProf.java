package ing.model;

import javafx.beans.property.SimpleStringProperty;

public class ModelAbsenceForProf {

	private final SimpleStringProperty num = new SimpleStringProperty("");
	private final SimpleStringProperty nom = new SimpleStringProperty("");
	private final SimpleStringProperty prenom = new SimpleStringProperty("");
	private final SimpleStringProperty absences = new SimpleStringProperty("");

	public String getNum() {
		return num.get();
	}

	public String getNom() {
		return nom.get();
	}

	public String getPrenom() {
		return prenom.get();
	}

	public String getAbsences() {
		return absences.get();
	}

	public ModelAbsenceForProf() {
		this("", "", "", "");
	}

	public ModelAbsenceForProf(String nu, String no, String p, String abs) {
		num.set(nu);
		nom.set(no);
		prenom.set(p);
		absences.set(abs);

	}

}
