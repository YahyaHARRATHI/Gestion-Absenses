package ing.controller.professeur;



import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import ing.entity.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class Enseignant implements Initializable{
	
	
	@FXML
	private Long userId;
	
	@FXML
	Label label1;
	@FXML
	DatePicker date;
	@FXML
	private ComboBox<String> combobox1;
	@FXML
	private ComboBox<String> combobox2;
	@FXML
	private TableView <Absencea> t1;
	@FXML
	private TableView <Absencea> t2;
	@FXML
	private TableColumn<Absencea,String> cin;
	@FXML
	private TableColumn<Absencea,String> nom;
	@FXML
	private TableColumn<Absencea,String> prenom;
	@FXML
	private TableColumn<Absencea,String> nb_abs;
	//************ TableView2*************************
	@FXML
	private TableColumn<Absencea,String> nom2;
	@FXML
	private TableColumn<Absencea,String> prenom2;
	@FXML
	private TableColumn<Absencea,String> cin2;
	@FXML
	private TableColumn<Absencea, Boolean> cb;

	
	private Session1 session=new Session1();
	private ResultSet rs = null;
	private Connection conn = null;
	private Statement stmt = null;
	
	
	ObservableList<String> liste1;
	ObservableList<Absencea> liste;
	ObservableList<Absencea> liste2;
	private int insert;
	private String module;
	

	
	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String connectionUrl = "jdbc:mysql://localhost/gestionabsence";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			date.setValue(LocalDate.now());
				
				rs = stmt.executeQuery("select DISTINCT g.niveau AS groupe"
						+ " FROM enseigne n,groupe g "
						+ "WHERE n.id_ens='"+session.getNum()+"'"
						+ " AND g.id_groupe=n.id_groupe ");
				if(rs.next())
					liste1=(ObservableList<String>) FXCollections.observableArrayList(rs.getString("groupe"));
					
					while(rs.next())
					{
						liste1.add(rs.getString("groupe"));
					}
				
						
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		combobox1.setItems(liste1);
		
		
		
		
	}
	
	
	public void lister_matiere()
	{
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String connectionUrl = "jdbc:mysql://localhost/gestion_Absenceaa";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			
				
			rs = stmt.executeQuery("select DISTINCT m.nom AS matiere"
					+ " FROM enseigne n,groupe g, module m "
					+ "WHERE n.id_ens='"+session.getNum()+"'"
					+ " AND g.id_groupe=n.id_groupe "
					+ "AND n.id_module=m.id_module"
					+" AND g.niveau='"+combobox1.getValue()+"'"
					);
			
			if(rs.next())
			liste1=(ObservableList<String>) FXCollections.observableArrayList(rs.getString("matiere"));
			
			while(rs.next())
			{
				liste1.add(rs.getString("matiere"));
			}
				
						
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		combobox2.setItems(liste1);
		
		
		
		
		
	}
	
	
	
	
	
	public void lister_Absencea()
	{
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String connectionUrl = "jdbc:mysql://localhost/gestion_Absenceaa";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			
				
			rs = stmt.executeQuery("SELECT COUNT(a.id_etudiant) as nb ,e.nom AS nom_e, e.prenom AS prenom_e, e.CIN AS cin"
					+ " FROM Absencea a,etudiant e, groupe g, module m "
					+ "WHERE e.id_groupe=g.id_groupe "
					+"AND g.niveau='"+combobox1.getValue()+"'"
					+ " AND a.id_etudiant=e.id_etudiant "
					+ "AND a.id_module=m.id_module "
					+"AND m.nom='"+combobox2.getValue()+"'"
					+" GROUP BY a.id_etudiant"
					);
			
			if (rs.next()==false)
			{liste=null;
			}
		else 
		{	
			
			liste =(ObservableList<Absencea>) FXCollections.observableArrayList(
					new Absencea(rs.getString("cin"),rs.getString("nom_e"),rs.getString("prenom_e"),rs.getString("nb"))	
					);
		}
			while(rs.next())
			{
				liste.add(new Absencea(rs.getString("cin"),rs.getString("nom_e"),rs.getString("prenom_e"),rs.getString("nb")));
			}
			
			
			rs = stmt.executeQuery("SELECT e.id_etudiant as id_etudiant,e.CIN as cin,e.nom as nom, e.prenom as prenom"
					+ " FROM etudiant e, groupe g "
					+ "WHERE g.id_groupe=e.id_groupe "
					+"AND g.niveau='"+combobox1.getValue()+"'"
					);
			
			if(rs.next())
				liste2=(ObservableList<Absencea>) FXCollections.observableArrayList(new Absencea(rs.getString("id_etudiant"),rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),false));
				
				while(rs.next())
				{
					liste2.add(new Absencea(rs.getString("id_etudiant"),rs.getString("cin"),rs.getString("nom"),rs.getString("prenom"),false));
				}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		cin.setCellValueFactory(new PropertyValueFactory<Absencea,String>("cin"));
		nom.setCellValueFactory(new PropertyValueFactory<Absencea,String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Absencea,String>("prenom"));
		
		cin2.setCellValueFactory(new PropertyValueFactory<Absencea,String>("cin"));
		nom2.setCellValueFactory(new PropertyValueFactory<Absencea,String>("nom"));
		prenom2.setCellValueFactory(new PropertyValueFactory<Absencea,String>("prenom"));
		nb_abs.setCellValueFactory(new PropertyValueFactory<Absencea,String>("nb_abs"));
	     //cb.setCellValueFactory(new PropertyValueFactory<Absenceaa, Boolean>("cb"));
	     
	     
		cb.setCellFactory(CheckBoxTableCell.forTableColumn(new Callback<Integer, ObservableValue<Boolean>>() {
			@Override
			public ObservableValue<Boolean> call(Integer param) {
				return t2.getItems().get(param).getCocher();
			}
		}));

		
			t2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Absencea>() {
				
				public void changed(ObservableValue<? extends Absencea> arg0, Absencea arg1, Absencea arg2) {
					//arg2.setCb(true);
				}
			});
		
		t1.setItems(liste);
		t2.setItems(liste2);
		t2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		
	}
	

	public void noter_Absenceaa()
	{
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String connectionUrl = "jdbc:mysql://localhost/gestion_Absenceaa";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			
			
			
			rs = stmt.executeQuery("SELECT id_module FROM module WHERE nom='"+combobox2.getValue()+"'"
					);
			rs.next();
			module = rs.getString("id_module");
			
			
			
			 for (Absencea p : t2.getItems()) {
				 
				 
				 if(p.getCocher().get()==true)
	            
				insert = stmt.executeUpdate("INSERT INTO Absenceaa VALUES("
						+ "NULL,"+p.getId_etudiant()+","+session.getNum()+",0,"+module+",'"+date.getValue()+"')"
							
						);
				 
				 
				 System.out.println("INSERT INTO Absenceaa VALUES("
							+ "NULL,"+p.getId_etudiant()+","+session.getNum()+",0,"+1+",'"+date.getValue()+"')"+p.getCocher());
				 
	             
			 }
				
						
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		
		
		
		lister_Absencea();
		
		
		
		
		
	

		
		
		
	}
	
	public void getId(String nom,String prenom)
	{
		label1.setText(nom+" "+prenom);
		
		
		
	
	}

	
	/*
	//CheckBoxTableCell for creating a CheckBox in a table cell
	public static class CheckBoxTableCell<S, T> extends TableCell<S, T> {
	    private final CheckBox checkBox;
	    private ObservableValue<T> ov;
	    @FXML
		private TableView <Absenceaa> t2;

	    public CheckBoxTableCell() {
	        this.checkBox = new CheckBox();
	        this.checkBox.setAlignment(Pos.CENTER);

	        setAlignment(Pos.CENTER);
	        setGraphic(checkBox);

	    } 

	    @Override public void updateItem(T item, boolean empty) {
	        super.updateItem(item, empty);
	        if (empty) {
	            setText(null);
	            setGraphic(null);
	        } else {
	            setGraphic(checkBox);
	            if (ov instanceof BooleanProperty) {
	                checkBox.selectedProperty().unbindBidirectional((BooleanProperty) ov);
	            }
	            ov = getTableColumn().getCellObservableValue(getIndex());
	            if (ov instanceof BooleanProperty) {
	                checkBox.selectedProperty().bindBidirectional((BooleanProperty) ov);
	            }
	        }
	    }
	}

*/
	
}



