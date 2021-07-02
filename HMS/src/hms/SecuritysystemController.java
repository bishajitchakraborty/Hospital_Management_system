
package hms;

import static hms.PatientrecordController.temp;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SecuritysystemController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField pass;

    @FXML
    private TextField compass;

    @FXML
    private TextField type;

    @FXML
    private TextField gender;

    @FXML
    private TextField age;

    @FXML
    private TextField pnum;

    @FXML
    private TableView<securitysystem> tableview;

    @FXML
    private TableColumn<securitysystem,String> col_name;

    @FXML
    private TableColumn<securitysystem,String> col_pass;

    @FXML
    private TableColumn<securitysystem,String> com_pass;

    @FXML
    private TableColumn<securitysystem,String> col_type;

    @FXML
    private TableColumn<securitysystem,String> col_gen;

    @FXML
    private TableColumn<securitysystem,String> col_age;

    @FXML
    private TableColumn<securitysystem,String> col_pnum;
   ObservableList<securitysystem>accounts= FXCollections.observableArrayList();
   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_name.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
        com_pass.setCellValueFactory(new PropertyValueFactory<>("confarmpassword"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("usertype"));
        col_gen.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_pnum.setCellValueFactory(new PropertyValueFactory<>("phone_num"));
        
        showrecord();
       
    }    
    
     public void showrecord(){
        try{
           con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
          rs=con.createStatement().executeQuery("select * from signup");
          while(rs.next()){
              accounts.add(new securitysystem(rs.getString("username"),rs.getString("password"),rs.getString("confarmpassword"),
                     rs.getString("usertype"),rs.getString("gender"),rs.getString("age"),rs.getString("phonenumber")));
               tableview.setItems(accounts);
          }
          pst.close();
       }catch(Exception e){
           
       }
   }
     
     public void showdataclick(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            securitysystem securitysystem = tableview.getSelectionModel().getSelectedItem();
            String sql="select * from signup ";
               pst=con.prepareStatement(sql);
               temp=securitysystem.getUsername();
               name.setText(securitysystem.getUsername());
               pass.setText(securitysystem.getPassword());
               compass.setText(securitysystem.getConfarmpassword());
               type.setText(securitysystem.getUsertype());
               gender.setText(securitysystem.getGender());
                age.setText(securitysystem.getAge()); 
               pnum.setText(securitysystem.getPhone_num());
               
               pst.close();
               rs.close();
        }catch(Exception e){
            
        }
       
    }
     
   @FXML
   public void handleeditAction(ActionEvent event){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           String sql="Update  signup set username=?,password=?,confarmpassword=?,usertype=?,gender=?,age=?,phonenumber=? where usernumber='"+temp+"'";
           pst=con.prepareStatement(sql);
           
            pst.setString(1,name.getText());
            pst.setString(2, pass.getText());
            pst.setString(3, compass.getText());
            pst.setString(4,type.getText());
            pst.setString(5,gender.getText());
            pst.setString(6,age.getText());
            pst.setString(7,pnum.getText());
            pst.executeUpdate();
            accounts.clear();
            showrecord();
            JOptionPane.showMessageDialog(null,"Updated Successfully");
           
             
            
        }catch(Exception e){
            
        }  
   }
   
   @FXML
   public void handledeleteAction(ActionEvent event){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           
            securitysystem securitysystem = tableview.getSelectionModel().getSelectedItem();
            String sql="Delete from signup where username=? ";
            
           
              pst=con.prepareStatement(sql);
              pst.setString(1, securitysystem.getUsername());
              pst.executeUpdate();
              pst.close();
              rs.close();
              accounts.clear();
              showrecord();
              JOptionPane.showMessageDialog(null,"Delete Successfully");
              name.setText("");
              pass.setText("");
              compass.setText("");
              type.setText("");
              gender.setText("");
              age.setText("");
              pnum.setText("");
        }catch(Exception e){
            
        }
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
