package ing.model;

public class MailClass {

	private String mail;
	private String matiere;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public MailClass(String mail, String matiere) {
		super();
		this.mail = mail;
		this.matiere = matiere;
	}
	
	
	
}
