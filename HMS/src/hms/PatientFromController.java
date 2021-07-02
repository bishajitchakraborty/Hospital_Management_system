
package hms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class PatientFromController implements Initializable {
    
    @FXML
    private TextField patientid;
    @FXML
    private TextField patientname;

    @FXML
    private TextField fathername;

    @FXML
    private TextField gender;

    @FXML
    private TextField age;

    @FXML
    private TextField phonenumber;
    @FXML
    private DatePicker dathofbirth;
    @FXML
    private TextArea Dieasehistory;

    @FXML
    private TextArea Discription;
    
    @FXML
    private ComboBox<String> combobox;
    
  ObservableList<String>accounts= FXCollections.observableArrayList();
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
   
    public void autoin(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            Statement s=con.createStatement();
            rs=s.executeQuery("Select Max(ID) from patient_info");
            rs.next();
            rs.getString("Max(ID)");
            if(rs.getString("Max(ID)")==null){
               patientid.setText("PN001"); 
            }
            else
            {
              
                Long pid=Long.parseLong(rs.getString("Max(ID)").substring(2,rs.getString("Max(ID)").length()));
                pid++;
                patientid.setText("PN"+String.format("%03d",pid));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientFromController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PatientFromController.class.getName()).log(Level.SEVERE, null, ex);
        } 
 }   
    
    
    @FXML
    void handlesaveAction(ActionEvent event){
       String id=patientid.getText();
       String name=patientname.getText();
       String fname=fathername.getText();
       String gen=gender.getText();
       String Age=age.getText();
       String pnum=phonenumber.getText();
       String db=dathofbirth.getPromptText();
       String adv=combobox.getValue();
       String die=Dieasehistory.getText();
       String dis=Discription.getText();
       
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            String sql="Insert into patient_info values(?,?,?,?,?,?,?,?,?,?)";
             pst=con.prepareStatement(sql);
             pst.setString(1,id);
             pst.setString(2,name );
             pst.setString(3,fname );
             pst.setString(4,gen );
             pst.setString(5,Age );
             pst.setString(6,pnum );
             LocalDate bdate=dathofbirth.getValue();
             String date=String.valueOf(bdate);
             pst.setString(7, date);
             pst.setString(8,adv);
             pst.setString(9, die);
             pst.setString(10,dis );
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Patient Admision Successfully");
            
            patientid.setText("");
            patientname.setText("");
            fathername.setText("");
            gender.setText("");
            age.setText("");
            phonenumber.setText("");
            Dieasehistory.setText("");
            Discription.setText("");
           
       }catch(Exception e){
           
       }
    }
    
   @FXML
    void handlehomepageAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("Reception.fxml"));
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        autoin();
        combobox();
    }   
    
    
    public void combobox(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            String sql="select Name from doctor_infor"; 
             pst=con.prepareStatement(sql);
             rs=pst.executeQuery();
             while(rs.next()){
               accounts.add(rs.getString("Name"));
               combobox.setItems(accounts);
             }
             pst.close();
             rs.close();
            
        
    }catch(Exception e){
        
     }
  }
  
 
   

}

