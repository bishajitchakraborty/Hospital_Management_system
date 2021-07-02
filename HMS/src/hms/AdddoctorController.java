
package hms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.Specialization;

public class AdddoctorController implements Initializable {

    @FXML
    private TextField d_spe;

    @FXML
    private TextField lo_no;

    @FXML
    private TextField d_name;

    @FXML
    private TextField D_ua;

    @FXML
    private TextField d_room_no;

    @FXML
    private TableView<adddoctor> tableview;

    @FXML
    private TableColumn<adddoctor, String> id_no;

    @FXML
    private TableColumn<adddoctor, String> name;

    @FXML
    private TableColumn<adddoctor, String> spe;

    @FXML
    private TableColumn<adddoctor, String> qua;

    @FXML
    private TableColumn<adddoctor, String> room;

    ObservableList<adddoctor>accounts= FXCollections.observableArrayList();
  
   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
   public void auto(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            Statement s=con.createStatement();
            rs=s.executeQuery("select Max(License_No) from doctor_infor");
            rs.next();
            rs.getString("Max(License_No)");
            if(rs.getString("Max(License_No)")==null){
               lo_no.setText("LN0001"); 
            }
            else
            {
                Long id=Long.parseLong(rs.getString("Max(License_No)").substring(2,rs.getString("Max(License_No)").length()));
                id++;
                lo_no.setText("LN0"+String.format("%03d",id));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdddoctorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdddoctorController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    @FXML
    void handlesaveAction(ActionEvent event){
        String id=lo_no.getText();
        String Name=d_name.getText();
        String Spe=d_spe.getText();
        String Qua=D_ua.getText();
        String Room=d_room_no.getText();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
          Connection  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            String sql="Insert into doctor_infor values(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, Name);
            pst.setString(3, Spe);
            pst.setString(4, Qua);
            pst.setString(5, Room);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"New Doctor Added Successfully");
            accounts.clear();
            loaddata();
            
            lo_no.setText("");
            d_name.setText("");
            d_spe.setText("");
            D_ua.setText("");
            d_room_no.setText("");
            
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        id_no.setCellValueFactory(new PropertyValueFactory<>("license_No"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        spe.setCellValueFactory(new PropertyValueFactory<>("specilization"));
        qua.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        room.setCellValueFactory(new PropertyValueFactory<>("room_no"));
        loaddata();
          auto();
       
    }    
    
    
    public void loaddata(){
         try{
           Connection  con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
          rs=con.createStatement().executeQuery("select * from doctor_infor");
          while(rs.next()){
              accounts.add(new adddoctor(rs.getString("License_No"),
                      rs.getString("Name"),rs.getString("specialization"),
                      rs.getString("qualification"),rs.getString("room_no")));
                tableview.setItems(accounts);
          }
          pst.close();
       }catch(Exception e){
           
       }
    }
     static String temp;
    
    public void showdataclick(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            adddoctor adddoctor = tableview.getSelectionModel().getSelectedItem();
            String sql="select * from doctor_infor ";
               pst=con.prepareStatement(sql);
               temp=adddoctor.getLicense_No();
               lo_no.setText(adddoctor.getLicense_No());
               d_name.setText(adddoctor.getName());
               d_spe.setText(adddoctor.getSpecilization());
               D_ua.setText(adddoctor.getQualification());
               d_room_no.setText(adddoctor.getRoom_no());
               
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
           String sql="Update  doctor_infor set License_No=?,Name=?,specialization=?,qualification=?,room_no=? where License_No='"+temp+"'";
           pst=con.prepareStatement(sql);
           
            pst.setString(1,lo_no.getText() );
            pst.setString(2, d_name.getText());
            pst.setString(3, d_spe.getText());
            pst.setString(4, D_ua.getText());
            pst.setString(5,d_room_no.getText());
            pst.executeUpdate();
            accounts.clear();
            loaddata();
            JOptionPane.showMessageDialog(null,"Updated Successfully");
           
             
            
        }catch(Exception e){
            
        }  
    }
    
    
  @FXML
    void handledeleteAction(ActionEvent event){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           
            adddoctor adddoctor = tableview.getSelectionModel().getSelectedItem();
            String sql="Delete from doctor_infor where License_No=? ";
            
           
              pst=con.prepareStatement(sql);
              pst.setString(1, adddoctor.getLicense_No());
              pst.executeUpdate();
              pst.close();
              rs.close();
              accounts.clear();
              loaddata();
              JOptionPane.showMessageDialog(null,"Delete Successfully");
              lo_no.setText("");
              d_name.setText("");
              d_spe.setText("");
              D_ua.setText("");
              d_room_no.setText("");
            
          
        }catch(Exception e){
            
        }
    }  
    
    
    
}
