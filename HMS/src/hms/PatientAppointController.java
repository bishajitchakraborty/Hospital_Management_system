
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class PatientAppointController implements Initializable {
    @FXML
    private TextField sernum;

    @FXML
    private TextField Name;

    @FXML
    private TextField fees;

    @FXML
    private DatePicker date;
    
    @FXML
    private ComboBox<String> combobox;

     ObservableList<String>accounts= FXCollections.observableArrayList();
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
 
    
  public void autoincrement(){
      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            Statement s=con.createStatement();
            rs=s.executeQuery("select Max(SN) from appointmentpatient");
            rs.next();
            rs.getString("Max(SN)");
            if(rs.getString("Max(SN)")==null){
               sernum.setText("SE001");
            } 
            else
            {
                Long id=Long.parseLong(rs.getString("Max()").substring(2,rs.getString("Max(SN)").length()));
                id++;
                sernum.setText("SE"+String.format("%03d",id));
            
            }
            
            
      }catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientAppointController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PatientAppointController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    @FXML
    void handlesaveAction(ActionEvent event){
       String doctorname=combobox.getValue();
       String sename=sernum.getText();
       String name=Name.getText();
       String fee=fees.getText();
       String db=date.getPromptText();
       try{
           Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            String sql="Insert into appointmentpatient values(?,?,?,?,?)";
             pst=con.prepareStatement(sql);
             pst.setString(1,doctorname);
             pst.setString(2,sename );
             pst.setString(3,name );
             pst.setString(4,fee );
             LocalDate bdate=date.getValue();
             String date=String.valueOf(bdate);
             pst.setString(5, date);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"Appointment Successful");
            
           sernum.setText("");
           Name.setText("");
           fees.setText("");
            
       }catch(Exception e){
           
       }
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         autoincrement();
         combobox();
       
       
    }   
    
    
    @FXML
    public void handlecloseAction(ActionEvent event) throws IOException{
        Parent obj = FXMLLoader.load(getClass().getResource("Reception.fxml"));
                Scene scene = new Scene(obj);
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();
    }
    
}
