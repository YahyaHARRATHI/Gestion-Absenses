package ing.controller;

import java.io.IOException;

import ing.DAO.ImplAbsenceDAO;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;

public class ConsulterAbsence {

	@FXML
	private ChoiceBox<String> matiere;
	@FXML
	private long user_id;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public void ConsulterAbs() throws IOException {

		ImplAbsenceDAO a = new ImplAbsenceDAO();
	}
}
