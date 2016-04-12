package ing.model;

import javafx.beans.property.SimpleStringProperty;

public class ModelAbsenceForProf {

	private final SimpleStringProperty num = new SimpleStringProperty("");
	private final SimpleStringProperty nom = new SimpleStringProperty("");
	private final SimpleStringProperty prenom = new SimpleStringProperty("");
	private final SimpleStringProperty absences = new SimpleStringProperty("");

	public ModelAbsenceForProf() {
		this("", "", "", "");
	}
	
	public ModelAbsenceForProf(String x, String y, String z, String w) {
		setNum(x);
		setNom(y);
		setPrenom(z);
		setAbsences(w);

	}
	
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

	

	public void setNum(String n) {
		this.num.set(n);
	}

	public void setNom(String n) {
		this.nom.set(n);
	}

	public void setPrenom(String n) {
		this.prenom.set(n);
	}

	public void setAbsences(String n) {
		this.absences.set(n);
	}
	




}
