package ing.model;

import javafx.beans.property.SimpleStringProperty;

public class ModelAffichageAbs {

	private final SimpleStringProperty num = new SimpleStringProperty("");
	private final SimpleStringProperty date = new SimpleStringProperty("");

	public ModelAffichageAbs() {
		this("", "");
	}

	
	public ModelAffichageAbs(String n, String d) {
		num.set(n);
		date.set(d);

	}

	public void setNum(String n) {
		this.num.set(n);
	}

	public void setDate(String d) {
		this.date.set(d);
	}

	public String getNum() {
		return num.get();
	}

	public String getDate() {
		return date.get();
	}

}
