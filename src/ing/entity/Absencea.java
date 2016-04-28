package ing.entity;



import javafx.beans.property.SimpleBooleanProperty;

public class Absencea {
	
	private String id_etudiant;
	private String matiere;
	private String enseignant;
	private String date;
	private String cin;
	private String nom;
	private String prenom;
	private String nb_abs;	
	
	private SimpleBooleanProperty cb;
	
	public Absencea(String id_etudiant,String cin, String nom, String prenom, Boolean cb) {
		super();
		this.id_etudiant=id_etudiant;
		this.cin = cin;
		this.nom= nom;
		this.prenom = prenom;
		this.cb=new SimpleBooleanProperty(cb);
		
		
					
			
	}
	
	
	public Absencea(String id_etudiant,String cin, String nom, String prenom,String nb_abs,Boolean cb) {
		super();
		this.id_etudiant=id_etudiant;
		this.cin = cin;
		this.nom= nom;
		this.prenom = prenom;
		this.nb_abs = nb_abs;
		this.cb=new SimpleBooleanProperty(cb);
		
		
					
			
	}
	
	
		
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNb_abs() {
		return nb_abs;
	}
	public void setNb_abs(String nb_abs) {
		this.nb_abs = nb_abs;
	}

	public Absencea(String cin, String nom, String prenom, String nb_abs) {
		super();
		this.setCin(cin);
		this.nom = nom;
		this.prenom = prenom;
		this.nb_abs = nb_abs;
	}
	public Absencea(String matiere, String enseignant, String date) {
		super();
		this.matiere = matiere;
		this.enseignant = enseignant;
		this.date = date;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getId_etudiant() {
		return id_etudiant;
	}
	public void setId_etudiant(String id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	public SimpleBooleanProperty getCocher() {
		return cb;
	}

	public void setCocher(SimpleBooleanProperty cocher) {
			this.cb = cocher;
		}
	
	
       


    

             


	
	
	
	
	

}
