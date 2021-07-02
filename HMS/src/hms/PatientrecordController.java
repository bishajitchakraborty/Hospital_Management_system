
package hms;

import static hms.AdddoctorController.temp;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class PatientrecordController implements Initializable {
    @FXML
    private TextField patientid;

    @FXML
    private TextField patientname;

    @FXML
    private TextField fathername;
    @FXML
    private TextField gen;

    @FXML
    private TextField Age;
    @FXML
    private TextField phonenumber;

    @FXML
    private TextField dathofbirth;

    @FXML
    private TextArea Dieasehistory;

    @FXML
    private TextArea Discription;
    
    @FXML
    private TextField Advisor;
    
    @FXML
    private TableView<patientrecord> tableview;

    @FXML
    private TableColumn<patientrecord,String> id;

    @FXML
    private TableColumn<patientrecord,String> name;

    @FXML
    private TableColumn<patientrecord,String> fname;

    @FXML
    private TableColumn<patientrecord,String> gender;

    @FXML
    private TableColumn<patientrecord,String> age;

    @FXML
    private TableColumn<patientrecord,String> pnum;

    @FXML
    private TableColumn<patientrecord,String> db;

    @FXML
    private TableColumn<patientrecord,String> advisor;

    @FXML
    private TableColumn<patientrecord,String> die;

    @FXML
    private TableColumn<patientrecord,String> dis;
    
    ObservableList<patientrecord>accounts= FXCollections.observableArrayList();
  
  
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        pnum.setCellValueFactory(new PropertyValueFactory<>("pnum"));
        db.setCellValueFactory(new PropertyValueFactory<>("db"));
        advisor.setCellValueFactory(new PropertyValueFactory<>("advisor"));
        die.setCellValueFactory(new PropertyValueFactory<>("die"));
        dis.setCellValueFactory(new PropertyValueFactory<>("dis"));
        showrecord();
        
    }  
    
    
    
    public void showrecord(){
        try{
           Connection  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
          rs=con.createStatement().executeQuery("select * from patient_info");
          while(rs.next()){
              accounts.add(new patientrecord(rs.getString("ID"),rs.getString("patientname"),rs.getString("fathername"),
                     rs.getString("gender"),rs.getString("age"),rs.getString("phonenumber"),rs.getString("dathofbirth"),
                     rs.getString("advisor"),rs.getString("diseasehistory"),rs.getString("discription")));
               tableview.setItems(accounts);
          }
          pst.close();
       }catch(Exception e){
           
       }
   }
    
  
    @FXML
    void handlecloseAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("Reception.fxml"));
        
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
    
    @FXML
    void handledeleteAction(ActionEvent event){      
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           
            patientrecord patientrecord = tableview.getSelectionModel().getSelectedItem();
            String sql="Delete from patient_info where ID=? ";
            
           
              pst=con.prepareStatement(sql);
              pst.setString(1, patientrecord.getId());
              pst.executeUpdate();
              pst.close();
              rs.close();
              accounts.clear();
              showrecord();
              JOptionPane.showMessageDialog(null,"Delete Successfully");
              id.setText("");
              name.setText("");
              fname.setText("");
              gender.setText("");
              age.setText("");
              pnum.setText("");
              db.setText("");
              advisor.setText("");
              die.setText("");
              dis.setText("");
            
          
        }catch(Exception e){
            
        }
    }
    @FXML
    public void handleeditAction(ActionEvent event){
        
    }
      static String temp;
    
    public void showdataclick(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            patientrecord patientrecord = tableview.getSelectionModel().getSelectedItem();
            String sql="select * from patient_info ";
               pst=con.prepareStatement(sql);
               temp=patientrecord.getId();
               patientid.setText(patientrecord.getId());
               patientname.setText(patientrecord.getName());
               fathername.setText(patientrecord.getFname());
               gen.setText(patientrecord.getGender());
               Age.setText(patientrecord.getAge());
               phonenumber.setText(patientrecord.getPnum());
               dathofbirth.setText(patientrecord.getDb());
               Advisor.setText(patientrecord.getAdvisor());
               Dieasehistory.setText(patientrecord.getDie());
               Discription.setText(patientrecord.getDis());
               
               pst.close();
               rs.close();
        }catch(Exception e){
            
        }
       
    }
    
    
     @FXML
    void handleupdateAction(ActionEvent event){
     
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           String sql="Update  patient_info set ID=?,patientname=?,fathername=?,gender=?,age=?,phonenumber=?,dathofbirth=?,advisor=?,diseasehistory=?,discription=? where ID='"+temp+"'";
           pst=con.prepareStatement(sql);
           
            pst.setString(1,patientid.getText() );
            pst.setString(2, patientname.getText());
            pst.setString(3, fathername.getText());
            pst.setString(4,gen.getText());
            pst.setString(5,Age.getText());
            pst.setString(6,pnum.getText());
            pst.setString(7,db.getText());
            pst.setString(8,Advisor.getText());
            pst.setString(9,die.getText());
            pst.setString(10,dis.getText());
            pst.executeUpdate();
            accounts.clear();
            showrecord();
            JOptionPane.showMessageDialog(null,"Updated Successfully");
           
             
            
        }catch(Exception e){
            
        }  
    }
    
    
}
