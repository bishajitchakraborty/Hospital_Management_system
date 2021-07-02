
package hms;

import static hms.AdddoctorController.temp;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class TestslistController implements Initializable {
   @FXML
    private TextField testtype;

    @FXML
    private TextField testname;

    @FXML
    private TextField price;

    @FXML
    private TableView<test> tableview;

    @FXML
    private TableColumn<test, String> col_type;

    @FXML
    private TableColumn<test, String> col_name;

    @FXML
    private TableColumn<test, String> col_price;

    ObservableList<test>accounts= FXCollections.observableArrayList();
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    @FXML
    public void handlesaveAction(ActionEvent event) throws SQLException{
       String type=testtype.getText();
       String  name=testname.getText();
       String tprice=price.getText();
      
       
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            String sql="Insert into testslist values(?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,type);
            pst.setString(2,name);
            pst.setString(3,tprice);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Account Create Successful");
            accounts.clear();
            showrecord();
            testtype.setText("");
            testname.setText("");
            price.setText("");
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static String temp;
    public void showdataclick(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
            test test = tableview.getSelectionModel().getSelectedItem();
            String sql="select * from testslist";
              temp=test.getTesttype();
               pst=con.prepareStatement(sql);
               testtype.setText(test.getTesttype());
               testname.setText(test.getTestname());
               price.setText(test.getTestprice());
              
            pst.close();
            rs.close();
        }catch(Exception e){
            
        }
       
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       col_type.setCellValueFactory(new PropertyValueFactory<>("testtype"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("testname"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("testprice"));
        showrecord();
    }      
     public void showrecord(){
        try{
         con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
          rs=con.createStatement().executeQuery("select * from testslist");
          while(rs.next()){
              accounts.add(new test(rs.getString("Test Type"),rs.getString("Test Name"),rs.getString("price")));
               tableview.setItems(accounts);
          }
          pst.close();
       }catch(Exception e){
           
       }
   }
   
   
     
     
   @FXML
    void handleupdateAction(ActionEvent event){
     
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           String sql="Update testslist set Test Type=?,Test Name=?,price=? where Test Type='"+temp+"'";
           pst=con.prepareStatement(sql);
           
            pst.setString(1,testtype.getText() );
            pst.setString(2,testname.getText());
            pst.setString(3,price.getText());
            pst.executeUpdate();
            accounts.clear();
            showrecord();
            JOptionPane.showMessageDialog(null,"Updated Successfully");
           
             
            
        }catch(Exception e){
            
        }  
    }
    
    
    
   @FXML
    void handledeleteAction(ActionEvent event){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hms","root","0000");
           
           test test = tableview.getSelectionModel().getSelectedItem();
            String sql="Delete from testslist where Test type=?";
            
           
              pst=con.prepareStatement(sql);
              pst.setString(1, test.getTesttype());
              pst.executeUpdate();
              pst.close();
              rs.close();
              accounts.clear();
              showrecord();;
              JOptionPane.showMessageDialog(null,"Delete Successfully");
              testtype.setText("");
              testname.setText("");
              price.setText("");
             
            
          
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
