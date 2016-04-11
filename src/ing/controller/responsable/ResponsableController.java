package ing.controller.responsable;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jboss.logging.MDC;

import ing.DAO.ImplAbsenceDAO;
import ing.entity.Absence;
import ing.model.MailClass;
import ing.model.ModelAbsenceForProf;
import ing.model.ModelAffichageAbs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResponsableController {
	
	@FXML
	private TextField CINText;
	
	@FXML
	private Button btnConsulter;
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
		List<MailClass> m=daoAbsence.listmail();
		
		Properties props = new Properties();
		

		 String SENDERS_EMAIL = "devteach10@gmail.com";
	     String SENDERS_PWD = "Pa$$w0rd2518251.";
	    
	    
	    
        // Set properties required to connect to Gmail's SMTP server
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "465 ");    
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true"); 
	    
	    
	    // Create a username-password authenticator to authenticate SMTP session
        Authenticator authenticator = new Authenticator() {
           //override the getPasswordAuthentication method
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(SENDERS_EMAIL, SENDERS_PWD);
           }
       };
	    
       // Create the mail session
       Session session = Session.getDefaultInstance(props, authenticator);
       try{
           // Create a default MimeMessage object.
           final MimeMessage message = new MimeMessage(session);
           
           // Set the sender's email address
           message.setFrom(new InternetAddress(SENDERS_EMAIL));
           
           // Set recipient's email address
           
           for (MailClass mailClass : m) {
			
		
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailClass.getMail()));
           
           // Set the subject of the email
           message.setSubject("Hello!");
           
           // Now set the actual message body of the email
           message.setText("you are eliminated in this subject :  "+mailClass.getMatiere());
           
           System.out.println("Sending email...");
           
           // Send message
           Transport.send(message);
           
           System.out.println("Email sent!");
           
           }
           
       }catch(Exception e){
           System.err.println("Problem sending email. Exception : " + e.getMessage());
       }
       
	}
	
	
	
	public void quitterInterface() {

		Stage stage1 = (Stage) btnConsulter.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ing/view/Authentification.fxml"));

		Pane pane = null;
		try {
			pane = (Pane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// on peut faire new stage
		
		
		Scene scene = new Scene(pane);
		stage1.setScene(scene);
		stage1.show();

	}

}
